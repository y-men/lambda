package q.webflux.demo.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.socket.WebSocketHandler;
import org.springframework.web.reactive.config.EnableWebFlux;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;
import org.springframework.web.reactive.handler.SimpleUrlHandlerMapping;
import org.springframework.web.reactive.socket.CloseStatus;
import org.springframework.web.reactive.socket.WebSocketMessage;
import org.springframework.web.reactive.socket.WebSocketSession;
import org.springframework.web.reactive.socket.server.support.WebSocketHandlerAdapter;
import org.springframework.web.reactive.HandlerAdapter;
import org.springframework.web.reactive.HandlerMapping;
import org.springframework.web.socket.config.annotation.EnableWebSocket;

import lombok.extern.slf4j.Slf4j;
import q.webflux.demo.web.NumbersHandler;
import reactor.core.publisher.Mono;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;

import java.time.Duration;
import java.util.HashMap;

/**
 * NumberServiceConfig
 */

@Configuration
@EnableWebFlux
@EnableWebSocket
@Slf4j
public class NumberServiceConfig {
    @Autowired
    NumbersHandler numbersHandler;

    @Bean
    public RouterFunction<ServerResponse> routing() {
        return RouterFunctions
            .route(POST("/numbersDuration/{d}"), 
                    r -> { 
                        Duration d = Duration.ofSeconds(Long.valueOf(r.pathVariable("d")));
                        return ok().build();
                    }
                    );
    }


    @Bean
    public HandlerMapping wsHandlerMapping() {
        HashMap<String, WebSocketHandler> map = new HashMap<>();

        map.put("/numbers/", numbersHandler);

        SimpleUrlHandlerMapping mapping = new SimpleUrlHandlerMapping();
        mapping.setUrlMap(map);
        mapping.setOrder(-1);
        return mapping;
    }

    @Bean
    HandlerAdapter wsHandlerAdapter() {
        return new WebSocketHandlerAdapter();
    }
}
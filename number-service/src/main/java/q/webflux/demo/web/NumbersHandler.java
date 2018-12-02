package q.webflux.demo.web;

import java.time.Duration;

import org.springframework.stereotype.Component;
import org.springframework.web.reactive.socket.WebSocketHandler;
import org.springframework.web.reactive.socket.WebSocketMessage;
import org.springframework.web.reactive.socket.WebSocketSession;

import lombok.extern.slf4j.Slf4j;
import q.webflux.demo.services.NumbersService;
import reactor.core.publisher.Mono;

/**
 * NumbersHandler
 */
@Component
@Slf4j
public class NumbersHandler implements WebSocketHandler {
    NumbersService numbersService;

    public NumbersHandler(NumbersService numbersService) {
        this.numbersService = numbersService;
    }

    @Override
    public Mono<Void> handle(WebSocketSession session) {
        log.debug(" >> NumbersHandler::handle ");

        return session.send(
            numbersService.fetchLongStream(Duration.ofSeconds(2) )
            .map(l->String.valueOf(l))
            .map(session::textMessage)
            );
                // session.receive()
                // .map(numbersService.fetchLongStream(Duration.ofSeconds(2))
                //         .map(tMessage -> "Response From Server: " + tMessage)
                //         .map(session::textMessage));
    }
}
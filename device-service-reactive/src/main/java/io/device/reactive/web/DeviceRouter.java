package io.device.reactive.web;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;


//@Configuration
public class DeviceRouter {
    @Bean
    public RouterFunction<ServerResponse> route(DeviceHandler deviceHandler) {
        return RouterFunctions
                .route(GET("/list")
                                .and(accept(MediaType.APPLICATION_JSON)),
                        deviceHandler::listDevices)
                .andRoute(GET("/list")
                                .and(accept(MediaType.APPLICATION_STREAM_JSON)),
                        deviceHandler::streamDevices
                );
    }
}

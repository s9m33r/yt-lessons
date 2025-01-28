package com.example.router;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.example.handlers.MenuHandler;

@Configuration
public class Router {

    @Bean
    public RouterFunction<ServerResponse> menuRouter(MenuHandler menuHandler) {
        return RouterFunctions.route()
            .POST("/v1/menu", menuHandler::createMenuItem)
            .build();
    }

}

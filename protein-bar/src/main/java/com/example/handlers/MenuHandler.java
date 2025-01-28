package com.example.handlers;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.example.client.NutritionAPIClient;
import com.example.dto.MenuItem;

import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

@Component
public class MenuHandler {
    private NutritionAPIClient nutritionAPIClient;

    @Autowired
    public MenuHandler(NutritionAPIClient nutritionAPIClient) {
        this.nutritionAPIClient = nutritionAPIClient;
    }

    public Mono<ServerResponse> createMenuItem(ServerRequest serverRequest) {
        return serverRequest
            .bodyToMono(MenuItem.class)
            .publishOn(Schedulers.boundedElastic())
            .flatMap(menuItem -> nutritionAPIClient.enrich(menuItem))
            .flatMap(menuItem -> ServerResponse
                .ok()
                .bodyValue(menuItem));
    }

}

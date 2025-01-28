package com.example.client;

import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import com.example.dto.MenuItem;
import com.example.dto.Nutrition;

import reactor.core.publisher.Mono;

@Component
public class NutritionAPIClient {

    private WebClient webClient;

    public NutritionAPIClient() {
        this.webClient = WebClient.builder().baseUrl("http://localhost:8081").build();
    }

    public Mono<MenuItem> enrich(MenuItem menuItem) {
        return webClient.get()
            .uri("v1/nutrition/{name}", menuItem.name())
            .retrieve()
            .bodyToMono(Nutrition.class)
            .map(nutrition -> new MenuItem(menuItem.name(), menuItem.ingredients(), nutrition));
    }
}

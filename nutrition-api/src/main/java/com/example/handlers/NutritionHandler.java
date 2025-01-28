package com.example.handlers;

import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.HandlerFunction;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.example.dto.Nutrition;

import reactor.core.publisher.Mono;

@Component
public class NutritionHandler implements HandlerFunction<ServerResponse> {

    @Override
    public @NonNull Mono<ServerResponse> handle(@NonNull ServerRequest request) {
        Nutrition nutrition = new Nutrition(100, 10, 20, 10, 400);
        return ServerResponse
            .ok()
            .bodyValue(nutrition);
    }
}

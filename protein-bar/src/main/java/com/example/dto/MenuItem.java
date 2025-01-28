package com.example.dto;

import java.util.List;

public record MenuItem(String name, List<String> ingredients, Nutrition nutrition) {
}

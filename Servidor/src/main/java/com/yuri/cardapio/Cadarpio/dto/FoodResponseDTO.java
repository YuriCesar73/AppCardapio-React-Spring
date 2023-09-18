package com.yuri.cardapio.Cadarpio.dto;

import com.yuri.cardapio.Cadarpio.model.Food;

public record FoodResponseDTO(Long id, String title, String image, Integer price) {

	public FoodResponseDTO(Food food) {
		this(food.getId(), food.getTitle(), food.getImage(), food.getPrice());
	}
}

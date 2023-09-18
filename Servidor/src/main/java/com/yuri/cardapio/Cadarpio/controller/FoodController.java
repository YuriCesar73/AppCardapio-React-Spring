package com.yuri.cardapio.Cadarpio.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yuri.cardapio.Cadarpio.repository.FoodRepository;
import com.yuri.cardapio.Cadarpio.dto.FoodRequestDTO;
import com.yuri.cardapio.Cadarpio.dto.FoodResponseDTO;
import com.yuri.cardapio.Cadarpio.model.Food;

@RestController
@RequestMapping("/food")
public class FoodController {
	
	@Autowired
	private FoodRepository foodRepository;

	@CrossOrigin(origins = "*", allowedHeaders = "*") //Feito para evitar possíveis verificações do navegador
	@GetMapping
	public List<FoodResponseDTO> getAll() {

		List<Food> foodList = foodRepository.findAll();
		List<FoodResponseDTO> finalFoodList = new ArrayList<FoodResponseDTO>();
		for (Food food : foodList) {
			FoodResponseDTO foodResponse = new FoodResponseDTO(food);
			finalFoodList.add(foodResponse);
		}
		return finalFoodList;
 	} 
	 
//	@CrossOrigin(origins = "http://localhost:5173")

	@CrossOrigin(origins = "*", allowedHeaders = "*") //Feito para evitar possíveis verificações do navegador
	@PostMapping
	public void saveFood(@RequestBody FoodRequestDTO foodData) {
		
		Food food = new Food(foodData);
		foodRepository.save(food);
	}
}

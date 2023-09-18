package com.yuri.cardapio.Cadarpio.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yuri.cardapio.Cadarpio.model.Food;

public interface FoodRepository extends JpaRepository<Food, Long>{

}

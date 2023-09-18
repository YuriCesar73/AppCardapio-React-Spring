package com.yuri.cardapio.Cadarpio.model;

import com.yuri.cardapio.Cadarpio.dto.FoodRequestDTO;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
//import lombok.AllArgsConstructor;
//import lombok.EqualsAndHashCode;
//import lombok.Getter;
//import lombok.NoArgsConstructor;

@Table(name = "Foods")
@Entity(name = "foods")
//@Getter
//@AllArgsConstructor
//@NoArgsConstructor
//@EqualsAndHashCode

public class Food {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String title;
	private String image;
	private Integer price;

	
	public Food() {
		
	}
	
	public Food(Long id, String title, String image, Integer price) {
		super();
		this.id = id;
		this.title = title;
		this.image = image;
		this.price = price;
	}
	
	public Food(FoodRequestDTO data) {
		this.title = data.title();
		this.image = data.image();
		this.price = data.price();
		}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	
	
	

}

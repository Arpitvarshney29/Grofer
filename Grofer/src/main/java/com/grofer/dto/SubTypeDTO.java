package com.grofer.dto;

import java.util.Optional;

import com.grofer.entity.SubType;

public class SubTypeDTO {
	private int id;
	private String name;
	private float price;
	private float weight;
	private String brand;
	public SubTypeDTO() {
		
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}

	public float getWeight() {
		return weight;
	}
	public void setWeight(float weight) {
		this.weight = weight;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	
	public SubTypeDTO(SubType subType)
	{
		this.id=subType.getId();
		this.name=subType.getName();
		this.price=subType.getPrice();
		this.weight=subType.getWeight();
		this.brand=subType.getBrand();
		
	}

	public SubType getSubTypeEntity(SubType subType)
	{
		subType.setId(this.id);
		subType.setName(this.name);
		subType.setPrice(this.price);
		subType.setWeight(this.weight);
		subType.setBrand(this.brand);
	
	return subType;
	}

}

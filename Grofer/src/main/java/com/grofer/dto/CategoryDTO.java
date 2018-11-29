package com.grofer.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.grofer.entity.Category;
import com.grofer.entity.Type;

public class CategoryDTO {
	private int id;
	private String name;
	private List<TypeDTO> typeDto;

	public CategoryDTO() {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<TypeDTO> getTypeDto() {
		return typeDto;
	}

	public void setTypeDto(List<TypeDTO> typeDto) {
		this.typeDto = typeDto;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public CategoryDTO(Category category) {
		this.id = category.getId();
		this.name = category.getName();
		if (category.getType() != null) {
			this.typeDto = category.getType().stream().map(TypeDTO::new).collect(Collectors.toList());
		}
	}

	public Category getCategoryEntity(Category category) {
		category.setId(this.id);
		category.setName(this.name);
		if (this.typeDto != null) {
			category.setType(
					this.typeDto.stream().map(dto -> dto.getTypeEntity(new Type())).collect(Collectors.toList()));
		}

		return category;
	}

}

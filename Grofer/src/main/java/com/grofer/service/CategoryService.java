package com.grofer.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grofer.dto.CategoryDTO;
import com.grofer.dto.TypeDTO;
import com.grofer.entity.Category;
import com.grofer.entity.Type;
import com.grofer.repository.CategoryRepository;
import com.grofer.repository.TypeRepository;

@Service
public class CategoryService {

	@Autowired
	CategoryRepository categoryRepository;

	@Autowired
	TypeRepository typeRepository;

	public CategoryDTO createByCategories(CategoryDTO categoryDto) throws Exception {

		Category category = categoryDto.getCategoryEntity(new Category());
		if (category == null)
			throw new Exception("category can not be null");
		return new CategoryDTO(categoryRepository.save(category));
	}

	public List<CategoryDTO> getAll() throws Exception {

		List<Category> category = categoryRepository.findAll();
		if (category == null)
			throw new Exception("category not be null");
		List<CategoryDTO> categoryDto = category.stream().map(CategoryDTO::new).collect(Collectors.toList());
		return categoryDto;
	}

	public CategoryDTO getByCategoryId(int id) {
		Category category = categoryRepository.findById(id).orElse(null);
		return new CategoryDTO(category);
	}

	public List<CategoryDTO> getByCategoryName(String name) throws Exception {
		// Category category =
		// categoryRepository.findByName(name).stream().findFirst().orElse(null);
		List<Category> category = categoryRepository.findByName(name);
		if (category == null)
			throw new Exception("name can not be null");
		List<CategoryDTO> category1 = category.stream().map(t -> new CategoryDTO(t)).collect(Collectors.toList());
		return category1;
	}

	public CategoryDTO getByCategoryFirstName(String name) {
		Category category = categoryRepository.findByName(name).stream().findFirst().orElse(null);
		return new CategoryDTO(category);
	}

	public List<CategoryDTO> createAll(List<CategoryDTO> categoryDto) {
		List<Category> categoryList = new ArrayList<>();
//			for(CategoryDTO c:categoryDto)
//			{
//				Category category=c.getCategoryEntity(new Category());
//				categoryList.add(category);
//			}
		categoryDto.stream().map(d -> {
			Category categoryEntity = d.getCategoryEntity(new Category());
			categoryList.add(categoryEntity);
			return categoryEntity;
		}).collect(Collectors.toList());

		categoryRepository.saveAll(categoryList);
		List<CategoryDTO> categoryDto1 = categoryList.stream().map(CategoryDTO::new).collect(Collectors.toList());
		return categoryDto1;
	}

}

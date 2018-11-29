package com.grofer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.grofer.dto.CategoryDTO;
import com.grofer.service.CategoryService;

@RestController
@RequestMapping("Category")
public class CategoryController {

	@Autowired
	public CategoryService categoryService;

	@PostMapping("/all")
	public List<CategoryDTO> createAll(@RequestBody List<CategoryDTO> categoryDto) {
		return categoryService.createAll(categoryDto);
	}

	@PostMapping("/one")
	public CategoryDTO create(@RequestBody CategoryDTO categoryDto) throws Exception {
		return categoryService.createByCategories(categoryDto);
	}

	@GetMapping(value = "/{id}")
	public CategoryDTO getByCategoryId(@PathVariable("id") int id) {
		return categoryService.getByCategoryId(id);
	}

	@GetMapping("/all")
	public List<CategoryDTO> getAll() throws Exception {
		return categoryService.getAll();
	}

	@GetMapping(value = "/firstall/{name}")
	public CategoryDTO getByCategoryFirstName(@PathVariable("name") String name) {
		return categoryService.getByCategoryFirstName(name);
	}

	@GetMapping(value = "/alllist/{name}")
	public List<CategoryDTO> getByCategoryName(@PathVariable("name") String name) throws Exception {
		return categoryService.getByCategoryName(name);
	}

//	@GetMapping(value="/{type}")
//	public List<String> getByType(@PathVariable("type") String type)
//	{
//		return groferService.getByType();
//		
//	}

}

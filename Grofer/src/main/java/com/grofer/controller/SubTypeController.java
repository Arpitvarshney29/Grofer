package com.grofer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.grofer.dto.SubTypeDTO;
import com.grofer.service.SubTypeService;

@RestController
@RequestMapping("SubType")
public class SubTypeController {
	
	@Autowired
	SubTypeService subTypeService;
	
	@PostMapping("/all")
	public SubTypeDTO create(@RequestBody SubTypeDTO subTypeDto)
	{
		return subTypeService.create(subTypeDto);
	}
	@GetMapping(value= "/{name}")
	public SubTypeDTO getByName(@PathVariable ("name") String name)
	{
		return subTypeService.getByName(name);
	}
	@GetMapping(value= "/{id}")
	public SubTypeDTO getById(@PathVariable ("name") int id)
	{
		return subTypeService.getById(id);
	}
	

}

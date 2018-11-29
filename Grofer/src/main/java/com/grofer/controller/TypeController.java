package com.grofer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.grofer.dto.TypeDTO;
import com.grofer.service.TypeService;

@RestController
@RequestMapping("Type")
public class TypeController {

	@Autowired
	TypeService typeService;

	@PostMapping(value="/one")
	public TypeDTO Create(@RequestBody TypeDTO typeDto) throws Exception {
		return typeService.createByType(typeDto);
	}

	@GetMapping(value="/all")
	public List<TypeDTO> getAll() throws Exception {
		return typeService.getAll();
	}

	@GetMapping("/{id}")
	public TypeDTO getById(@PathVariable("id") int id)
	{
		return typeService.getById(id);
	}
	@GetMapping(value = "/firstall/{name}")
	public TypeDTO getByTypeName(@PathVariable("name") String name) throws Exception {
		return typeService.getByTypeName(name);
	}

}

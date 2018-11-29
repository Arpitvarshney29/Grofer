package com.grofer.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grofer.dto.SubTypeDTO;
import com.grofer.entity.SubType;
import com.grofer.repository.SubTypeRepository;

@Service
public class SubTypeService {

	@Autowired
	SubTypeRepository subTypeRepository;

	public SubTypeDTO create(SubTypeDTO subTypeDto) {
		SubType subType = subTypeDto.getSubTypeEntity(new SubType());
		return new SubTypeDTO(subTypeRepository.save(subType));
	}

	public SubTypeDTO getById(int id) {
		SubType subType = subTypeRepository.findById(id).get();
		return new SubTypeDTO(subType);
	}

	public SubTypeDTO getByName(String name) {
		SubType subType = subTypeRepository.findByName(name);
		return new SubTypeDTO(subType);
	}

}

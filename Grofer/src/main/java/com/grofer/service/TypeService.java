package com.grofer.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grofer.dto.TypeDTO;
import com.grofer.entity.Type;
import com.grofer.repository.TypeRepository;

@Service
public class TypeService {

	@Autowired
	TypeRepository typeRepository;

	public TypeDTO createByType(TypeDTO typeDto) throws Exception {
		Type type = typeDto.getTypeEntity(new Type());
		if (type == null)
			throw new Exception("Type can not be null");
		return new TypeDTO(typeRepository.save(type));
	}



	public List<TypeDTO> getAll() throws Exception {
		List<Type> type = typeRepository.findAll();
		if (type == null)
			throw new Exception("type can not be null");
		List<TypeDTO> typeDto = type.stream().map(dto -> new TypeDTO(dto)).collect(Collectors.toList());
		return typeDto;
	}
	public TypeDTO getById(int id) {
		Type type=typeRepository.findById(id).orElse(null);
		return new TypeDTO(type);
	}
	
	public TypeDTO getByTypeName(String name) throws Exception {
		Type type = typeRepository.findByName(name).stream().findFirst().orElse(null);
		if (type == null)
			throw new Exception("name can not be null");
		return new TypeDTO(type);
	}
	

}

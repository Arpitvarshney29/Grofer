package com.grofer.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.grofer.entity.SubType;
import com.grofer.entity.Type;

public class TypeDTO {
	private int id;
	private String name;
	private List<SubTypeDTO> subTypeDto;
	public TypeDTO() {
		
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
	public List<SubTypeDTO> getSubTypeDto() {
		return subTypeDto;
	}
	public void setSubTypeDto(List<SubTypeDTO> subTypeDto) {
		this.subTypeDto = subTypeDto;
	}
	public TypeDTO(Type type)
	{
		this.id=type.getId();
		this.name=type.getName();
		if(type.getSubType()!=null)
		{
			this.subTypeDto=type.getSubType().stream().map(SubTypeDTO::new).collect(Collectors.toList());
		}
	}	
	public Type getTypeEntity(Type type)
	{
		type.setId(this.id);
		type.setName(this.name);
		if(this.subTypeDto!=null)
		{
		type.setSubType( this.subTypeDto.stream().map(dt->dt.getSubTypeEntity(new SubType())).collect(Collectors.toList()));
		}
		return  type;
	}
	


}

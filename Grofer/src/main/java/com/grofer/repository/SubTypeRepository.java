package com.grofer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.grofer.entity.SubType;

@Repository
public interface SubTypeRepository extends JpaRepository<SubType, Integer> {

	public SubType findByName(String name);

}

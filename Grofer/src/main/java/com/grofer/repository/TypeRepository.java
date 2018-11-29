package com.grofer.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.grofer.entity.Type;

@Repository
public interface TypeRepository extends JpaRepository<Type, Integer> {


	public List<Type> findByName(String name);



}

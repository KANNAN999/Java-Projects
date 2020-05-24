package com.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.entity.CakeOrderEntity;

public interface CakeOrderDAO extends JpaRepository<CakeOrderEntity, Integer> {

	
	
	
}

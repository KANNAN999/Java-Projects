package com.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.entity.CakeEntity;

public interface CakeDAO extends JpaRepository<CakeEntity, Integer> {

}

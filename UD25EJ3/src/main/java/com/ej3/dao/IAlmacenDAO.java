package com.ej3.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ej3.dto.Almacen;

public interface IAlmacenDAO extends JpaRepository<Almacen, Long>{
	
}

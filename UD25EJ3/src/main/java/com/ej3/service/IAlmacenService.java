package com.ej3.service;

import java.util.List;

import com.ej3.dto.Almacen;

public interface IAlmacenService {

	//Métodos del CRUD
	public List<Almacen> listarAlmacenes(); //Listar All
	
	public Almacen guardarAlmacen(Almacen Almacen); //Guarda un Almacen CREATE
	
	public Almacen almacenXID(Long id); //Leer datos de un Almacen READ
	
	public Almacen actualizarAlmacen(Almacen Almacen); //Actualiza datos del Almacen UPDATE
	
	public void eliminarAlmacen(Long id);//Elimina el Almacen DELETE
}

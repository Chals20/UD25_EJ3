package com.ej3.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ej3.dao.IAlmacenDAO;
import com.ej3.dto.Almacen;

@Service 
public class AlmacenServiceImpl implements IAlmacenService{

	@Autowired
	IAlmacenDAO iAlmacenDAO;
	
	@Override
	public List<Almacen> listarAlmacenes() {
		// TODO Auto-generated method stub
		return iAlmacenDAO.findAll();
	}

	@Override
	public Almacen guardarAlmacen(Almacen Almacen) {
		// TODO Auto-generated method stub
			return iAlmacenDAO.save(Almacen); //guardo el nuevo Almacen	
	}

	@Override
	public Almacen almacenXID(Long id) {
		// TODO Auto-generated method stub
		return iAlmacenDAO.findById(id).get();
	}

	@Override
	public Almacen actualizarAlmacen(Almacen Almacen) {
		// TODO Auto-generated method stub
		return iAlmacenDAO.save(Almacen);
	}

	@Override
	public void eliminarAlmacen(Long id) {
		iAlmacenDAO.deleteById(id);
		
	}
}

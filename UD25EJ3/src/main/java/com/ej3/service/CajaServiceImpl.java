package com.ej3.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ej3.dao.ICajaDAO;
import com.ej3.dto.Caja;

@Service 
public class CajaServiceImpl implements ICajaService{

	@Autowired
	ICajaDAO iCajaDAO;
	
	@Override
	public List<Caja> listarCajas() {
		// TODO Auto-generated method stub
		return iCajaDAO.findAll();
	}

	@Override
	public Caja guardarCaja(Caja Caja) {
		// TODO Auto-generated method stub
			return iCajaDAO.save(Caja); //guardo el nuevo Caja	
	}

	@Override
	public Caja cajaXID(Long id) {
		// TODO Auto-generated method stub
		return iCajaDAO.findById(id).get();
	}

	@Override
	public Caja actualizarCaja(Caja Caja) {
		// TODO Auto-generated method stub
		return iCajaDAO.save(Caja);
	}

	@Override
	public void eliminarCaja(Long id) {
		iCajaDAO.deleteById(id);
		
	}
}

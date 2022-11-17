package com.ej3.controller;

import java.util.List;
import com.ej3.dto.Almacen;
import com.ej3.service.AlmacenServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class AlmacenController {

	@Autowired
	AlmacenServiceImpl alm;
	
	//listar almacenes
	@GetMapping("/almacenes")
	public List<Almacen> listarAlmacenes(){
		return alm.listarAlmacenes();
	}
	
	//guardar almacen
	@PostMapping("/almacenes")
	public Almacen guardarAlmac(@RequestBody Almacen Almacen) {
		return alm.guardarAlmacen(Almacen);
	}
	
	//mostrar almacen según el ID 
	@GetMapping("/almacenes/{id}") 
	public Almacen AlmacenXID(@PathVariable(name="id") Long id){ 
		Almacen almacenID = new Almacen();
		
		almacenID=alm.almacenXID(id);
		
		System.out.println("Almacen XID: "+almacenID);
		
		return almacenID;
	}
	
	//actualizar almacen según el ID
	@PutMapping("/almacenes/{id}")
	public Almacen actualizarAlmacen(@PathVariable(name="id")Long id,@RequestBody Almacen Almacen) {
		
		Almacen alm_select= new Almacen();
		Almacen alm_actualizar= new Almacen();
		
		alm_select= alm.almacenXID(id);
		
		alm_select.setLugar(Almacen.getLugar());
		alm_select.setCapacidad(Almacen.getCapacidad());
		alm_select.setCaja(Almacen.getCaja());
		
		alm_actualizar = alm.actualizarAlmacen(alm_select);
		
		System.out.println("El Almacen actualizado es: "+ alm_actualizar);
		
		return alm_actualizar;
	}
	
	//eliminar almacen por ID
	@DeleteMapping("/almacenes/{id}")
	public void eleiminarAlmacen(@PathVariable(name="id")Long id) {
		alm.eliminarAlmacen(id);
	}
}

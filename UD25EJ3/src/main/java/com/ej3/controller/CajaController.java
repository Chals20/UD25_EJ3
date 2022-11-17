package com.ej3.controller;

import java.util.List;
import com.ej3.dto.Caja;
import com.ej3.service.CajaServiceImpl;

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
public class CajaController {

	@Autowired
	CajaServiceImpl cajas;
	
	//listar cajas
	@GetMapping("/cajas")
	public List<Caja> listarCajas(){
		return cajas.listarCajas();
	}
	
	//guardar caja
	@PostMapping("/cajas")
	public Caja salvarCaja(@RequestBody Caja caja) {
		return cajas.guardarCaja(caja);
	}
	
	//muestro un Caja según el ID indicada
	@GetMapping("/cajas/{id}") 
	public Caja CajaXID(@PathVariable(name="id") Long id){ 
		Caja cajaID = new Caja();

		cajaID=cajas.cajaXID(id);

		System.out.println("Caja XID: "+cajaID);
		
		return cajaID;
	}
	
	//actualizar caja por ID
	@PutMapping("/cajas/{id}")
	public Caja actualizarCaja(@PathVariable(name="id")Long id,@RequestBody Caja caja) {
		
		Caja caja_select= new Caja();
		Caja caja_actualizar= new Caja();
		
		caja_select= cajas.cajaXID(id);
		
		caja_select.setContenido(caja.getContenido());
		caja_select.setValor(caja.getValor());
		caja_select.setAlmacen(caja.getAlmacen());
		
		caja_actualizar = cajas.actualizarCaja(caja_select);
		
		System.out.println("Caja actualizada es: "+ caja_actualizar);
		
		return caja_actualizar;
	}
	
	//eliminar caja ID
	@DeleteMapping("/cajas/{id}")
	public void eleiminarCaja(@PathVariable(name="id")Long id) {
		cajas.eliminarCaja(id);
	}
}

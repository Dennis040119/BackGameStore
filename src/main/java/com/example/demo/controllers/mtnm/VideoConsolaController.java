package com.example.demo.controllers.mtnm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.enums.Rol;
import com.example.demo.entity.mtnm.VideoConsola;
import com.example.demo.service.mtnm.VideoConsolaServiceImpl;

@RestController
@Controller
@RequestMapping("/videoconsola")
@CrossOrigin(origins = "http://localhost:4200")
public class VideoConsolaController {
	
	@Autowired
	private VideoConsolaServiceImpl service;

	
	@GetMapping("/vclist")
	@ResponseBody
	public ResponseEntity<List<VideoConsola>> listaVc() {
		List<VideoConsola> lista = service.listar();
		return ResponseEntity.ok(lista);
	}
	
	
	@GetMapping("/vcBuscar/{id}")
	@ResponseBody
	public List<Optional<VideoConsola>> VcXid(@PathVariable String id) {
		
		//encrypto
		List<Optional<VideoConsola>> lista = new ArrayList<>();
		try {
			
			
			Optional<VideoConsola> usu = service.buscar(id);
			if(usu.isPresent()) {
				lista.add(usu);
				return lista ;
			}else {return lista;}
		} catch (Exception e) {
			
			e.printStackTrace();
			return lista;
			}
		}
	
	@PostMapping("/VcSave")
	@ResponseBody
	public  ResponseEntity<Map<String, Object>> SaveVJ(@RequestBody VideoConsola obj) {
		
		//CREAMOS UN MAP, QUE ALMACENARA LOS MENSAJES DE EXITOS O ERRORES
		Map<String, Object> salida = new HashMap<>();
		//Intentamos la transaccion
		if( (service.buscar(obj.getVcid())).isPresent()  ) {
			
			salida.put("mensaje", "Ya existe el videojuego");
			
		}else {
			try {
				
				
				obj.setVcid(VideoConsola.generarcodigo(service.listar().size()));
				
				System.out.println(obj.toString());
				service.save(obj);
				
				
				salida.put("mensaje", "Registrado correctamente");
			} catch (Exception e) {salida.put("mensaje", "Error al registrar: " +e);}
			 
			}
		
		
		
		return ResponseEntity.ok(salida);
	}
	
	@PutMapping("/VcPut")
	@ResponseBody
	public  ResponseEntity<Map<String, Object>> PutVJ(@RequestBody VideoConsola obj) {
		
		//CREAMOS UN MAP, QUE ALMACENARA LOS MENSAJES DE EXITOS O ERRORES
		Map<String, Object> salida = new HashMap<>();
		//Intentamos la transaccion
		
		if( (service.buscar(obj.getVcid())).isEmpty()  ) {
			
			salida.put("mensaje", "No existe la VideoConsola");
			
		}else {
			try {
				obj.setRol(Rol.VIDEOCONSOLA.getCodigo());  
				System.out.println(obj.toString());
				service.save(obj);
				
				salida.put("mensaje", "Actualizado correctamente");
			} catch (Exception e) {salida.put("mensaje", "Error al actualizar: " +e);}
			}
		
		
		
		return ResponseEntity.ok(salida);
	}
	
	@DeleteMapping("/VcDelete/{id}")
	@ResponseBody
	public  ResponseEntity<Map<String, Object>> eliminarVJ(@PathVariable String id) {
		
		//CREAMOS UN MAP, QUE ALMACENARA LOS MENSAJES DE EXITOS O ERRORES
		Map<String, Object> salida = new HashMap<>();
		//Intentamos la transaccion
		
		if(  (service.buscar(id)).isEmpty()  ) {
			
			salida.put("mensaje", "No existe la VideoConsola");
			
		}else {
			try {
				
				service.delete(id);
				salida.put("mensaje", "Elimnado correctamente");
			} catch (Exception e) {salida.put("mensaje", "Error al eliminar: " +service.buscar(id));}
		}
		
		
		
		return ResponseEntity.ok(salida);
	}
}

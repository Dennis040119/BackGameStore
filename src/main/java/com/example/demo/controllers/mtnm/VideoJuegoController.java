package com.example.demo.controllers.mtnm;

import java.io.File;
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
import com.example.demo.entity.mtnm.Videojuego;
import com.example.demo.service.mtnm.VideoJuegoServiceImpl;

@RestController
@Controller
@RequestMapping("/videojuego")
@CrossOrigin(origins = "http://localhost:4200")
public class VideoJuegoController {
	
	@Autowired
	private VideoJuegoServiceImpl service;
	
	File file;
	
	@GetMapping("/videoJuegoList")
	@ResponseBody
	public ResponseEntity<Object> listaVJ() {
		
		try {
			List<Videojuego> lista = service.listar();
			return ResponseEntity.ok(lista);
		} catch (Exception e) {
			
			return ResponseEntity.ok(e);
			
		}
		
	}
	
	@GetMapping("/vjBuscar/{id}")
	@ResponseBody
	public List<Optional<Videojuego>> VcXid(@PathVariable("id") String id) {
		
		//encrypto
		List<Optional<Videojuego>> lista = new ArrayList<>();
		try {
			
			
			Optional<Videojuego> usu = service.buscarPorId(id);
			if(usu.isPresent()) {
				lista.add(usu);
				return lista ;
			}else {return lista;}
		} catch (Exception e) {
			
			e.printStackTrace();
			return lista;
			}
	}
	
	@PostMapping("/videoJuegoSave")
	@ResponseBody
	public  ResponseEntity<Map<String, Object>> SaveVJ(@RequestBody Videojuego obj) {
		
		//CREAMOS UN MAP, QUE ALMACENARA LOS MENSAJES DE EXITOS O ERRORES
		Map<String, Object> salida = new HashMap<>();
		//Intentamos la transaccion
		if((service.buscarPorNombre(obj.getNombre())).size()> 0  ) {
			
			salida.put("mensaje", "Ya existe el videojuego");
			
		}else {
			try {
				
				
				obj.setId(Videojuego.generarcodigo(service.listar().size()));
				obj.setRol(Rol.VIDEOJUEGO.getCodigo());
				service.registrar(obj);
				
				System.out.println(obj);
				salida.put("mensaje", "Registrado correctamente");
			} catch (Exception e) {salida.put("mensaje", "Error al registrar: " +e);}
			 
			}
		
		
		
		return ResponseEntity.ok(salida);
	}
	
	
	@PutMapping("/videoJuegoPut")
	@ResponseBody
	public  ResponseEntity<Map<String, Object>> PutVJ(@RequestBody Videojuego obj) {
		
		//CREAMOS UN MAP, QUE ALMACENARA LOS MENSAJES DE EXITOS O ERRORES
		Map<String, Object> salida = new HashMap<>();
		//Intentamos la transaccion
		
		if(service.buscarPorId(obj.getId())==null   ) {
			
			salida.put("mensaje", "No existe el videojuego");
			
		}else {
			try {
				obj.setRol(Rol.VIDEOJUEGO.getCodigo());  
				service.registrar(obj);
				System.out.println(obj);
				salida.put("mensaje", "Actualizado correctamente");
			} catch (Exception e) {salida.put("mensaje", "Error al actualizar: " +e);}
			}
		
		
		
		return ResponseEntity.ok(salida);
	}
	
	
	@DeleteMapping("/videoJuegoDelete/{id}")
	@ResponseBody
	public  ResponseEntity<Map<String, Object>> eliminarVJ(@PathVariable("id") String id) {
		
		//CREAMOS UN MAP, QUE ALMACENARA LOS MENSAJES DE EXITOS O ERRORES
		Map<String, Object> salida = new HashMap<>();
		//Intentamos la transaccion
		
		if(service.buscarPorId(id).isPresent()== false  ) {
			
			salida.put("mensaje", "No existe el videojuego");
			
		}else {
			try {
				service.eliminar(id);
				salida.put("mensaje", "Elimnado correctamente");
			} catch (Exception e) {salida.put("mensaje", "Error al eliminar: " +service.buscarPorId(id));}
		}
		
		
		
		return ResponseEntity.ok(salida);
	}

}

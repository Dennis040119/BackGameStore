package com.example.demo.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Rol;
import com.example.demo.entity.VideoJuego;
import com.example.demo.service.VideoJuegoRepositoryImpl;

@RestController
@Controller
@RequestMapping("/videojuego")
@CrossOrigin(origins = "http://localhost:4200")
public class VideoJuegoController {
	
	@Autowired
	private VideoJuegoRepositoryImpl service;
	
	@GetMapping("/videoJuegoList")
	@ResponseBody
	public ResponseEntity<Object> listaVJ() {
		
		try {
			List<VideoJuego> lista = service.listar();
			return ResponseEntity.ok(lista);
		} catch (Exception e) {
			
			return ResponseEntity.ok(e);
			
		}
		
	}
	
	@PostMapping("/videoJuegoSave")
	@ResponseBody
	public  ResponseEntity<Map<String, Object>> SaveVJ(@RequestBody VideoJuego obj) {
		
		//CREAMOS UN MAP, QUE ALMACENARA LOS MENSAJES DE EXITOS O ERRORES
		Map<String, Object> salida = new HashMap<>();
		//Intentamos la transaccion
		try {
			obj.setRol(Rol.VIDEOJUEGO.getCodigo());  
			obj.setId(0);
			service.save(obj);
			salida.put("mensaje", "Registrado correctamente");
		} catch (Exception e) {
			salida.put("mensaje", "Error al registrar: " +e);
		}
		
		return ResponseEntity.ok(salida);
	}

}

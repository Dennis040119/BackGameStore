package com.example.demo.controllers;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.enums.Genero;
import com.example.demo.entity.enums.Marca;
import com.example.demo.entity.enums.Plataforma;
import com.example.demo.service.GeneroServiceImpl;
import com.example.demo.service.PlataformasServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@Controller
@RequestMapping("/enums")
@CrossOrigin(origins = "http://localhost:4200")
public class EnumController {
	
	@Autowired
	private GeneroServiceImpl serviceGen;
	
	@Autowired
	private PlataformasServiceImpl servicePlat;
	
	@GetMapping("/PlataformaList")
	@ResponseBody
	public ResponseEntity<Object> listaPlat() {
		
		try {
			
			List<Plataforma> plataformas = servicePlat.listar();
			return ResponseEntity.ok(plataformas);
		} catch (Exception e) {
			
			return ResponseEntity.ok(e);
			
		}
		
	}
	
	@GetMapping("/GeneroList")
	@ResponseBody
	public ResponseEntity<Object> listaGen() {
		
		try {
			
			List<Genero> generos = serviceGen.listar();
			
			

			return ResponseEntity.ok(generos);
		} catch (Exception e) {
			
			return ResponseEntity.ok(e);
			
		}
		
	}
	
	@GetMapping("/MarcaList")
	@ResponseBody
	public ResponseEntity<Object> listaMarca() {
		ObjectMapper objectMapper = new ObjectMapper();
		
		try {
			
			List<Marca> marcas= new ArrayList<Marca>();

			marcas=Marca.addMarcas(marcas);
			
			String listaEnumeradorJson = objectMapper.writeValueAsString(marcas);


			return ResponseEntity.ok(marcas);
		} catch (Exception e) {
			
			return ResponseEntity.ok(e);
			
		}
		
	}
	
	
}

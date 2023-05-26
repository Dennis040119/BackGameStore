package com.example.demo.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Plataforma;
import com.example.demo.entity.Videojuego;
import com.example.demo.service.VideoJuegoRepositoryImpl;

@RestController
@Controller
@RequestMapping("/enums")
@CrossOrigin(origins = "http://localhost:4200")
public class EnumController {
	
	
	
	@GetMapping("/PlataformaList")
	@ResponseBody
	public ResponseEntity<Object> listaVJ() {
		
		try {
			
			Set<Plataforma> plataformas = Plataforma.valores();
			

			return ResponseEntity.ok(plataformas);
		} catch (Exception e) {
			
			return ResponseEntity.ok(e);
			
		}
		
	}
}

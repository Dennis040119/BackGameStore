package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Usuario;
import com.example.demo.service.UsuarioServiceImpl;



@RestController
@Controller
@RequestMapping("/usuario")
@CrossOrigin(origins = "http://localhost:4200")
public class UsuarioController {

	@Autowired
	private UsuarioServiceImpl service;

	
	@GetMapping("/usuarioList")
	@ResponseBody
	public ResponseEntity<List<Usuario>> listaAlumno() {
		List<Usuario> lista = service.listar();
		return ResponseEntity.ok(lista);
	}
	
	
	@GetMapping("/example")
	@ResponseBody
	public String example() {
		
		return "Ejemplo";
	}
}

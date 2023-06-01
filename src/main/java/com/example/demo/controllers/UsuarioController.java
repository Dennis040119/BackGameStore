package com.example.demo.controllers;

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

import com.example.demo.entity.PassGenerator;
import com.example.demo.entity.Usuario;

import com.example.demo.entity.Videojuego;
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
	
	@GetMapping("/usuarioxUser/{user}")
	@ResponseBody
	public List<Optional<Usuario>> usuarioxUser(@PathVariable("user") String user) {
		
		//encrypto
	
		
		List<Optional<Usuario>> lista = new ArrayList<>();
		
		Optional<Usuario> usu = service.BuscarPorUser(user);
		if(usu.isPresent()) {
			lista.add(usu);
			return lista ;
		}else {
			return lista;
		}
		
		
	}
	
	
	@GetMapping("/loginFind/{user}/{pass}")
	@ResponseBody
	public List<Optional<Usuario>> login(@PathVariable("user") String user,
			@PathVariable("pass") String pass) {
		
		//encrypto
	
		
	
		List<Optional<Usuario>> lista = new ArrayList<>();
		
		
		Optional<Usuario> usu = service.BuscarPorUser(user);
		if(usu.isPresent() && PassGenerator.desecryp(pass,usu.get().getPassword())) {
			lista.add(usu);
			return lista ;
		}else {
			return lista;
		}
		
		
	}
	
	@PostMapping("/usuarioSave")
	@ResponseBody
	public  ResponseEntity<Map<String, Object>> SaveUser(@RequestBody Usuario obj) {
		
		//CREAMOS UN MAP, QUE ALMACENARA LOS MENSAJES DE EXITOS O ERRORES
		Map<String, Object> salida = new HashMap<>();
		//Intentamos la transaction
		
		Optional<Usuario> usu = service.BuscarPorUser(obj.getUser());
		if(usu.isPresent() ){
			salida.put("mensaje", "Ya existe el Usuario");
			
		}else {
			System.out.println("\n"+obj);
			try {
				
				String claveencryp=PassGenerator.CrearContra(obj.getPassword());
				obj.setPassword(claveencryp);
				obj.setId(0);
				
				service.save(obj);
				salida.put("mensaje", "Registrado usuario correctamente");
			} catch (Exception e) {salida.put("mensaje", "Error al registrar: " +e);}
		}
		
		
		
		return ResponseEntity.ok(salida);
	}
	
	@PutMapping("/usuarioPut")
	@ResponseBody
	public  ResponseEntity<Map<String, Object>> ActualizarUser(@RequestBody Usuario obj) {
		
		//CREAMOS UN MAP, QUE ALMACENARA LOS MENSAJES DE EXITOS O ERRORES
		Map<String, Object> salida = new HashMap<>();
		//Intentamos la transaction
		
		Optional<Usuario> usu = service.BuscarPorUser(obj.getUser());
		if(usu.isEmpty() ){
			salida.put("mensaje", "No existe el Usuario");
			
		}else {
			System.out.println("\n"+obj);
			try {
				
				String claveencryp=PassGenerator.CrearContra(obj.getPassword());
				obj.setPassword(claveencryp);
				
				System.out.println(obj.toString());
				service.save(obj);
				salida.put("mensaje", "Actualizado usuario correctamente");
			} catch (Exception e) {salida.put("mensaje", "Error al Actualizar: " +e);}
		}
		
		
		
		return ResponseEntity.ok(salida);
	}
	
	@DeleteMapping("/UsuarioDelete/{id}")
	@ResponseBody
	public  ResponseEntity<Map<String, Object>> eliminarVJ(@PathVariable("id") int id) {
		
		//CREAMOS UN MAP, QUE ALMACENARA LOS MENSAJES DE EXITOS O ERRORES
		Map<String, Object> salida = new HashMap<>();
		//Intentamos la transaccion
		
		if(service.buscar(id).isPresent()== false  ) {
			
			salida.put("mensaje", "No existe el Usuario");
			
		}else {
			try {
				service.delete(id);
				salida.put("mensaje", "Elimnado correctamente");
			} catch (Exception e) {salida.put("mensaje", "Error al eliminar: " +service.buscar(id));}
		}
		
		
		
		return ResponseEntity.ok(salida);
	}
}

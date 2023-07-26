package com.example.demo.controllers.mtnm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;import java.util.stream.Collector;
import java.util.stream.Collectors;

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

import com.example.demo.entity.mtnm.Usuario;
import com.example.demo.service.mtnm.PassGenerator;
import com.example.demo.service.mtnm.UsuarioServiceImpl;



@RestController
@Controller
@RequestMapping("/usuario")
@CrossOrigin(origins = "http://localhost:4200")
public class UsuarioController {

	@Autowired
	private UsuarioServiceImpl service;

	
	@GetMapping("/usuarioList")
	@ResponseBody
	public ResponseEntity<List<Usuario>> listaUsuario() {
		List<Usuario> lista = service.listar();
		return ResponseEntity.ok(lista);
	}
	
	@GetMapping("/usuarioAcList")
	@ResponseBody
	public List<Usuario> listaUsuarioActivos() {
		List<Usuario> lista = service.listarActivos();
		return lista.stream().filter(u -> u.getEstado().equals("ac")).collect(Collectors.toList());
	}
	
	@GetMapping("/usuarioxUser/{user}")
	@ResponseBody
	public List<Optional<Usuario>> usuarioxUser(@PathVariable("user") String user) {
		
		//encrypto
		List<Optional<Usuario>> lista = new ArrayList<>();
		try {
			
			
			Optional<Usuario> usu = service.BuscarPorUser(user);
			if(usu.isPresent()) {
				lista.add(usu);
				return lista ;
			}else {
				return lista;
			}
		} catch (Exception e) {
			
			e.printStackTrace();
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
		System.out.println(usu.get());
		
		if(usu.isPresent() && PassGenerator.desecryp(pass,usu.get().getPassword())) {
			System.out.println("paso");
			lista.add(usu);
			return lista ;
		}else {
			System.out.println("no paso");
			return lista;
		}
		
		
	}
	
	@PostMapping("/usuarioSave")
	@ResponseBody
	public  ResponseEntity<Map<String, Object>> SaveUser(@RequestBody Usuario obj) {
		
		//CREAMOS UN MAP, QUE ALMACENARA LOS MENSAJES DE EXITOS O ERRORES
		Map<String, Object> salida = new HashMap<>();
		//Intentamos la transaction
		
		Optional<Usuario> usu = service.BuscarPorUser(obj.getUsername());
		if(usu.isPresent() ){
			salida.put("mensaje", "Ya existe el Usuario");
			
		}else {
			System.out.println("\n"+obj);
			try {
				
				obj.setUserid(Usuario.generarcodigo(service.listar().size()));
				String claveencryp=PassGenerator.CrearContra(obj.getPassword());
				obj.setPassword(claveencryp);
				
				
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
		
		Optional<Usuario> usu = service.buscar(obj.getUserid());
		List<Usuario> listaUsuario=service.listar();
		
		
		if(usu.isEmpty()){
			salida.put("mensaje", "No existe el Usuario");
			
		}else {
			
			usu.get().setPassword(PassGenerator.CrearContra(obj.getPassword()));
			listaUsuario.remove(usu.get());
			
			try {
				long num=listaUsuario.stream().filter(user -> user.getUsername().equals(obj.getUsername())).count();   
				if(usu.isPresent() ) {
					
					if(num==0) {
						
						obj.setPassword(PassGenerator.CrearContra(obj.getPassword()));
						service.save(obj);
						salida.put("mensaje", "Actualizado usuario correctamente");
					}else {salida.put("mensaje", "Username ya se encuentra en uso");}
				
					
					}else {salida.put("mensaje", "Usuario no encontrado");}
				//String claveencryp=PassGenerator.CrearContra(obj.getPassword());
				//obj.setPassword(claveencryp);
				
				
				} catch (Exception e) {salida.put("mensaje", "Error al Actualizar: " +e);}
				
		}
		
		
		
		return ResponseEntity.ok(salida);
	}
	
	@DeleteMapping("/UsuarioDelete/{id}")
	@ResponseBody
	public  ResponseEntity<Map<String, Object>> eliminarVJ(@PathVariable("id") String id) {
		
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

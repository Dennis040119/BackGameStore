package com.example.demo.controllers.mtnm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
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
import com.example.demo.security.PassGenerator;
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
	public ResponseEntity<?> listaUsuario() {
		
		Map<String, Object> response = new HashMap<>();
		List<Usuario> lista = null;
		try {
			 lista = service.listar();
		}
		catch(DataAccessException e) {
			
			response.put("mensaje", "Error al realizar la petición en la BBDD");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
			
		}	
		
		return new ResponseEntity<List<Usuario>>(lista, HttpStatus.OK);
	}
	
	@GetMapping("/usuarioAcList")
	@ResponseBody
	public List<Usuario> listaUsuarioActivos() {
		List<Usuario> lista = service.listarActivos();
		return lista;	}
	
	@GetMapping("/usuarioxUser/{user}")
	@ResponseBody
	public List<Optional<Usuario>> usuarioxUser(@PathVariable String user) {
		
		//encrypt
		
		List<Optional<Usuario>> lista = new ArrayList<>();
		Optional<Usuario> usu = service.BuscarPorUser(user);
		try {
					
			if(usu.isPresent()) {
				lista.add(usu);
				return lista;
			}else {return lista;}
		} catch (Exception e) {
			
			e.printStackTrace();
			return lista;
		}
		
		
		
	}
	
	
	@GetMapping("/loginFind/{user}/{pass}")
	@ResponseBody
	public List<Usuario> login(@PathVariable String user,
            @PathVariable String pass) {
		
		//encrypto
	
		List<Usuario> lista = new ArrayList<>();
		Usuario usu = new Usuario() ;
		
		//Opcion 1
		if(service.BuscarPorUser(user).isPresent()) {
			 usu = service.BuscarPorUser(user).get();
		}

		System.out.println(usu);
		
		if(PassGenerator.desecryp(pass,usu.getPassword())) {
			System.out.println("paso");
			lista.add(usu);
			return lista;
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
				salida.put("obj", obj);
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
		
		
		if(usu.isEmpty()){salida.put("mensaje", "No existe el Usuario");}
		
		else {
			
			
			listaUsuario.remove(usu.get());
			
			try {
				List num=listaUsuario.stream().
						filter(user -> user.getUsername().equals(obj.getUsername())) //Filtramos el username en la lista
						.collect(Collectors.toList()); //COnvertimos el stream a un list
				if(usu.isPresent() ) {
					
					if(num.size()==0) {
						
						obj.setPassword(PassGenerator.CrearContra(obj.getPassword()));
						if(PassGenerator.desecryp("null", obj.getPassword()) ) {
							obj.setPassword(usu.get().getPassword());
							
						}else {}
						
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
	public  ResponseEntity<Map<String, Object>> eliminarVJ(@PathVariable String id) {
		
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

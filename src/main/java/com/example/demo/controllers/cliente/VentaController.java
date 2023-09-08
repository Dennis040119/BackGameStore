package com.example.demo.controllers.cliente;

import java.util.ArrayList;
import java.util.Date;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
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

import com.example.demo.entity.cliente.ProductosVenta;
import com.example.demo.entity.cliente.ProductosVentaPk;
import com.example.demo.entity.cliente.Venta;
import com.example.demo.entity.enums.Rol;
import com.example.demo.service.cliente.VentaServiceImpl;

@RestController
@Controller
@RequestMapping("/Venta")
@CrossOrigin(origins = "http://localhost:4200")
public class VentaController {
	
	@Autowired
	private VentaServiceImpl service;

	
	@GetMapping("/VtList")
	@ResponseBody
	public ResponseEntity<List<Venta>> listaUsuario() {
		List<Venta> lista = service.listarVentas();
		return ResponseEntity.ok(lista);
	}
	
	@GetMapping("/VtBuscar/{venId}")
	@ResponseBody
	public Venta BuscarPorId(@PathVariable("venId") String venId) {
		
		//encrypto
		//List<Optional<VideoConsola>> lista = new ArrayList<>();
		
		try {
			Optional<Venta> obj = service.buscar(venId);
			if(obj.isPresent()) {return obj.get() ;}
			else {return new Venta();}
		} catch (Exception e) {
			System.out.println("El error es: "+e);
			return new Venta();
		

		}
	}
	
	@GetMapping("/VtUser/{userId}")
	@ResponseBody
	public ResponseEntity<List<Venta>> BuscarPorUser(@PathVariable("userId") String userId) {
		
		//encrypto
		List<Venta> lista = new ArrayList<>();
		
		try {
			
			lista=service.listarVentas();
			
			lista.stream()
			 .filter(i -> i.getUsuario().getUserid().equals(userId))
			 .collect(Collectors.toList())
			 .forEach(System.out::println);
			
			
			 return  ResponseEntity.ok(lista.stream()
					 .filter(i -> i.getUsuario().getUserid().equals(userId))
					 .collect(Collectors.toList()));
			
			
		} catch (Exception e) {
			System.out.println("El error es: "+e);
			return ResponseEntity.ok(lista);
		

		}
	}
	
	@PostMapping("/VtSave")
	@ResponseBody
	public  Venta SaveVt(@RequestBody Venta obj) {
		
		//CREAMOS UN MAP, QUE ALMACENARA LOS MENSAJES DE EXITOS O ERRORES
		Map<String, Object> salida = new HashMap<>();
		Venta objFail = new Venta();
		objFail.setVenId("0000");
		
		//Intentamos la transaccion
		if( service.buscar(obj.getVenId()).equals(new Venta())  ) {
			
			return objFail;
			
		}else {
			try {
				
				
				//Seteamos los campos que necesiten
				String id = Venta.generarcodigo(service.listarVentas().size());
				obj.setVenId(id);
				obj.setRol(Rol.VENTA.getCodigo());
				//Fechas
				
				LocalDate ld=LocalDate.now();
				obj.setfCompra(ldToDate(ld));
				
				System.out.println(obj.toString());
				service.registrar(obj);
				return obj;
				//salida.put("mensaje", "Registrado correctamente");
			} catch (Exception e) {System.out.println("Error al registrar: "+e);
			return objFail;
			}
			 
			}
		
	}
	
	@PutMapping("/VtPut")
	@ResponseBody
	public  ResponseEntity<Map<String, Object>> PutVt(@RequestBody Venta obj) {
		
		//CREAMOS UN MAP, QUE ALMACENARA LOS MENSAJES DE EXITOS O ERRORES
		Map<String, Object> salida = new HashMap<>();
		//Intentamos la transaccion
		
		if( (service.buscar(obj.getVenId()).isEmpty()  )) {
			
			salida.put("mensaje", "No existe el Producto");
			
		}else {
			try {
				
				System.out.println(obj.toString());
				obj.setRol(Rol.VENTA.getCodigo());
				LocalDate ld=LocalDate.now();
				
				//obj.setFCompra(ldToDate(ld));
				service.registrar(obj);
				
				salida.put("mensaje", "Actualizado correctamente");
			}catch (Exception e) {salida.put("mensaje", "Error al actualizar: " +e);}
			}
		
		return ResponseEntity.ok(salida);	
	}
	
	@DeleteMapping("/VtDelete/{venId}")
	@ResponseBody
	public  ResponseEntity<Map<String, Object>> eliminarVJ(@PathVariable("venId") String id) {
		
		//CREAMOS UN MAP, QUE ALMACENARA LOS MENSAJES DE EXITOS O ERRORES
		Map<String, Object> salida = new HashMap<>();
		//Intentamos la transaccion
		
		if(  (service.buscar(id)).isEmpty()  ) {
			
			salida.put("mensaje", "No existe el Producto");
			
		}else {
			try {
				
				service.delete(id);
				salida.put("mensaje", "Elimnado correctamente");
			} catch (Exception e) {salida.put("mensaje", "Error al eliminar: " +service.buscar(id));}
		}
		
		
		
		return ResponseEntity.ok(salida);
	}
	
	private static Date ldToDate(LocalDate ld){

        return java.sql.Date.valueOf(ld);

    }
	
}

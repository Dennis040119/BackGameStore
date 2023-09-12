package com.example.demo.controllers.cliente;

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

import com.example.demo.entity.cliente.ProductosVenta;
import com.example.demo.entity.cliente.ProductosVentaPk;
import com.example.demo.entity.enums.Rol;
import com.example.demo.entity.mtnm.VideoConsola;
import com.example.demo.service.cliente.ProductosVentasServiceImpl;

@RestController
@Controller
@RequestMapping("/ProductosVenta")
@CrossOrigin(origins = "http://localhost:4200")
public class ProductosVentaController {
	
	@Autowired
	private ProductosVentasServiceImpl service;

	
	@GetMapping("/PvList")
	@ResponseBody
	public ResponseEntity<List<ProductosVenta>> listaUsuario() {
		List<ProductosVenta> lista = service.listarProductosVentas();
		return ResponseEntity.ok(lista);
	}
	
	@GetMapping("/PvBuscar/{venId}/{proId}")
	@ResponseBody
	public ProductosVenta BuscarPorVenta(@PathVariable String venId,@PathVariable String proId) {
		
		//encrypto
		//List<Optional<VideoConsola>> lista = new ArrayList<>();
		ProductosVentaPk pk = new ProductosVentaPk(venId, proId);
		try {
			Optional<ProductosVenta> obj = service.buscar(pk);
			if(obj.isPresent()) {return obj.get() ;}
			else {return new ProductosVenta();}
		} catch (Exception e) {
			System.out.println("El error es: "+e);
			return new ProductosVenta();
			}
	}
	
	@GetMapping("/PvBuscarVenta/{venId}")
	@ResponseBody
	public ResponseEntity<List<ProductosVenta>> BuscarPorId(@PathVariable String venId) {
		
		//encrypto
		//List<Optional<VideoConsola>> lista = new ArrayList<>();
		List<ProductosVenta> lista = new ArrayList<>();
		try {
			 lista= service.BuscarPorVenta(venId);
			return ResponseEntity.ok(lista);
		} catch (Exception e) {
			System.out.println("El error es: "+e);
			return ResponseEntity.ok(lista);
			}
	}
	
	@PostMapping("/PvSave")
	@ResponseBody
	public  ResponseEntity<Map<String, Object>> SavePv(@RequestBody ProductosVenta obj) {
		
		//CREAMOS UN MAP, QUE ALMACENARA LOS MENSAJES DE EXITOS O ERRORES
		Map<String, Object> salida = new HashMap<>();
		
		//Intentamos la transaccion
		if( (service.buscar(obj.getProductosVentaPk()) ).isPresent()  ) {
			
			salida.put("mensaje", "Ya existe el Producto");
			
		}else {
			try {
				
				//obj.setVcid(VideoConsola.generarcodigo(service.listarProductosVentas().size()));
				System.out.println(obj.toString());
				service.registrar(obj);
				
				salida.put("mensaje", "Registrado correctamente");
			} catch (Exception e) {salida.put("mensaje", "Error al registrar: " +e);}
			 
			}
		return ResponseEntity.ok(salida);
	}
	
	@PutMapping("/PvPut")
	@ResponseBody
	public  ResponseEntity<Map<String, Object>> PutPv(@RequestBody ProductosVenta obj) {
		
		//CREAMOS UN MAP, QUE ALMACENARA LOS MENSAJES DE EXITOS O ERRORES
		Map<String, Object> salida = new HashMap<>();
		//Intentamos la transaccion
		
		if( (service.buscar(obj.getProductosVentaPk()).isEmpty()  )) {
			
			salida.put("mensaje", "No existe el Producto");
			
		}else {
			try {
				obj.setRol(Rol.PRODUCTO.getCodigo());  
				System.out.println(obj.toString());
				service.registrar(obj);
				
				salida.put("mensaje", "Actualizado correctamente");
			} catch (Exception e) {salida.put("mensaje", "Error al actualizar: " +e);}
			}
		
		
		
		return ResponseEntity.ok(salida);
	}
	
	@DeleteMapping("/PvDelete/{venId}/{pvId}")
	@ResponseBody
	public  ResponseEntity<Map<String, Object>> eliminarVJ(@PathVariable String venId,
            @PathVariable String pvId) {
		
		//CREAMOS UN MAP, QUE ALMACENARA LOS MENSAJES DE EXITOS O ERRORES
		Map<String, Object> salida = new HashMap<>();
		//Intentamos la transaccion
		ProductosVentaPk pk = new ProductosVentaPk(venId, pvId);
		
		if(  (service.buscar(pk)).isEmpty()  ) {
			
			salida.put("mensaje", "No existe el Producto");
			
		}else {
			try {
				
				service.delete(pk);
				salida.put("mensaje", "Elimnado correctamente");
			} catch (Exception e) {salida.put("mensaje", "Error al eliminar: " +service.buscar(pk));}
		}
		
		
		
		return ResponseEntity.ok(salida);
	}
	
}

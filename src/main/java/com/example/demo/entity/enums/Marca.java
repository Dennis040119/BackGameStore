package com.example.demo.entity.enums;

import java.util.List;

public class Marca {
	
	
	
	private String idMarca;
	private String nombre;
	
	private Marca(String idMarca, String nombre) {
		this.idMarca = idMarca;
		this.nombre = nombre;
	}
	private Marca() {
	}
	public String getIdMarca() {
		return idMarca;
	}
	public void setIdMarca(String idMarca) {
		this.idMarca = idMarca;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public static List<Marca> addMarcas(List<Marca> listas){
		
		listas.add(new Marca("mc001","Sony"));
		listas.add(new Marca("mc002","MicroSoft"));
		listas.add(new Marca("mc003","Steam"));
		listas.add(new Marca("mc004","Nintendo"));
		
		
		
		return listas;
	}
	
}

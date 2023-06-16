package com.example.demo.entity.enums;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name="genero")
public class Genero {
	
	@Id
	private String genId;
	private String nombre;
	
	
	public Genero() {
		super();
	}
	public Genero(String genId, String nombre) {
		super();
		this.genId = genId;
		this.nombre = nombre;
	}
	
	public String getId() {
		return genId;
	}
	public void setId(String id) {
		this.genId = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	@Override
	public String toString() {
		return "Genero [genId=" + genId + ", nombre=" + nombre + "]";
	}
	
	
	

}

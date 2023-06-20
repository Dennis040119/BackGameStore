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
	
	
	
	public String getGenId() {
		return genId;
	}
	public void setGenId(String genId) {
		this.genId = genId;
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

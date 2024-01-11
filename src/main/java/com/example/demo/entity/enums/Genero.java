package com.example.demo.entity.enums;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name="genero")
public class Genero {
	
	@Id
	private String genid;
	private String nombre;
	
	
	public Genero() {
		super();
	}
	public Genero(String genId, String nombre) {
		super();
		this.genid = genId;
		this.nombre = nombre;
	}
	
	
	
	public String getGenId() {
		return genid;
	}
	public void setGenId(String genId) {
		this.genid = genId;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	@Override
	public String toString() {
		return "Genero [genid=" + genid + ", nombre=" + nombre + "]";
	}
	
	
	

}

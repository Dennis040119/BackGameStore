package com.example.demo.entity.enums;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;


@Entity
@Table(name = "plataforma")
public class Plataforma {
	
	@Id
	private String platId;
	private String nombre;
	private int generacion;
	private String marca;
	
	
	
	
	
	public Plataforma(String platId, String nombre, int generacion, String marca) {
		super();
		this.platId = platId;
		this.nombre = nombre;
		this.generacion = generacion;
		this.marca = marca;
	}

	



	public Plataforma() {
		super();
	}

	



	





	public String getPlatId() {
		return platId;
	}





	public void setPlatId(String platId) {
		this.platId = platId;
	}





	public String getNombre() {
		return nombre;
	}





	public void setNombre(String nombre) {
		this.nombre = nombre;
	}





	public int getGeneracion() {
		return generacion;
	}





	public void setGeneracion(int generacion) {
		this.generacion = generacion;
	}





	public String getMarca() {
		return marca;
	}





	public void setMarca(String marca) {
		this.marca = marca;
	}





	@Override
	public String toString() {
		return "Plataforma [platId=" + platId + ", nombre=" + nombre + ", generacion=" + generacion + ", marca=" + marca
				+ "]";
	}


	



	
	/*PLAY4("PlayStation 4",4,"Sony"),
	PLAY5("PlayStation 5",5,"Sony"),
	XBOX360("Xbox 360",4,"Microsoft"),
	XBOXONE("Xbox one",5,"Microsoft"),
	PC("Pc",5,"Nvidia"),
	NINTENDOSWITCH("Nintendo Switch ",5,"Nintendo");*/
	

}

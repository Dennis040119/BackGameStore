package com.example.demo.entity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import javax.persistence.Entity;

import lombok.Data;

@Data
public class Plataforma {
	
	/*PLAY4("PlayStation 4",4,"Sony"),
	PLAY5("PlayStation 5",5,"Sony"),
	XBOX360("Xbox 360",4,"Microsoft"),
	XBOXONE("Xbox one",5,"Microsoft"),
	PC("Pc",5,"Nvidia"),
	NINTENDOSWITCH("Nintendo Switch ",5,"Nintendo");*/
	
	private String nombre;
	private int generacion;
	private String marca;
	
	
	private Plataforma(String nombre, int generacion, String marca) {
		this.nombre = nombre;
		this.generacion = generacion;
		this.marca = marca;
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
	
	
	public static Set valores() {
		
		Plataforma PLAY4=new Plataforma("PlayStation 4",4,"Sony");
		Plataforma PLAY5=new Plataforma("PlayStation 5",5,"Sony");
		Plataforma XBOX360=new Plataforma("Xbox 360",4,"Microsoft");
		Plataforma XBOXONE=new Plataforma("Xbox one",5,"Microsoft");
		Plataforma PC=new Plataforma("Pc",5,"Nvidia");
		Plataforma NINTENDOSWITCH=new Plataforma("Nintendo Switch",5,"Nintendo");
		
		
		Set<Plataforma> plata = new HashSet<Plataforma>();
		plata.add(PLAY4);
		plata.add(PLAY5);
		plata.add(XBOX360);
		plata.add(XBOXONE);;
		plata.add(PC);
		plata.add(NINTENDOSWITCH);
		
		
		
		return plata;
	}
	
	/*PLAY4("PlayStation 4",4,"Sony"),
	PLAY5("PlayStation 5",5,"Sony"),
	XBOX360("Xbox 360",4,"Microsoft"),
	XBOXONE("Xbox one",5,"Microsoft"),
	PC("Pc",5,"Nvidia"),
	NINTENDOSWITCH("Nintendo Switch ",5,"Nintendo");*/
	

}

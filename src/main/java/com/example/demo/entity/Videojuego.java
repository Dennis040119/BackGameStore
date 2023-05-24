package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "Videojuego")
public class Videojuego {
	@Id
	private int id;
	@Column(name = "nombre")
	private String nombre;
	private double precio;
	private String color;
	private String descripcion;
	private String plataforma1;
	private String plataforma2;
	private String plataforma3;
	private String rol;
	private String img;
	
	
	
	
	
	public Videojuego() {
		super();
	}





	public Videojuego(int id, String nombre, double precio, String color, String descripcion, Plataforma plataforma1,
			Plataforma plataforma2, Plataforma plataforma3, Rol rol, String img) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.precio = precio;
		this.color = color;
		this.descripcion = descripcion;
		this.plataforma1 = plataforma1.getNombre();
		this.plataforma2 = plataforma2.getMarca();
		this.plataforma3 = plataforma3.getMarca();
		this.rol = rol.getCodigo();
		this.img = img;
	}





	public int getId() {
		return id;
	}





	public void setId(int id) {
		this.id = id;
	}





	public String getNombre() {
		return nombre;
	}





	public void setNombre(String nombre) {
		this.nombre = nombre;
	}





	public double getPrecio() {
		return precio;
	}





	public void setPrecio(double precio) {
		this.precio = precio;
	}





	public String getColor() {
		return color;
	}





	public void setColor(String color) {
		this.color = color;
	}





	public String getDescripcion() {
		return descripcion;
	}





	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}





	public String getPlataforma1() {
		return plataforma1;
	}





	public void setPlataforma1(String plataforma1) {
		this.plataforma1 = plataforma1;
	}





	public String getPlataforma2() {
		return plataforma2;
	}





	public void setPlataforma2(String plataforma2) {
		this.plataforma2 = plataforma2;
	}





	public String getPlataforma3() {
		return plataforma3;
	}





	public void setPlataforma3(String plataforma3) {
		this.plataforma3 = plataforma3;
	}





	public String getRol() {
		return rol;
	}





	public void setRol(String rol) {
		this.rol = rol;
	}





	public String getImg() {
		return img;
	}





	public void setImg(String img) {
		this.img = img;
	}
	
	
	




}

package com.example.demo.entity;

public enum Plataforma {
	
	PLAY4("PlayStation 4",4,"Sony"),
	PLAY5("PlayStation 5",5,"Sony"),
	XBOX360("Xbox 360",4,"Microsoft"),
	XBOXONE("Xbox one",5,"Microsoft"),
	PC("Pc",5,"Nvidia"),
	NINTENDOSWITCH("Nintendo Switch ",5,"Nintendo");
	
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
	
	
	
	
	

}

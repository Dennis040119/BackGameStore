package com.example.demo.entity;

public enum Rol {

	VIDEOJUEGO("v"),
	CONSOLA("c"),
	ACCESORIO("a");
	
	private String codigo;

	private Rol(String codigo) {
		this.codigo = codigo;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	
	
	
}

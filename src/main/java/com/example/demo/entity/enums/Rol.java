package com.example.demo.entity.enums;

public enum Rol {

	VIDEOJUEGO("vj"),
	VIDEOCONSOLA("vc"),
	ACCESORIO("ac");
	
	
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

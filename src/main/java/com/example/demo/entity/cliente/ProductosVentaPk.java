package com.example.demo.entity.cliente;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class ProductosVentaPk implements Serializable {

	private String venId;
	private String proId;
	
	
	public ProductosVentaPk(String venId, String proId) {
		super();
		this.venId = venId;
		this.proId = proId;
	}

	
	public ProductosVentaPk() {
		super();
	}


	public String getVenId() {
		return venId;
	}


	public void setVenId(String venId) {
		this.venId = venId;
	}


	public String getProId() {
		return proId;
	}


	public void setProId(String proId) {
		this.proId = proId;
	}


	@Override
	public String toString() {
		return "ProductosVentaPk [venId=" + venId + ", proId=" + proId + "]";
	}
	
	
}

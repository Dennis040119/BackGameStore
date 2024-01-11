package com.example.demo.entity.cliente;

import java.io.Serializable;

import jakarta.persistence.Embeddable;

@Embeddable
public class ProductosVentaPk implements Serializable {

	private String venid;
	private String proid;
	
	
	public ProductosVentaPk(String venId, String proId) {
		super();
		this.venid = venId;
		this.proid = proId;
	}

	
	public ProductosVentaPk() {
		super();
	}


	public String getVenId() {
		return venid;
	}


	public void setVenId(String venId) {
		this.venid = venId;
	}


	public String getProId() {
		return proid;
	}


	public void setProId(String proId) {
		this.proid = proId;
	}


	@Override
	public String toString() {
		return "ProductosVentaPk [venId=" + venid + ", proId=" + proid + "]";
	}
	
	
}

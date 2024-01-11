package com.example.demo.entity.cliente;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name="productosventa")
public class ProductosVenta {
	@EmbeddedId
	private ProductosVentaPk productosVentaPk;
	private String nombre;
	private double precio;
	private int cantidad;
	private String rol;
	private String img;
	
	public ProductosVenta() {
		super();
	}

	public ProductosVenta(ProductosVentaPk productosVentaPk, String nombre, double precio, int cantidad, String rol,
			String img) {
		super();
		this.productosVentaPk = productosVentaPk;
		this.nombre = nombre;
		this.precio = precio;
		this.cantidad = cantidad;
		this.rol = rol;
		this.img = img;
	}

	public ProductosVentaPk getProductosVentaPk() {
		return productosVentaPk;
	}

	public void setProductosVentaPk(ProductosVentaPk productosVentaPk) {
		this.productosVentaPk = productosVentaPk;
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

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
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

	@Override
	public String toString() {
		return "ProductosVenta [productosVentaPk=" + productosVentaPk + ", nombre=" + nombre + ", precio=" + precio
				+ ", cantidad=" + cantidad + ", rol=" + rol + ", img=" + img + "]";
	}
	
	
	
	
	

}

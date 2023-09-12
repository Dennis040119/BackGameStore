package com.example.demo.entity.mtnm;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import com.example.demo.entity.enums.Plataforma;

@Entity
@Table(name = "videoconsola")
public class VideoConsola {
	@Id
	private String vcid;
	private String nombre;
	
	@ManyToOne
	@JoinColumn(name = "plataforma")
	private Plataforma plataforma;
	private double precio;
	private String descripcion;
	private String marca;
	private String rol;
	private String img;
	
	
	
	public VideoConsola() {
		super();
	}



	public VideoConsola(String vcid, String nombre, Plataforma plataforma, double precio, String descripcion,
			String marca,String rol ,String img) {
		super();
		this.vcid = vcid;
		this.nombre = nombre;
		this.plataforma = plataforma;
		this.precio = precio;
		this.descripcion = descripcion;
		this.marca = marca;
		this.rol=rol;
		this.img = img;
	}



	public String getVcid() {
		return vcid;
	}



	public void setVcid(String vcid) {
		this.vcid = vcid;
	}



	public String getNombre() {
		return nombre;
	}



	public void setNombre(String nombre) {
		this.nombre = nombre;
	}



	public Plataforma getPlataforma() {
		return plataforma;
	}



	public void setPlataforma(Plataforma plataforma) {
		this.plataforma = plataforma;
	}



	public double getPrecio() {
		return precio;
	}



	public void setPrecio(double precio) {
		this.precio = precio;
	}



	public String getDescripcion() {
		return descripcion;
	}



	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}



	public String getMarca() {
		return marca;
	}



	public void setMarca(String marca) {
		this.marca = marca;
	}



	public String getImg() {
		return img;
	}



	public void setImg(String img) {
		this.img = img;
	}



	public String getRol() {
		return rol;
	}



	public void setRol(String rol) {
		this.rol = rol;
	}



	
	
	@Override
	public String toString() {
		return "VideoConsola [vcid=" + vcid + ", nombre=" + nombre + ", plataforma=" + plataforma + ", precio=" + precio
				+ ", descripcion=" + descripcion + ", marca=" + marca + ", rol=" + rol + ", img=" + img + "]";
	}



	public  static String  generarcodigo(int nro) {
		if(nro<9) {return "vc00"+(nro+1);}
		if(nro>=9 && nro<99 ) {return "vc0"+(nro+1);}
		if(nro>=99 && nro<999) {return "vc"+nro+1;}
	return "";
	}
	
}

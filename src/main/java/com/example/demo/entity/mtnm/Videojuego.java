package com.example.demo.entity.mtnm;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.example.demo.entity.enums.Genero;

import lombok.Data;

@Entity
@Data
@Table(name = "Videojuego")
public class Videojuego {
	@Id
	private String vjid;
	@Column(name = "nombre")
	private String nombre;
	private double precio;
	private String descripcion;
	
	private String plataformas;
	
	@ManyToOne
	@JoinColumn(name = "genero")
	private Genero genero;
	
	private String rol;
	private String img;
	
	public Videojuego() {
		super();
	}

	public Videojuego(String vjid, String nombre, double precio, String descripcion, String plataformas,
			Genero genero, String rol, String img) {
		super();
		this.vjid = vjid;
		this.nombre = nombre;
		this.precio = precio;
		this.descripcion = descripcion;
		this.plataformas = plataformas;
		this.genero = genero;
		this.rol = rol;
		this.img = img;
	}

	public String getId() {
		return vjid;
	}

	public void setId(String vjid) {
		this.vjid = vjid;
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

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getPlataformas() {
		return plataformas;
	}

	public void setPlataformas(String plataformas) {
		this.plataformas = plataformas;
	}

	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
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
		return "Videojuego [vjid=" + vjid + ", nombre=" + nombre + ", precio=" + precio + ", descripcion=" + descripcion
				+ ", plataformas=" + plataformas + ", genero=" + genero.getNombre() + ", rol=" + rol + ", img=" + img + "]";
	}
	
	
	public  static String  generarcodigo(int nro) {
			if(nro<9) {return "vj00"+(nro+1);}
			if(nro>=9 && nro<99 ) {return "vj0"+(nro+1);}
			if(nro>=99 && nro<999) {return "vj"+nro+1;}
		return "";
	}

	

	
	
	
	
	





	
	
	




}

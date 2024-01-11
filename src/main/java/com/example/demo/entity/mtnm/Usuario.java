package com.example.demo.entity.mtnm;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "usuario")
public class Usuario {

	@Id
	private String userid;
	private String username;
	private String password;
	private String email;
	private String tarjetacredito;
	private String direccion;
	private String estado;
	private String rol;
	private String imagen;

	
	

	public  static String  generarcodigo(int nro) {
		if(nro<9) {return "us00"+(nro+1);}
		if(nro>=9 && nro<99 ) {return "us0"+(nro+1);}
		if(nro>=99 && nro<999) {return "us"+nro+1;}
	return "";
	}




	public String getUserid() {
		return userid;
	}




	public void setUserid(String userid) {
		this.userid = userid;
	}




	public String getUsername() {
		return username;
	}




	public void setUsername(String username) {
		this.username = username;
	}




	public String getPassword() {
		return password;
	}




	public void setPassword(String password) {
		this.password = password;
	}




	public String getEmail() {
		return email;
	}




	public void setEmail(String email) {
		this.email = email;
	}




	public String getTarjetaCredito() {
		return tarjetacredito;
	}




	public void setTarjetaCredito(String tarjetaCredito) {
		this.tarjetacredito = tarjetaCredito;
	}




	public String getDireccion() {
		return direccion;
	}




	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}




	public String getEstado() {
		return estado;
	}




	public void setEstado(String estado) {
		this.estado = estado;
	}




	public String getRol() {
		return rol;
	}




	public void setRol(String rol) {
		this.rol = rol;
	}




	public String getImagen() {
		return imagen;
	}




	public void setImagen(String imagen) {
		this.imagen = imagen;
	}
	
	
	
	

	
	
}

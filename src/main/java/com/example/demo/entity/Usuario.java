package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Entity
@Table(name = "usuario")
public class Usuario {

	@Id
	private int id;
	@Column(name = "username")
	private String user;
	
	
	private String password;
	private String email;
	private String tarjetaCredito;
	private String direccion;
	private String rol;
	public Usuario(int id, String user, String password, String email, String tarjetaCredito, String direccion,
			String rol) {
		super();
		this.id = id;
		this.user = user;
		this.password = password;
		this.email = email;
		this.tarjetaCredito = tarjetaCredito;
		this.direccion = direccion;
		this.rol = rol;
	}
	public Usuario() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
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
		return tarjetaCredito;
	}
	public void setTarjetaCredito(String tarjetaCredito) {
		this.tarjetaCredito = tarjetaCredito;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getRol() {
		return rol;
	}
	public void setRol(String rol) {
		this.rol = rol;
	}
	@Override
	public String toString() {
		return "Usuario [id=" + id + ", user=" + user + ", password=" + password + ", email=" + email
				+ ", tarjetaCredito=" + tarjetaCredito + ", direccion=" + direccion + ", rol=" + rol + "]";
	}
	
	
	
	
	
	
	

	

	
	
}

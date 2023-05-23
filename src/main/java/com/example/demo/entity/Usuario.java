package com.example.demo.entity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Entity
@Table(name = "usuario")
public class Usuario {

	@EmbeddedId
	private UsuarioPk pk;

	private String email;
	private String tarjetaCredito;
	private String direccion;

	/////////////////////////////
	
	

	public Usuario(UsuarioPk pk, String email, String tarjetaCredito, String direccion) {
		super();
		this.pk = pk;
		this.email = email;
		this.tarjetaCredito = tarjetaCredito;
		this.direccion = direccion;
	}

	public Usuario() {
		super();
	}

	///////////////////////////////
	public UsuarioPk getPk() {
		return pk;
	}

	public void setPk(UsuarioPk pk) {
		this.pk = pk;
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

	@Override
	public String toString() {
		return "Usuario [pk=" + pk + ", email=" + email + ", tarjetaCredito=" + tarjetaCredito + ", direccion="
				+ direccion + "]";
	}
	
	
}

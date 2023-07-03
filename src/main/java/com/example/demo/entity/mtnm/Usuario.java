package com.example.demo.entity.mtnm;

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
	private String userid;
	private String username;
	private String password;
	private String email;
	private String tarjetaCredito;
	private String direccion;
	private String estado;
	private String rol;
	
	
	public Usuario(String userid, String username, String password, String email, String tarjetaCredito, String direccion,
			String estado, String rol) {
		super();
		this.userid = userid;
		this.username = username;
		this.password = password;
		this.email = email;
		this.tarjetaCredito = tarjetaCredito;
		this.direccion = direccion;
		this.estado = estado;
		this.rol = rol;
	}
	
	
	public Usuario() {
		super();
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
	
	
	
	
	
	public String getEstado() {
		return estado;
	}


	public void setEstado(String estado) {
		this.estado = estado;
	}


	@Override
	public String toString() {
		return "Usuario [userid=" + userid + ", username=" + username + ", password=" + password + ", email=" + email
				+ ", tarjetaCredito=" + tarjetaCredito + ", direccion=" + direccion + ", estado=" + estado + ", rol="
				+ rol + "]";
	}


	public  static String  generarcodigo(int nro) {
		if(nro<9) {return "us00"+(nro+1);}
		if(nro>=9 && nro<99 ) {return "us0"+(nro+1);}
		if(nro>=99 && nro<999) {return "us"+nro+1;}
	return "";
	}
	
	

	

	
	
}

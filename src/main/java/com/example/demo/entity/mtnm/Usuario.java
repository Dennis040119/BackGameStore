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
	@Column(name = "username")
	private String user;
	
	
	private String password;
	private String email;
	private String tarjetaCredito;
	private String direccion;
	private String rol;
	public Usuario(String userid, String user, String password, String email, String tarjetaCredito, String direccion,
			String rol) {
		super();
		this.userid = userid;
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
	
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
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
		return "Usuario [userid=" + userid + ", user=" + user + ", password=" + password + ", email=" + email
				+ ", tarjetaCredito=" + tarjetaCredito + ", direccion=" + direccion + ", rol=" + rol + "]";
	}
	public  static String  generarcodigo(int nro) {
		if(nro<9) {return "us00"+(nro+1);}
		if(nro>=9 && nro<99 ) {return "us0"+(nro+1);}
		if(nro>=99 && nro<999) {return "us"+nro+1;}
	return "";
	}
	
	

	

	
	
}

package com.example.demo.entity.mtnm;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
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
	private String tarjetaCredito;
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
	
	

	

	
	
}

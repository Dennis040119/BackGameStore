package com.example.demo.entity.cliente;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.example.demo.entity.mtnm.Usuario;

import lombok.Data;

@Entity
@Data
@Table(name="Venta")
public class Venta {
	
	@Id
	private String venId;
	@ManyToOne
	@JoinColumn(name = "usuario")
	private Usuario usuario;
	private double total;
	private String direccion;
	private String rol;
	private Date fCompra;
	private Date fEntrega;
	
	
	public Venta(String venId, Usuario usuario, double total, String direccion, String rol, Date fCompra,
			Date fEntrega) {
		super();
		this.venId = venId;
		this.usuario = usuario;
		this.total = total;
		this.direccion = direccion;
		this.rol = rol;
		this.fCompra = fCompra;
		this.fEntrega = fEntrega;
	}
	public Venta() {
		super();
	}
	public String getVenId() {
		return venId;
	}
	public void setVenId(String venId) {
		this.venId = venId;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
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
	public Date getfCompra() {
		return fCompra;
	}
	public void setfCompra(Date fCompra) {
		this.fCompra = fCompra;
	}
	public Date getfEntrega() {
		return fEntrega;
	}
	public void setfEntrega(Date fEntrega) {
		this.fEntrega = fEntrega;
	}
	@Override
	public String toString() {
		return "Venta [venId=" + venId + ", usuario=" + usuario.getUser() + ", total=" + total + ", direccion=" + direccion
				+ ", rol=" + rol + ", fCompra=" + fCompra + ", fEntrega=" + fEntrega + "]";
	}
	
	public  static String  generarcodigo(int nro) {
		if(nro<9) {return "vt00"+(nro+1);}
		if(nro>=9 && nro<99 ) {return "vt0"+(nro+1);}
		if(nro>=99 && nro<999) {return "vt"+nro+1;}
	return "";
	}

}

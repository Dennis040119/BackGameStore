package com.example.demo.entity.cliente;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.example.demo.entity.mtnm.Usuario;

import lombok.AllArgsConstructor;
import lombok.Data;
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
@Data
@Table(name="Venta")
public class Venta {
	
	@Id
	private String venId;
	@ManyToOne
	@JoinColumn(name = "usuario")
	private Usuario usuario;
	private String nombre;
	private String correo;
	private String movil;
	private String tarjeta;
	private double total;
	private String direccion;
	private String rol;
	private Date fCompra;
	private Date fEntrega;
	private String horaEntrega;
	
	
	public Venta(String venId, Usuario usuario, String nombre, String correo, String movil, String tarjeta,
			double total, String direccion, String rol, Date fCompra, Date fEntrega) {
		super();
		this.venId = venId;
		this.usuario = usuario;
		this.nombre = nombre;
		this.correo = correo;
		this.movil = movil;
		this.tarjeta = tarjeta;
		this.total = total;
		this.direccion = direccion;
		this.rol = rol;
		this.fCompra = fCompra;
		this.fEntrega = fEntrega;
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
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public String getMovil() {
		return movil;
	}
	public void setMovil(String movil) {
		this.movil = movil;
	}
	public String getTarjeta() {
		return tarjeta;
	}
	public void setTarjeta(String tarjeta) {
		this.tarjeta = tarjeta;
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
		return "Venta [venId=" + venId + ", usuario=" + usuario + ", nombre=" + nombre + ", correo=" + correo
				+ ", movil=" + movil + ", tarjeta=" + tarjeta + ", total=" + total + ", direccion=" + direccion
				+ ", rol=" + rol + ", fCompra=" + fCompra + ", fEntrega=" + fEntrega + "]";
	}
	
	
	
	public  static String  generarcodigo(int nro) {
		if(nro<9) {return "vt00"+(nro+1);}
		if(nro>=9 && nro<99 ) {return "vt0"+(nro+1);}
		if(nro>=99 && nro<999) {return "vt"+nro+1;}
	return "";
	}

}

package com.example.demo.entity.cliente;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name="ProductosVenta")
public class ProductosVenta {
	@Id
	private String venId;
	private String proId;
	private String nombre;
	private double precio;
	private String rol;
	private String img;

}

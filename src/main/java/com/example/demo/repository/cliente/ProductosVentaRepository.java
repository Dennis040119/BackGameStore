package com.example.demo.repository.cliente;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.cliente.ProductosVenta;
import com.example.demo.entity.cliente.ProductosVentaPk;

public interface ProductosVentaRepository extends JpaRepository<ProductosVenta,ProductosVentaPk > {

}

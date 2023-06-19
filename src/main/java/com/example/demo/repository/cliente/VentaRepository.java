package com.example.demo.repository.cliente;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.cliente.Venta;

public interface VentaRepository extends JpaRepository<Venta, String>{

}

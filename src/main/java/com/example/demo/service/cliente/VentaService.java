package com.example.demo.service.cliente;

import java.util.List;
import java.util.Optional;

import com.example.demo.entity.cliente.ProductosVenta;
import com.example.demo.entity.cliente.ProductosVentaPk;
import com.example.demo.entity.cliente.Venta;

public interface VentaService {

	List<Venta> listarVentas();
	public Optional<Venta> buscar(String id);
	public Optional<Venta> BuscarPorUser(String user);
	public void registrar(Venta obj);
	public void editar(Venta obj);
	public void delete(String id);
}

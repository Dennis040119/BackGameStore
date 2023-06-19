package com.example.demo.service.cliente;

import java.util.List;
import java.util.Optional;

import com.example.demo.entity.cliente.ProductosVenta;
import com.example.demo.entity.cliente.ProductosVentaPk;

public interface ProductosVentasService {
	
	List<ProductosVenta> listarProductosVentas();
	public Optional<ProductosVenta> buscar(ProductosVentaPk id);
	public Optional<ProductosVenta> BuscarPorVenta(String VentaID);
	public void registrar(ProductosVenta ProductoVenta);
	public void editar(ProductosVenta ProductoVenta);
	public void delete(ProductosVentaPk id);

}

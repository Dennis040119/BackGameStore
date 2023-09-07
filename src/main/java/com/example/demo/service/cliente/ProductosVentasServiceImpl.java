package com.example.demo.service.cliente;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.cliente.ProductosVenta;
import com.example.demo.entity.cliente.ProductosVentaPk;
import com.example.demo.repository.cliente.ProductosVentaRepository;

@Service
public class ProductosVentasServiceImpl implements ProductosVentasService {
	
	@Autowired
	private ProductosVentaRepository repo;

	@Override
	public List<ProductosVenta> listarProductosVentas() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public Optional<ProductosVenta> buscar(ProductosVentaPk id) {
		// TODO Auto-generated method stub
		return repo.findById(id);
	}

	@Override
	public List<ProductosVenta> BuscarPorVenta(String VentaID) {
		// TODO Auto-generated method stub
		
		List<ProductosVenta> lista =repo.findAll().stream()
		.filter(obj -> obj.getProductosVentaPk().getVenId().equals(VentaID))
		.collect(Collectors.toList());
		;
		return lista;
	}

	@Override
	public void registrar(ProductosVenta ProductoVenta) {
		// TODO Auto-generated method stub
		repo.save(ProductoVenta);
	}

	@Override
	public void editar(ProductosVenta ProductoVenta) {
		// TODO Auto-generated method stub
		repo.save(ProductoVenta);
	}

	@Override
	public void delete(ProductosVentaPk id) {
		// TODO Auto-generated method stub
		repo.deleteById(id);
	}

}

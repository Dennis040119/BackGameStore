package com.example.demo.service.cliente;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.cliente.Venta;
import com.example.demo.repository.cliente.VentaRepository;

@Service
public class VentaServiceImpl implements VentaService {
	@Autowired
	VentaRepository repo;

	@Override
	public List<Venta> listarVentas() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public Optional<Venta> buscar(String id) {
		// TODO Auto-generated method stub
		return repo.findById(id);
	}

	@Override
	public Optional<Venta> BuscarPorUser(String user) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public void registrar(Venta obj) {
		// TODO Auto-generated method stub
		repo.save(obj);
	}

	@Override
	public void editar(Venta obj) {
		// TODO Auto-generated method stub
		repo.save(obj);
	}

	@Override
	public void delete(String id) {
		// TODO Auto-generated method stub
		repo.deleteById(id);
	}

}

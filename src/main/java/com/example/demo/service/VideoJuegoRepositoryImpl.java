package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Videojuego;
import com.example.demo.repository.VideoJuegoRepository;

@Service
public class VideoJuegoRepositoryImpl implements VideoJuegoService {

	@Autowired
	private VideoJuegoRepository repo;
	
	@Override
	public List<Videojuego> listar() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}
	
	@Override
	public Optional<Videojuego> buscarPorId(int id) {
		// TODO Auto-generated method stub
		return repo.findById(id);
	}
	
	@Override
	public List<Videojuego> buscarPorNombre(String id) {
		// TODO Auto-generated method stub
		return repo.BuscarVjPorNombre(id);
	}

	@Override
	public void registrar(Videojuego VideoJuego) {
		// TODO Auto-generated method stub
		repo.save(VideoJuego);
	}

	@Override
	public void eliminar(int id) {
		// TODO Auto-generated method stub
		repo.deleteById(id);
	}

	

	

}

package com.example.demo.service.mtnm;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.mtnm.Videojuego;
import com.example.demo.repository.mtnm.VideoJuegoRepository;

@Service
public class VideoJuegoServiceImpl implements VideoJuegoService {

	@Autowired
	private VideoJuegoRepository repo;
	
	@Override
	public List<Videojuego> listar() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}
	
	@Override
	public Optional<Videojuego> buscarPorId(String id) {
		// TODO Auto-generated method stub
		return repo.findById(id);
	}
	
	@Override
	public List<Videojuego> buscarPorNombre(String nombre) {
		// TODO Auto-generated method stub
		return repo.BuscarVjPorNombre(nombre);
	}

	@Override
	public void registrar(Videojuego VideoJuego) {
		// TODO Auto-generated method stub
		repo.save(VideoJuego);
	}

	@Override
	public void eliminar(String id) {
		// TODO Auto-generated method stub
		repo.deleteById(id);
	}

	

	

}

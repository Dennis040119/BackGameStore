package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.mtnm.VideoConsola;
import com.example.demo.repository.VideoConsolaRepository;

@Service
public class VideoConsolaServiceImpl implements VideoConsolaService {

	@Autowired
	private VideoConsolaRepository repo;
	
	@Override
	public List<VideoConsola> listar() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public Optional<VideoConsola> buscar(String id) {
		// TODO Auto-generated method stub
		return repo.findById(id);
	}

	@Override
	public Optional<VideoConsola> BuscarPorNombre(String nombre) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public void save(VideoConsola VideoConsola) {
		// TODO Auto-generated method stub
		repo.save(VideoConsola);
	}

	@Override
	public void delete(String id) {
		// TODO Auto-generated method stub
		repo.deleteById(id);
	}

}

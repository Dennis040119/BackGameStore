package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.VideoJuego;
import com.example.demo.repository.VideoJuegoRepository;

@Service
public class VideoJuegoRepositoryImpl implements VideoJuegoService {

	@Autowired
	private VideoJuegoRepository repo;
	
	@Override
	public List<VideoJuego> listar() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public void save(VideoJuego VideoJuego) {
		// TODO Auto-generated method stub
		repo.save(VideoJuego);
	}

}

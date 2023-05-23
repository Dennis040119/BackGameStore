package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Usuario;
import com.example.demo.entity.VideoJuego;

public interface VideoJuegoService {
	
	public List<VideoJuego> listar();
	public void save(VideoJuego VideoJuego);

}

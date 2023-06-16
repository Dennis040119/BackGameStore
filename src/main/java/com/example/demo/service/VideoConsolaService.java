package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.entity.mtnm.VideoConsola;

public interface VideoConsolaService {
	
	public List<VideoConsola> listar();
	public Optional<VideoConsola> buscar(String  id);
	public Optional<VideoConsola> BuscarPorNombre(String nombre);
	public void save(VideoConsola VideoConsola);
	
	public void delete(String id);

}

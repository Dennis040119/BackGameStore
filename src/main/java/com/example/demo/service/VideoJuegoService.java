package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.entity.Usuario;
import com.example.demo.entity.Videojuego;

public interface VideoJuegoService {
	
	public List<Videojuego> listar();
	public Optional<Videojuego> buscarPorId(int id);
	List<Videojuego> buscarPorNombre(String id);
	public void registrar(Videojuego VideoJuego);
	public void eliminar(int id);
	
	
}

package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.entity.mtnm.Usuario;
import com.example.demo.entity.mtnm.Videojuego;

public interface VideoJuegoService {
	
	public List<Videojuego> listar();
	public Optional<Videojuego> buscarPorId(String id);
	List<Videojuego> buscarPorNombre(String nombre);
	public void registrar(Videojuego VideoJuego);
	public void eliminar(String id);
	
	
}

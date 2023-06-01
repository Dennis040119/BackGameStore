package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.entity.Usuario;



public interface UsuarioService {
	
	public List<Usuario> listar();
	public Optional<Usuario> buscar(int id);
	public Optional<Usuario> BuscarPorUser(String id);
	public void save(Usuario Usuario);
	
	public void delete(int id);

}

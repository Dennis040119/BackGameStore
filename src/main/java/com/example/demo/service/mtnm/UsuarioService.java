package com.example.demo.service.mtnm;

import java.util.List;
import java.util.Optional;

import com.example.demo.entity.mtnm.Usuario;



public interface UsuarioService {
	
	public List<Usuario> listar();
	public List<Usuario> listarActivos();
	public Optional<Usuario> buscar(String id);
	public Optional<Usuario> BuscarPorUser(String id);
	public void save(Usuario Usuario);
	public void Actualizar(Usuario Usuario);

	
	public void delete(String id);

}

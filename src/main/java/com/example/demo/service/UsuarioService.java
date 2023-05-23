package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Usuario;
import com.example.demo.entity.UsuarioPk;



public interface UsuarioService {
	
	public List<Usuario> listar();
	public void save(Usuario Usuario);
	public Usuario get(UsuarioPk id);
	public void delete(UsuarioPk id);

}

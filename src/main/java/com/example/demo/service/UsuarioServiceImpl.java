package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Usuario;
import com.example.demo.entity.UsuarioPk;



@Service	
public class UsuarioServiceImpl implements UsuarioService {

	@Autowired
	private com.example.demo.repository.UsuarioRepository repository;

	@Override
	public List<Usuario> listar() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	@Override
	public void save(Usuario Usuario) {
		// TODO Auto-generated method stub

	}

	@Override
	public Usuario get(UsuarioPk id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(UsuarioPk id) {
		// TODO Auto-generated method stub

	}

}

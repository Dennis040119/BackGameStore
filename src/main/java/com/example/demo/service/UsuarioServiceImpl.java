package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Usuario;




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
	public Optional<Usuario> BuscarPorUser(String user) {
		// TODO Auto-generated method stub
		return repository.findbyUser(user);
	}

	@Override
	public void save(Usuario Usuario) {
		repository.save(Usuario);

	}
	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
			repository.deleteById(id);
	}

	@Override
	public Optional<Usuario> buscar(int id) {
		// TODO Auto-generated method stub
		return repository.findById(id);
	}

	

}

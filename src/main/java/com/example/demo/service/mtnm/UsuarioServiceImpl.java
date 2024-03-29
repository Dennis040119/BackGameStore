package com.example.demo.service.mtnm;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.mtnm.Usuario;
import com.example.demo.repository.mtnm.UsuarioRepository;




@Service	
public class UsuarioServiceImpl implements UsuarioService {

	@Autowired
	private UsuarioRepository repository;

	@Override
	public List<Usuario> listar() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}
	
	@Override
	public List<Usuario> listarActivos() {
		// TODO Auto-generated method stub
		return repository.ListarUsuariosActivos();
	}
	
	@Override
	public Optional<Usuario> BuscarPorUser(String user) {
		// TODO Auto-generated method stub
		return repository.findOneByUsername(user);
	}

	@Override
	public void save(Usuario Usuario) {
		repository.save(Usuario);

	}
	
	@Override
	public void Actualizar(Usuario Usuario) {
		// TODO Auto-generated method stub
		repository.save(Usuario);
	}
	@Override
	public void delete(String id) {
		// TODO Auto-generated method stub
			repository.eliminarUsuario(id);
	}

	@Override
	public Optional<Usuario> buscar(String id) {
		// TODO Auto-generated method stub
		return repository.findById(id);
	}

	

	

}

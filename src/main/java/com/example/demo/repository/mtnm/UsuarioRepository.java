package com.example.demo.repository.mtnm;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.mtnm.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario,String> {

	@Query("from Usuario t where t.username = :user")
	public Optional<Usuario> findbyUser(@Param("user")String user);
	
	
	/* @Procedure(procedureName ="ListarUsuariosActivos" )
	 public List<Usuario> ListarUsuariosActivos();*/
	 
	 @Query("from Usuario t where t.estado = 'ac' ")
	 public List<Usuario> ListarUsuariosActivos();
	 
	 @Query("from Usuario t where t.username = :username and t.estado = 'ac' ")
	 Optional<Usuario> BuscarXUser(@Param("username") String username);
	
	 @Procedure(name = "eliminarUsuario")
	 void eliminarUsuario(@Param("id") String nombreUsuario);
}

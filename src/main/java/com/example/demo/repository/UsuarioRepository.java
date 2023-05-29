package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario,Integer> {

	@Query("from Usuario t where t.user = :user")
	public Optional<Usuario> findbyUser(@Param("user")String user);
}

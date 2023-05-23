package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Usuario;
import com.example.demo.entity.UsuarioPk;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario,UsuarioPk> {

}

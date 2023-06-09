package com.example.demo.repository.mtnm;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.mtnm.Videojuego;


public interface VideoJuegoRepository extends JpaRepository<Videojuego, String> {

	// Consulta
	@Query("Select a from Videojuego a where a.nombre like :nombre")
	public abstract List<Videojuego> BuscarVjPorNombre(@Param("nombre") String nombre);
	
	

}

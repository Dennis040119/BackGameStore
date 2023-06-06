package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Genero;
import com.example.demo.entity.Plataforma;

public interface GeneroRepository extends JpaRepository<Genero, String> {

}

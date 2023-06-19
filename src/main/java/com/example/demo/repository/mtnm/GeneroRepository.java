package com.example.demo.repository.mtnm;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.enums.Genero;
import com.example.demo.entity.enums.Plataforma;

public interface GeneroRepository extends JpaRepository<Genero, String> {

}

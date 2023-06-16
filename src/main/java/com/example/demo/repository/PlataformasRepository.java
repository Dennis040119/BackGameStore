package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.enums.Plataforma;

@Repository
public interface PlataformasRepository extends JpaRepository<Plataforma, String>{

}

package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.VideoJuego;

@Repository
public interface VideoJuegoRepository extends JpaRepository<VideoJuego, Integer> {

}

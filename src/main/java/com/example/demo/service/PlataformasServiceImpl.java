package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Plataforma;
@Service
public class PlataformasServiceImpl implements PlaformasService {
	
	@Autowired
	private com.example.demo.repository.PlataformasRepository repo;
	

	@Override
	public List<Plataforma> listar() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

}

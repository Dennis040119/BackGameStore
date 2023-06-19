package com.example.demo.service.mtnm;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.enums.Genero;
import com.example.demo.repository.mtnm.GeneroRepository;
@Service
public class GeneroServiceImpl implements GeneroService {
	
	@Autowired
	private GeneroRepository repo;

	@Override
	public List<Genero> listar() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

}

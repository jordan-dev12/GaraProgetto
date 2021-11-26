package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Gara;

@Repository
public interface GaraRepository extends  JpaRepository<Gara, Integer>{
	
	public Gara findByNome(String nome);
	public Gara findById(int id);
}

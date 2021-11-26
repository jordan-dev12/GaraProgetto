package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Ruolo;

public interface RuoliRepository extends JpaRepository<Ruolo, Integer>{
	
	public Ruolo findByNome(String nome);

}

package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Ruolo;
import com.example.demo.repository.RuoliRepository;

@Service
public class RuoloServiceImpl implements RuoloService {

	@Autowired
	private RuoliRepository ruoloRepository;

	@Override
	public Ruolo findByNome(String nome) {

		return ruoloRepository.findByNome(nome);

	}}

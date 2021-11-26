package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Gara;
import com.example.demo.model.Utente;
import com.example.demo.repository.GaraRepository;
import com.example.demo.repository.UtenteRepository;

@Service
public class GaraServiceImpl implements GaraService {

	@Autowired
	private GaraRepository garaRepository;
	
	@Autowired
	private UtenteRepository utenteRepository;

	@Override
	public void saveGara(Gara gara) {

		garaRepository.save(gara);

	}

	@Override
	public void deleleGara(int id) {

		garaRepository.deleteById(id);

	}

	@Override
	public List<Gara> listGara() {

		return garaRepository.findAll();
	}

	@Override
	public Gara findByNome(String nome) {

		return garaRepository.findByNome(nome);
	}

	@Override
	public void deleteGara(String nome) {
		
		Gara gara = garaRepository.findByNome(nome);
		
		garaRepository.delete(gara);
	
	}

	@Override
	public void aggiungePartecipanti(Gara gara, String emailPartecipante) {
		
		
		Utente utente = utenteRepository.findByEmail(emailPartecipante);
	    gara.getUtenti().add(utente);
	    
	    
	 
	}

	@Override
	public Gara findById(int id) {
		
		return garaRepository.findById(id);
		
	}
	
}

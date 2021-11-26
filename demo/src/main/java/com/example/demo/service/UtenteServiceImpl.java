package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Ruolo;
import com.example.demo.model.Utente;
import com.example.demo.repository.UtenteRepository;


@Service
public class UtenteServiceImpl implements UtenteService{
	
	
	
	@Autowired
	private UtenteRepository utenteRepository;
	
	@Autowired
	private RuoloService ruoloService;

	@Override
	public void save(Utente utente) {
		
		utenteRepository.save(utente);
		
	}

	@Override
	public List<Utente> listUtente() {
		
		return utenteRepository.findAll();
	}

	@Override
	public void delete(int id) {
		
		utenteRepository.deleteById(id);
		
	}

	@Override
	public List<Utente> findListPartecipante(int idGara) {
		// TODO Auto-generated method stub
		return utenteRepository.findListPartecipanteByIdGara(idGara);
	}

	@Override
	public Boolean isExistMail(String email) {
		
		Boolean result = false;
		
		Utente u =  utenteRepository.findByEmail(email);
	
		
		if(u == null)
		{
			
			return result;
		}
		
		result = true;
		return result;
	}

	@Override
	public void assegnaRuolo(Utente utenti, String nameRuolo) {
		
		Ruolo ruolo = ruoloService.findByNome(nameRuolo);
		utenti.getRuoli().add(ruolo);
		
	}

	@Override
	public Utente findByEmail(String email) {
		
		return this.utenteRepository.findByEmail(email);
	}

	@Override
	public Utente findById(int id) {
		
		return this.utenteRepository.findById(id);
	}
	

}

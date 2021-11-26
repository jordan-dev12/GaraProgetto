package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Utente;

public interface UtenteService {

	public void save(Utente utente);

	public List<Utente> listUtente();

	public void delete(int id);

	public List<Utente> findListPartecipante(int idGara);

	public Boolean isExistMail(String email);

	public void assegnaRuolo(Utente partecipante, String ruolo);
	
	public Utente findByEmail(String email);
	
	public Utente findById(int id);

}

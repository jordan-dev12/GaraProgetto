package com.example.demo.controllore;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Gara;
import com.example.demo.model.Ruolo;
import com.example.demo.model.Utente;
import com.example.demo.service.GaraService;
import com.example.demo.service.UtenteService;


@RestController
@RequestMapping("/part")
@CrossOrigin(origins = "http://localhost:4200")
public class UtenteControllore {

	@Autowired
	private GaraService garaService;

	@Autowired
	private UtenteService utenteService;

	@PostMapping("/add")
	public ResponseEntity<String> addPartecipante(@RequestBody Utente utente) {

		if (utenteService.isExistMail(utente.getEmail())) {

			return new ResponseEntity<String>("L'email è gia presente", HttpStatus.NOT_MODIFIED);
		}

		// BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

		// utente.setPassword(encoder.encode(password));

		Set<Ruolo> ruoli = new HashSet<>();
	//	utente.setPassword(password);
		utente.setRuoli(ruoli);

		try {
			utenteService.assegnaRuolo(utente, "ROLE_UTENTE");
			utenteService.save(utente);

			return new ResponseEntity<>("OK", HttpStatus.OK);

		} catch (Exception e) {

			return new ResponseEntity<>("Errore nel aggiunta del Partecipante", HttpStatus.NOT_IMPLEMENTED);

		}

	}
	
	
	@PostMapping(value="/prenota/{idGara}/{emailPartecipante}")
	public ResponseEntity<Gara> prenotaGara(@PathVariable("idGara") Integer idGara,@PathVariable("emailPartecipante") String  emailPartecipante) {
        
		System.out.println(idGara + emailPartecipante);
		Gara  gara ;
		
		gara = garaService.findById(idGara);
		
		if(gara== null)
		  return new ResponseEntity<Gara>(HttpStatus.BAD_REQUEST);
		
		Set<Utente> utenti = gara.getUtenti();

		if (utenti == null) {
			
		    utenti = new HashSet<Utente>();
			gara.setUtenti(utenti);
		}
		
		try {

			garaService.aggiungePartecipanti(gara, emailPartecipante);

			garaService.saveGara(gara);

			 return new ResponseEntity<Gara>(gara, HttpStatus.CREATED);

		} catch (Exception e) {
			return new ResponseEntity<Gara>(gara, HttpStatus.CONFLICT);		
		     
		}

	}
	
	
	


	
	@GetMapping(value = "/utenteById/{id}")
	public Utente findById(@PathVariable("id") Integer id) {
		return utenteService.findById(id);
	}
	
	@GetMapping(value = "/utenteByEmail/{email}")
	public Utente findById(@PathVariable("email") String email) {
		return utenteService.findByEmail(email);
	}
	
	
	
}

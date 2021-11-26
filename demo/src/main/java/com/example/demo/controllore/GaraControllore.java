package com.example.demo.controllore;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Gara;
import com.example.demo.model.Utente;
import com.example.demo.service.GaraService;
import com.example.demo.service.UtenteService;


@RestController
@RequestMapping("/gara")
@CrossOrigin(origins = "http://localhost:4200")
public class GaraControllore {

	@Autowired
	private GaraService garaService;

	@Autowired
	private UtenteService partecipanteService;
    
	
	@PostMapping("/add")
	public ResponseEntity<String> addGara(@RequestParam("nome") String nome, @RequestParam("luogo") String luogo,
			@RequestParam("data") String dataString) {

		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH);

		Date date = null;
		try {
			date = (Date) formatter.parse(dataString);
		} catch (ParseException e) {

			return new ResponseEntity<>("La data deve essere formato in modo dd-MM-yyyy", HttpStatus.NOT_IMPLEMENTED);
		}

		Gara gara = new Gara();

		gara.setNome(nome);
		gara.setLuogo(luogo);
		gara.setData(date);

		try {

			garaService.saveGara(gara);
			return new ResponseEntity<>("La Gara e stata aggiunta", HttpStatus.OK);

		} catch (Exception e) {

			return new ResponseEntity<>("presente una gara con lo stesso nome", HttpStatus.NOT_IMPLEMENTED);
		}

	}

	@GetMapping("/list")
	public List<Gara> listGara() {

		return garaService.listGara();

	}

	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> delete(@PathVariable int id) {

		try {

			garaService.deleleGara(id);
			return new ResponseEntity<String>("SUCESSO",HttpStatus.OK);

		} catch (Exception e) {

			return new ResponseEntity<String>(HttpStatus.NOT_ACCEPTABLE);
		}

	}

	@GetMapping("/listPartecipante/{idGara}")
	public List<Utente> list(@PathVariable int idGara) {
		try {

			List<Utente> result = partecipanteService.findListPartecipante(idGara);
	

			return result;

		} catch (Exception e) {

			return null;
		}

	}

}

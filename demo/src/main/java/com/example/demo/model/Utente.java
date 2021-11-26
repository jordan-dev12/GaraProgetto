package com.example.demo.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="utente")
public class Utente {
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(name="nome")
	private String nome;
	
	@Column(name="cognome")
	private String cognome;
	
	@Column(name="email" ,unique = true, nullable = false)
	private String email;
	
	@Column(name="password")
	private String password;
	
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(name ="utente_ruolo" ,joinColumns = {
	@JoinColumn(name = "utente_id",updatable = true, insertable = false, referencedColumnName = "id") }, 
	inverseJoinColumns = { @JoinColumn(name = "ruolo_id", updatable = true, insertable = false, referencedColumnName = "id") })
	private Set<Ruolo> ruoli;

	
	@ManyToMany(mappedBy = "utenti")
	private Set<Gara> gara;


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getCognome() {
		return cognome;
	}


	public void setCognome(String cognome) {
		this.cognome = cognome;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public Set<Ruolo> getRuoli() {
		return ruoli;
	}


	public void setRuoli(Set<Ruolo> ruoli) {
		this.ruoli = ruoli;
	}


	public Set<Gara> getGara() {
		return gara;
	}


	public void setGara(Set<Gara> gara) {
		this.gara = gara;
	}
	
	
	

}

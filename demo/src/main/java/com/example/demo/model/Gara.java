package com.example.demo.model;


import java.util.Date;
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

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity()
@Table(name="gara")
public class Gara {
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(name="nome" ,unique = true, nullable = false)
	private String nome;
	
	@Column(name="luogo")
	private String luogo;
	
	@Column(name="dataGara")
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private Date data;
	
    @JsonIgnore
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable( name ="gara_utenti" ,joinColumns = {
	@JoinColumn(name = "gara_id",updatable = true, insertable = false, referencedColumnName = "id") }, 
	inverseJoinColumns = { @JoinColumn(name = "utente_id", updatable = true, insertable = false, referencedColumnName = "id") })
	private Set<Utente> utenti;

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

	public String getLuogo() {
		return luogo;
	}

	public void setLuogo(String luogo) {
		this.luogo = luogo;
	}

	public Date getData() {
		return data;
	}

	public Set<Utente> getUtenti() {
		return utenti;
	}

	public void setUtenti(Set<Utente> utenti) {
		this.utenti = utenti;
	}

	public void setData(Date data) {
		this.data = data;
	}

 

	
	

    
	

}

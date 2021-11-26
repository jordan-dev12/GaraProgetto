package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Utente;

@Repository
public interface UtenteRepository extends JpaRepository<Utente, Integer> {
	
   public Utente findByEmail(String email);
	
	@Query("SELECT u  FROM Utente u LEFT JOIN u.gara u1  WHERE u1.id = :idGara")
    public List<Utente> findListPartecipanteByIdGara(@Param("idGara") int idGara);

	public Utente findById(int id);
}

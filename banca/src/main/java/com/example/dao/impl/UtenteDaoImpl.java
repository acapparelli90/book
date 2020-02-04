package com.example.dao.impl;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Root; 
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;  
import com.example.dao.entity.Transazione;
import com.example.dao.entity.Utente;
import com.example.dto.UtenteDto;

@Repository
public class UtenteDaoImpl implements UtenteDaoInterface {

	@PersistenceContext
	EntityManager em;
	
	@Autowired
	ModelMapper mp;


	@Override
	public List<UtenteDto> getAll() {
		CriteriaBuilder criteria = em.getCriteriaBuilder();
		CriteriaQuery<UtenteDto> query = criteria.createQuery(UtenteDto.class);
		Root<Utente> root = query.from(Utente.class);
		query.select(criteria.construct(UtenteDto.class, root.get("idutente"), root.get("nome"), root.get("cognome"),
				root.get("numeroconto"), root.get("saldo")));
		TypedQuery<UtenteDto> result = em.createQuery(query);
		return result.getResultList();
	}

	@Override
	public List<UtenteDto> findTransazioniById(Integer id) {
		CriteriaBuilder criteria = em.getCriteriaBuilder();
		CriteriaQuery<UtenteDto> query = criteria.createQuery(UtenteDto.class);
		Root<Utente> root = query.from(Utente.class);
		Join<Utente, Transazione> ut = root.join("Settransazioni");
		query.where(criteria.equal(root.get("idutente"), id));
		query.select(criteria.construct(UtenteDto.class, root.get("idutente"), root.get("nome"), root.get("cognome"),
				root.get("numeroconto"), root.get("saldo"), ut.get("tipo"), ut.get("importo")));
		TypedQuery<UtenteDto> result = em.createQuery(query);
		return result.getResultList();
	}

	@Override
	@Transactional
	public UtenteDto save(UtenteDto utente) { 
		em.persist(mp.map(utente, Utente.class));
		return utente;
	}

}

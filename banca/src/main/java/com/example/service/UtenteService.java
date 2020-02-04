package com.example.service;

import java.util.List; 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service; 
import com.example.dao.impl.UtenteDaoInterface;
import com.example.dto.UtenteDto;

@Service
public class UtenteService implements UtenteServiceInterface {

	@Autowired
	UtenteDaoInterface udi;

	@Override
	public List<UtenteDto> getAll() {
		return udi.getAll();
	}

	public List<UtenteDto> findTransazioniById(Integer id) {
		return udi.findTransazioniById( id);
	}

	@Override
	public UtenteDto save(UtenteDto utente) { 
		return  udi.save(utente);
	} 
	
	
}

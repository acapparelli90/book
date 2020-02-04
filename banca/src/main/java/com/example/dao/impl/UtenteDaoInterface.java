package com.example.dao.impl;

import java.util.List;

import com.example.dto.UtenteDto;

public interface UtenteDaoInterface {
	
	public List<UtenteDto> getAll();

	public List<UtenteDto> findTransazioniById(Integer id);

	public UtenteDto save(UtenteDto utente);


}

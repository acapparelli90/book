package com.example.service;

import java.util.List; 
import com.example.dto.UtenteDto; 

public interface UtenteServiceInterface {
	
	public List<UtenteDto> getAll();
	
	public List<UtenteDto> findTransazioniById(Integer id);
	
	public UtenteDto save(UtenteDto utente);
}

package com.example.controller;

import java.util.List; 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController; 
import com.example.dto.UtenteDto;
import com.example.service.UtenteService; 

@RestController
@RequestMapping("/api/utente")
public class UtenteController {

	@Autowired
	UtenteService usi;

	@GetMapping(value = "")
	public ResponseEntity<List<UtenteDto>> getAll() {
		return new ResponseEntity<List<UtenteDto>>(usi.getAll(), HttpStatus.OK);
	}

	@GetMapping(value = "/transazioni/{id}")
	public ResponseEntity<List<UtenteDto>> getTransazioni(@PathVariable("id") Integer id) {
		return new ResponseEntity<List<UtenteDto>>(usi.findTransazioniById(id), HttpStatus.OK);
	}

	@PostMapping(value = "/save")
	public UtenteDto save(@RequestBody UtenteDto utente) {
		return usi.save(utente);

	}

}
package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController; 
import com.example.dto.TransazioneDto; 
import com.example.service.TransazioneService; 

@RestController
@RequestMapping(value = "/api/transazione")
public class TransazioneController {
	
	@Autowired
	TransazioneService ts;
	
	@PostMapping()
	public TransazioneDto insertBook(@RequestBody TransazioneDto transazione) {
		return ts.save(transazione);
	}

	@GetMapping(value = "/get")
	public ResponseEntity<List<TransazioneDto>>  getAll(){
		return  new ResponseEntity<List<TransazioneDto>>(ts.getAll(), HttpStatus.OK);
		
	}
	

	@RequestMapping(value = "/sum")
	public void Sum() {
		ts.Sum();
	}
}

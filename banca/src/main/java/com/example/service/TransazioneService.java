package com.example.service;
 
import java.util.List; 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service; 
import com.example.dao.impl.TransazioneDaoInterface;
import com.example.dto.TransazioneDto;

@Service
public class TransazioneService implements TransazioneServiceInterface{

	@Autowired
	TransazioneDaoInterface tdi;
	
	@Override
	public TransazioneDto save(TransazioneDto Transazione) { 
		return tdi.save(Transazione);
	}

	@Override
	public List<TransazioneDto> getAll() { 
		return tdi.getAll();
	}
	
	@Override
	public void Sum() {
		tdi.Sum();
		
	}
 

	 
	}

	 

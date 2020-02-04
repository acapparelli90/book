package com.example.service; 

import java.util.List; 
import com.example.dto.TransazioneDto; 

public interface TransazioneServiceInterface { 

	public TransazioneDto save(TransazioneDto Transazione);
	public  List<TransazioneDto> getAll();
	public void Sum();
	 
	}
 
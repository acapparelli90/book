package com.example.dao.impl;

import java.util.List; 
import com.example.dto.TransazioneDto;

public interface TransazioneDaoInterface {
 
	public TransazioneDto save(TransazioneDto Transazione);
	public List<TransazioneDto> getAll();
	public void Sum();
}

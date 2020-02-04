package com.example.dto;

import com.example.dao.entity.Utente;

public class TransazioneDto {
	
	private Integer idtransazione;
	private String tipo;
	private int importo;
	private Integer idcontocorrenteesterna;
	private  Utente utente;

	public TransazioneDto() {
	}

	public TransazioneDto(Integer idtransazione, String tipo, int importo, Integer idcontocorrenteesterna) { 
		this.idtransazione = idtransazione;
		this.tipo = tipo;
		this.importo = importo;
		this.idcontocorrenteesterna = idcontocorrenteesterna;
	} 

	public Utente getUtente() {
		return utente;
	}

	public void setUtente(Utente utente) {
		this.utente = utente;
	}

	public Integer getIdtransazione() {
		return idtransazione;
	}

	public void setIdtransazione(Integer idtransazione) {
		this.idtransazione = idtransazione;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public int getImporto() {
		return importo;
	}

	public void setImporto(int importo) {
		this.importo = importo;
	}

	public Integer getIdcontocorrenteesterna() {
		return idcontocorrenteesterna;
	}

	public void setIdcontocorrenteesterna(Integer idcontocorrenteesterna) {
		this.idcontocorrenteesterna = idcontocorrenteesterna;
	}

}

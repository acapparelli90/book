package com.example.dto;

import java.util.Set; 
import com.example.dao.entity.Transazione;

public class UtenteDto {

	private Integer idutente;
	private String nome;
	private String cognome;
	private String numeroconto;
	private int saldo;
	private Set<Transazione>  transazioni;
	private String tipo;
	private int importo;


	public UtenteDto() {
	}

	public UtenteDto(Integer idutente, String nome, String cognome, String numeroconto, int saldo) {
		this.idutente = idutente;
		this.nome = nome;
		this.cognome = cognome;
		this.numeroconto = numeroconto;
		this.saldo = saldo;
	}

	
	
	public UtenteDto(Integer idutente, String nome, String cognome, String numeroconto, int saldo, String tipo,
			int importo) { 
		this.idutente = idutente;
		this.nome = nome;
		this.cognome = cognome;
		this.numeroconto = numeroconto;
		this.saldo = saldo;
		this.tipo = tipo;
		this.importo = importo;
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

	public Integer getIdutente() {
		return idutente;
	}

	public void setIdutente(Integer idutente) {
		this.idutente = idutente;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getNumeroconto() {
		return numeroconto;
	}

	public void setNumeroconto(String numeroconto) {
		this.numeroconto = numeroconto;
	}

	public int getSaldo() {
		return saldo;
	}

	public void setSaldo(int saldo) {
		this.saldo = saldo;
	}

	public Set<Transazione> getTransazioni() {
		return transazioni;
	}

	public void setTransazioni(Set<Transazione> transazioni) {
		this.transazioni = transazioni;
	}

	
	
}

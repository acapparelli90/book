package com.example.dao.entity;

import java.io.Serializable;
import java.util.Set; 
import javax.persistence.Column;
import javax.persistence.Entity; 
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="utente")
public class Utente implements Serializable {
	 
	private static final long serialVersionUID = -4121848323173319124L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idutente;
	
	@Column(name = "nome")
	private String nome; 

	@Column(name = "cognome")
	private String cognome;
	
	@Column(name = "numeroconto")
	private String numeroconto;
	
	@Column(name = "saldo")
	private int saldo;

	@OneToMany(mappedBy = "utente")
	private Set<Transazione>  Settransazioni;
	
	
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

	public Set<Transazione> getSettransazioni() {
		return Settransazioni;
	}

	public void setSettransazioni(Set<Transazione> settransazioni) {
		Settransazioni = settransazioni;
	}
	 
	
	
}

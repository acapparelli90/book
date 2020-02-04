package com.example.dao.entity;

import java.io.Serializable; 
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne; 
import javax.persistence.Table;  
  

@Entity
@Table(name="transazione")
public class Transazione implements Serializable {
	 
	private static final long serialVersionUID = -3980037499046701335L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idtransazione;
	
	@Column
	private String tipo;
	
	@Column
	private int importo;
	
	@Column(insertable = false, updatable = false)
	private Integer idcontocorrenteesterna;
	
	@ManyToOne
	@JoinColumn(name = "idcontocorrenteesterna")
	private  Utente utente;
	
	
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

	public Utente getUtente() {
		return utente;
	}

	public void setUtente(Utente utente) {
		this.utente = utente;
	}
	
	

}

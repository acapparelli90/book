package com.example.dao.impl;

import java.math.BigDecimal;
import java.util.List; 
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root; 
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.dao.entity.Transazione;
import com.example.dto.TransazioneDto; 

@Repository
public class TransazioneDaoImpl implements TransazioneDaoInterface {

	@PersistenceContext
	EntityManager em;

	@Autowired
	ModelMapper mp;

	@Override
	@Transactional
	public TransazioneDto save(@RequestBody TransazioneDto Transazione) {
		em.persist(mp.map(Transazione, Transazione.class));
		return Transazione;

	}

	@Override
	public List<TransazioneDto> getAll() {
		CriteriaBuilder criteria = em.getCriteriaBuilder();
		CriteriaQuery<TransazioneDto> query = criteria.createQuery(TransazioneDto.class);
		Root<Transazione> root = query.from(Transazione.class);
		query.select(criteria.construct(TransazioneDto.class, root.get("idtransazione"), root.get("tipo"),
				root.get("importo"), root.get("idcontocorrenteesterna")));
		TypedQuery<TransazioneDto> result = em.createQuery(query);
		return result.getResultList();
	}
	
	@Override
	public void Sum() {  
		      CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
		      CriteriaQuery<BigDecimal> query = criteriaBuilder.createQuery(BigDecimal.class);
		      Root<Transazione> root  = query.from(Transazione.class);
		      query.select(criteriaBuilder.sum(root.get("importo").as(BigDecimal.class)));
		      TypedQuery<BigDecimal> typedQuery = em.createQuery(query);
		      BigDecimal sum = typedQuery.getSingleResult();
		      System.out.println(sum); 
		  }
}
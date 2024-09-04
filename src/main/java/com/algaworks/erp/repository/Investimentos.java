package com.algaworks.erp.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.algaworks.erp.model.Investimento;

public class Investimentos implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager manager;

	public Investimentos() {

	}

	public Investimentos(EntityManager manager) {
		this.manager = manager;
	}

	public Investimento porId(Long id) {
		return manager.find(Investimento.class, id);
	}

	public List<Investimento> pesquisar(String nome) {
		String jpql = "from Investimento where razaoSocial like :razaoSocial";
		
		TypedQuery<Investimento> query = manager
				.createQuery(jpql, Investimento.class);
		
		query.setParameter("razaoSocial", nome + "%");
		
		return query.getResultList();
	}
	
	public List<Investimento> todas() {
         return manager.createQuery("from Investimento", Investimento.class).getResultList();
    }

	public Investimento guardar(Investimento investimento) {
		return manager.merge(investimento);
	}

	public void remover(Investimento investimento) {
		investimento = porId(investimento.getId());
		manager.remove(investimento);
	}
}
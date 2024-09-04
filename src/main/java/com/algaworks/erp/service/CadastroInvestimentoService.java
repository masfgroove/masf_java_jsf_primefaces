package com.algaworks.erp.service;

import java.io.Serializable;

import javax.inject.Inject;

import com.algaworks.erp.model.Investimento;
import com.algaworks.erp.repository.Investimentos;
import com.algaworks.erp.util.Transacional;

public class CadastroInvestimentoService implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private Investimentos investimentos;

    @Transacional
    public void salvar(Investimento investimento) {
        investimentos.guardar(investimento);
    }

    @Transacional
    public void excluir(Investimento investimento) {
        investimentos.remover(investimento);
    }

}
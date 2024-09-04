package com.algaworks.erp.controller;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import javax.faces.convert.Converter;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.PrimeFaces;


import com.algaworks.erp.model.Investimento;
import com.algaworks.erp.model.RamoAtividade;

import com.algaworks.erp.repository.Investimentos;
import com.algaworks.erp.repository.RamoAtividades;
import com.algaworks.erp.service.CadastroInvestimentoService;
import com.algaworks.erp.service.CotacaoDolarService;
import com.algaworks.erp.util.FacesMessages;

@Named
@ViewScoped
public class GestaoInvestimentosBean implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Inject
    private Investimentos investimentos;
    
    @Inject
    private FacesMessages messages;
    
    @Inject
    private RamoAtividades ramoAtividades;
    
    @Inject
    private CadastroInvestimentoService cadastroInvestimentoService;
    
    @Inject
    private CotacaoDolarService cotacaoDolarService;

    
    private List<Investimento> listaInvestimentos;
    
    private String termoPesquisa;
    
    private Converter ramoAtividadeConverter;
    
    private Investimento investimento;
    
    
    /*
    public void prepararNovaInvestimento() {
        investimento = new Investimento();
    }
    */
    public void prepararNovaInvestimento() {
        investimento = new Investimento();
        
        try {
            double cotacaoDolar = cotacaoDolarService.obterCotacaoDolar();
            investimento.setDolarHoje(cotacaoDolar); // Assume que o campo no modelo é `dolarHoje`
        } catch (RuntimeException e) {
            messages.error("Erro ao obter a cotação do dólar: " + e.getMessage());
        }
    }
    
    private void calcularPorcentagem() {
        if (investimento.getEntrada() != 0) {
            double porcentagem = (investimento.getLucroDolar() / investimento.getEntrada()) * 100;
            investimento.setPorcentagem(porcentagem);
        } else {
            investimento.setPorcentagem(0);
        }
    }
    
    public double getSomaLucroReais() {
        return listaInvestimentos.stream()
                .mapToDouble(Investimento::getLucroReais)
                .sum();
    }
    
    private void calcularLucroReais() {
        if (investimento.getEntrada() != 0) {
            double lucroReais = (investimento.getLucroDolar() * investimento.getDolarHoje());
            investimento.setLucroReais(lucroReais);
        } else {
            investimento.setLucroReais(0);
        }
    }
    
    private void calcularTotalDolares() {
        if (investimento.getEntrada() != 0) {
            double totalDolares = (investimento.getEntrada() + investimento.getLucroDolar());
            investimento.setTotalDolares(totalDolares);
        } else {
            investimento.setTotalDolares(0);
        }
    }
    
    private void calcularTotalReais() {
        if (investimento.getEntrada() != 0) {
            double cotacaoDolar = investimento.getDolarHoje(); // Obtenha a cotação do dólar
            double totalDolares = investimento.getTotalDolares(); // Obtenha o total em dólares
            double totalReais = totalDolares * cotacaoDolar; // Calcule o total em reais
            investimento.setTotalReais(totalReais); // Defina o total em reais no objeto investimento
        } else {
            investimento.setTotalReais(0); // Caso a entrada seja 0, total em reais também deve ser 0
        }
    }

    
    
    public void salvar() {
    	calcularPorcentagem();
    	calcularLucroReais();
    	calcularTotalDolares();
    	calcularTotalReais();
    	//investimento.calcularPorcentagem();
    	cadastroInvestimentoService.salvar(investimento);
        
        atualizarRegistros();
        
        
        messages.info("Investimento salva com sucesso!");
        
        // Atualizando os componentes com PrimeFaces API
        PrimeFaces.current().ajax().update(Arrays.asList(
                "frm:investimentosDataTable", "frm:messages"));
    }
    
    
    public void excluir() {
        cadastroInvestimentoService.excluir(investimento);
        
        investimento = null;
        
        atualizarRegistros();
        
        messages.info("Investimento excluída com sucesso!");
    }
    
    public void pesquisar() {
        listaInvestimentos = investimentos.pesquisar(termoPesquisa);
        
        if (listaInvestimentos.isEmpty()) {
            messages.info("Sua consulta não retornou registros.");
        }
    }
    
    public void todasInvestimentos() {
        listaInvestimentos = investimentos.todas();
    }
    
    public List<RamoAtividade> completarRamoAtividade(String termo) {
        List<RamoAtividade> listaRamoAtividades = ramoAtividades.pesquisar(termo);
        
        ramoAtividadeConverter = new RamoAtividadeConverter(listaRamoAtividades);
        
        return listaRamoAtividades;
    }
    
    private void atualizarRegistros() {
        if (jaHouvePesquisa()) {
            pesquisar();
        } else {
            todasInvestimentos();
        }
    }
    
    
    private boolean jaHouvePesquisa() {
        return termoPesquisa != null && !"".equals(termoPesquisa);
    }
    
    public List<Investimento> getListaInvestimentos() {
        return listaInvestimentos;
    }
    
    public String getTermoPesquisa() {
        return termoPesquisa;
    }
    
    public void setTermoPesquisa(String termoPesquisa) {
        this.termoPesquisa = termoPesquisa;
    }
    
  
    
    public Converter getRamoAtividadeConverter() {
        return ramoAtividadeConverter;
    }
    
    public Investimento getInvestimento() {
        return investimento;
    }

    public void setInvestimento(Investimento investimento) {
		this.investimento = investimento;
	}
    
    public boolean isInvestimentoSeleciona() {
        return investimento != null && investimento.getId() != null;
    }
    


    
}
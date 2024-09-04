package com.algaworks.erp.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "investimento")
public class Investimento implements Serializable {

	private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    
	@NotEmpty
	@Column(name = "razao_social", nullable = false, length = 120)
	private String razaoSocial;

    @NotNull
	@Past
	@Temporal(TemporalType.DATE)
	@Column(name = "data")
	private Date data;
	
    
    @Column(name = "entrada")
    private double entrada;

    @Column(name = "porcentagem")
    private double porcentagem;

    @Column(name = "lucro_dolar")
    private double lucroDolar;

    @Column(name = "lucro_reais")
    private double lucroReais;

    @Column(name = "total_dolares")
    private double totalDolares;
    
    
    
    public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	@Column(name = "dias")
    private int dias;

    @Column(name = "dolar_hoje")
    private double dolarHoje;

    @Column(name = "total_reais")
    private double totalReais;

	@Temporal(TemporalType.DATE)
    @Column(name = "data_criacao")
    private Date dataCriacao;

	@Temporal(TemporalType.DATE)
    @Column(name = "data_atualizacao")
    private Date dataAtualizacao;
	
	/*
	 public void calcularPorcentagem() {
	        if (entrada != 0) {
	            this.porcentagem = (lucroDolar / entrada) * 100;
	        } else {
	            this.porcentagem = 0;
	        }
	    }
	 */
	 

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public double getEntrada() {
		return entrada;
	}

	public void setEntrada(double entrada) {
		this.entrada = entrada;
	}

	public double getPorcentagem() {
		return porcentagem;
	}

	public void setPorcentagem(double porcentagem) {
		this.porcentagem = porcentagem;
	}

	public double getLucroDolar() {
		return lucroDolar;
	}

	public void setLucroDolar(double lucroDolar) {
		this.lucroDolar = lucroDolar;
	}

	public double getLucroReais() {
		return lucroReais;
	}

	public void setLucroReais(double lucroReais) {
		this.lucroReais = lucroReais;
	}

	public double getTotalDolares() {
		return totalDolares;
	}

	public void setTotalDolares(double totalDolares) {
		this.totalDolares = totalDolares;
	}

	public int getDias() {
		return dias;
	}

	public void setDias(int dias) {
		this.dias = dias;
	}

	public double getDolarHoje() {
		return dolarHoje;
	}

	public void setDolarHoje(double dolarHoje) {
		this.dolarHoje = dolarHoje;
	}

	public double getTotalReais() {
		return totalReais;
	}

	public void setTotalReais(double totalReais) {
		this.totalReais = totalReais;
	}

	public Date getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public Date getDataAtualizacao() {
		return dataAtualizacao;
	}

	public void setDataAtualizacao(Date dataAtualizacao) {
		this.dataAtualizacao = dataAtualizacao;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Investimento other = (Investimento) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Empresa [id=" + id + "]";
	}	
}
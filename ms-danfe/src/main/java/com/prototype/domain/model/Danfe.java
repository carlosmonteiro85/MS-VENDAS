package com.prototype.domain.model;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class Danfe {
	private String naturezaOperacao;
	private String formaPagamento;
	private String serie;
	private String numeroNF;
	private String dataEmissao;
	private String dataSaida;
	private String tipoNF;
	private String ambiente;
	private String emissao;
	private String chave;
	private String protocolo;
	private String versao;
	
	private String emiCNPJ;
	private String emiNome;
	private String emiFantasia;
	private String emiIE;
	private String emiIEST;
	private String emiIM;
	
	private String emiLogradouro;
	private String emiNumero;
	private String emiBairro;
	private String emiMunicipio;
	private String emiUF;
	private String emiCEP;
	private String emiTelefone; 
	
	private String destCNPJ;
	private String destCPF;
	private String destNome;
	private String destIE;
	private String destLogradouro;
	private String destNumero;
	private String destComplemento;
	private String destBairro;
	private String destMunicipio;
	private String destUF;
	private String destCEP;
	private String destTelefone;
	
	private String valorBase; 
	private String valorICMS;
	private String valorBaseST; 
	private String valorST;
	private String valorProdutos;
	private String valorFrete;
	private String valorSeguro; 
	private String valorDesconto;
	private String valorOutro;
	private String valorIPI;
	private String valorNF;

	private String frete;	
	private String transCNPJ;
	private String transNome;
    private String transIE;
    private String transEndereco;
    private String transMunicipio;
    private String transUF;
    private String transVolumes;
    private String transEspecie;
    private String transMarca;
    private String transNumeracao;
    private String transPesoB;
    private String transPesoL;
    private String transANTT;
    private String transPlaca;
    private String transPlacaUF;

    private String iSSQNTotal;
    private String iSSQNBase;
    private String iSSQNValor;
    private String bindInfo;
    private String informacoes;
    
    private String prodCodigo;
    private String prodDescricao;
    private String prodNCM;
    private String prodCFOP;
    private String prodUnidade; 
    private String prodQuantidade;
    private String prodValor;
    private String prodTotal;
    private String prodCSOSN;
    private String prodCST;
    private String prodBC;
    private String prodAliqICMS;
    private String prodValorICMS;
    private String prodAliqIPI;
    private String prodValorIPI;
    private List<Produto> produtos = new ArrayList<>();
    
    
}    
package com.prototype.mspay.domain.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.prototype.mspay.domain.enuns.TipoPagamentoEnum;

import lombok.Data;

@Data
@Entity
@Table(name = "pagamentos")
public class Pay {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "venda_id")
	private Long idVenda;
	
	@Enumerated(EnumType.ORDINAL)
	@Column(name = "tipo_pagamento")
	private TipoPagamentoEnum tipoPagamento;
	
	@Column(name = "pagamento_parcelado")
	private boolean pagamentoParcelado;
	
	@Column(name = "numero_parcelas")
	private Integer numeroParcelas;
	
	@Column(name = "valor_total")
	private BigDecimal valorTotal;
}

package com.prototype.mspay.api.dto;

import com.prototype.mspay.domain.enuns.TipoPagamentoEnum;

import lombok.Data;

@Data
public class PayRequest {
	private Long idVenda;
	private TipoPagamentoEnum tipoPagamento;
	private boolean pagamentoParcelado;
	private Integer numeroParcelas;
}

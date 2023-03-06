package com.prototype.mspay.domain.enuns;

import lombok.Getter;

public enum TipoPagamentoEnum {

	DINHEIRO_DEBITO(0), CREDITO(1);

	@Getter
	private Integer payCode;

	private TipoPagamentoEnum(Integer paycode) {
		this.payCode = paycode;
	}

	public static TipoPagamentoEnum obterPorNome(Integer payCode) {
		for (TipoPagamentoEnum pay : values()) {
			if (pay.getPayCode().equals(payCode)) {
				return pay;
			}
		}
		return null;
	}
}

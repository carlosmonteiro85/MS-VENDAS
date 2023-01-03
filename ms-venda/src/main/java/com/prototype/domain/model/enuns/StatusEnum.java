package com.prototype.domain.model.enuns;

import lombok.Getter;

public enum StatusEnum {
	ABERTA(0), AGUARDANDO_FECHAMENTO(1), FECHADA(2), CANCELADA(3);

	@Getter
	private Integer statusCode;

	private StatusEnum(Integer statusCode) {
		this.statusCode = statusCode;
	}

	public static StatusEnum obterPorNome(Integer statusCode) {
		for (StatusEnum status : values()) {
			if (status.getStatusCode().equals(statusCode)) {
				return status;
			}
		}
		return null;
	}
}

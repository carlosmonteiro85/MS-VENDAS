package com.prototype.domain.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ErroComunicacaoException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ErroComunicacaoException(String mensagem) {
		super(mensagem);
	}

	public ErroComunicacaoException(String mensagem, Throwable causa) {
		super(mensagem, causa);
	}
}
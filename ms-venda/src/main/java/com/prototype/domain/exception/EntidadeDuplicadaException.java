package com.prototype.domain.exception;

public class EntidadeDuplicadaException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public EntidadeDuplicadaException(String mensagem) {
        super(mensagem);
    }

    public EntidadeDuplicadaException(String mensagem, Throwable causa) {
        super(mensagem,causa);
    }
}
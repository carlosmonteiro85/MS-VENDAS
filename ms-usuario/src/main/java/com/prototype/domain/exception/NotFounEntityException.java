package com.prototype.domain.exception;

public class NotFounEntityException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public NotFounEntityException(String mensagem) {
        super(mensagem);
    }

    public NotFounEntityException(String mensagem, Throwable causa) {
        super(mensagem,causa);
    }
}
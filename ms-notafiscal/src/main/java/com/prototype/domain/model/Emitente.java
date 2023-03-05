package com.prototype.domain.model;

import javax.persistence.Embeddable;

import lombok.Data;

@Data
@Embeddable
public class Emitente {
	private String nome;
	private Endereco endereco;
	private String telefone;
}

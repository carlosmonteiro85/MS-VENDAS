package com.prototype.domain.model;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "usuarios")
@NoArgsConstructor
public class Usuario {
	
	@Getter
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Getter
	@Setter
	@Column(name = "nome")
	private String nome;
	
	@Getter
	@Setter
	@Column(name = "cpf", unique = true)
	private String cpf;
	
	@Getter
	@Setter
	@Embedded
	@Column(name = "endereco")
	private Endereco endereco;
	
	public Usuario(String nome) {
		this.nome = nome;
	}
}

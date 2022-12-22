package com.prototype.domain.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "produtos")
public class Produto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Getter
	@Setter
	@Column(name = "nome")
	private String nome;
	@Getter
	@Setter
	@Column(name = "descricao")
	private String descricao;
	@Getter
	@Setter
	@Column(name = "preco")
	private BigDecimal preco;
	@Setter
	@Getter
	@Column(name = "codigo_barras", unique = true)
	private String codigo ;
}

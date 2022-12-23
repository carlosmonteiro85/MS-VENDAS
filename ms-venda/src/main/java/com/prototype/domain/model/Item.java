package com.prototype.domain.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Entity
@Table(name = "itens")
@Data
public class Item {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String id;
	@Column(name = "codigo_produto")
	private String codigoProduto;
	@Column(name = "valor_unitario")
	private String produto;
	@Column(name = "qt_produto")
	private Integer quantidade;
	@Column(name = "nome_produto")
	private BigDecimal valorItem;
	
	public Item(String codigoProduto, String produto, Integer quantidade, BigDecimal valorItem) {
		this.codigoProduto = codigoProduto;
		this.produto = produto;
		this.quantidade = quantidade;
		this.valorItem = valorItem;
	}
}

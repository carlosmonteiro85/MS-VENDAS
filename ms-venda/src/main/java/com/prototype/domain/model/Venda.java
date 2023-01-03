package com.prototype.domain.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.prototype.api.dto.UsuarioResponsavelDTO;
import com.prototype.domain.model.enuns.StatusEnum;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "vendas")
@NoArgsConstructor
public class Venda {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.ALL}) 
	private List<Item> itens = new ArrayList<>();
	
	@Column(name = "numero_nf")
	private String numeroNf;
	
	@Enumerated(EnumType.ORDINAL)
	@Column(name = "status", nullable = false)
	private StatusEnum status = StatusEnum.ABERTA;
	
	@Column(name = "sub_total")
	private BigDecimal subTotal = new BigDecimal(0);
	
	private BigDecimal total = new BigDecimal(0);
	
	@Embedded
	private UsuarioResponsavelDTO cliente; 

	public Venda(UsuarioResponsavelDTO cliente) {
		this.cliente = cliente;
	}
}

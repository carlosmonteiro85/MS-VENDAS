package com.prototype.domain.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.prototype.domain.model.enuns.StatusEnum;

import lombok.Data;

@Entity
@Data
public class Venda {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@ManyToMany(mappedBy="itens", cascade = CascadeType.ALL)
	private List<Item> itens = new ArrayList<>();
	private BigDecimal subTotal =  BigDecimal.ZERO;
	private BigDecimal total = BigDecimal.ZERO;
	private String numeroNf;
	private StatusEnum status = StatusEnum.ABERTA;
}

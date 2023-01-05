package com.prototype.mspay.api.dto;

import java.math.BigDecimal;

import com.prototype.mspay.domain.enuns.StatusEnum;

import lombok.Data;

@Data
public class VendaDTO {
	private Long id;
	private String numeroNf;
	private BigDecimal subTotal;
	private BigDecimal total;
	private UsuarioResponsavelDTO cliente;
	private StatusEnum status;
}

package com.prototype.api.dto;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.prototype.domain.model.enuns.StatusEnum;

import lombok.Data;

@Data
public class VendaDTO {
	private Long id;
	private List<ItemDto> itens = new ArrayList<>();
	private String numeroNf;
	private StatusEnum status = StatusEnum.ABERTA;
	private BigDecimal subTotal;
	private BigDecimal total;
}

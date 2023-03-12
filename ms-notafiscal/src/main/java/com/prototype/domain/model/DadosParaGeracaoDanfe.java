package com.prototype.domain.model;

import java.time.LocalDateTime;
import java.util.List;

import com.prototype.domain.utils.ConstantsUtil;

import lombok.Data;

@Data
public class DadosParaGeracaoDanfe {
	private Long emitente;
	private NaturezaOperaçãoEnun naturezaOperacao;
	private LocalDateTime saida;
	private Transportadora tranportadora;
	private List<Long> produtos;
	private String frase = ConstantsUtil.MSN_FRASE; 
}

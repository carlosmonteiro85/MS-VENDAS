package com.prototype.domain.model;

import java.time.LocalDateTime;
import java.util.List;

import com.prototype.domain.utils.ConstantsUtil;

import lombok.Data;

@Data
public class DadosParaGeracaoDanfe {
	private Emitente emitente;
	private NaturezaOperaçãoEnun naturezaOperacao;
	private LocalDateTime saida;
	private Transportadora tranportadora;
	private List<Long> itens;
	private String frase = ConstantsUtil.MSN_FRASE; 
}

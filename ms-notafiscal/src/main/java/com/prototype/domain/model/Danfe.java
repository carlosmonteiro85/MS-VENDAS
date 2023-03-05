package com.prototype.domain.model;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.prototype.domain.utils.ConstantsUtil;

import lombok.Data;

@Entity
@Data
public class Danfe {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Enumerated
	private Emitente emitente;
	
	@Column(name = "natureza_operacao")
	private NaturezaOperaçãoEnun naturezaOperacao;
	
	@Column(name = "sada")
	private LocalDateTime saida;
	
	@Enumerated
	private Transportadora tranportadora;
	
	@ElementCollection
	private List<Long> itens;
	
	@Column(name = "frase")
	private String frase = ConstantsUtil.MSN_FRASE;
	
	@Column(name = "chave_acesso")
	private UUID chaveAcesso;
	
	@Column(name = "numero_nf")
	private String numeroNf;

}

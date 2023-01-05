package com.prototype.mspay.domain.service;

import org.springframework.stereotype.Service;

import com.prototype.mspay.api.dto.VendaDTO;
import com.prototype.mspay.domain.enuns.StatusEnum;
import com.prototype.mspay.domain.exception.NegocioException;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PayService {

	private final VendaService vendaService; 
	
	public Object realizarPagamento(Long codigo) {

		VendaDTO venda = vendaService.getVenda(codigo);
		
		if(venda.getStatus() != StatusEnum.ABERTA) {
			throw new NegocioException("Não é possivel realizar o pagamento da venda, pois o status não está aberto");
		}
		
		// TODO enviar para a fila pedido de gerar nota fiscal
		// TODO mudar status da venda para Aguardando finalização
		
		return null;
	}

}

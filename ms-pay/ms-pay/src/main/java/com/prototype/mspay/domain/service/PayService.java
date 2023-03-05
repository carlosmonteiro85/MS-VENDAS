package com.prototype.mspay.domain.service;

import java.math.BigDecimal;

import org.springframework.stereotype.Service;

import com.prototype.mspay.api.dto.PayRequest;
import com.prototype.mspay.api.dto.VendaDTO;
import com.prototype.mspay.core.MapperConverter;
import com.prototype.mspay.domain.enuns.StatusEnum;
import com.prototype.mspay.domain.estrategia.EstrategiaPagamento;
import com.prototype.mspay.domain.estrategia.PagamentoCredito;
import com.prototype.mspay.domain.estrategia.PagamentoDinheiroDebito;
import com.prototype.mspay.domain.exception.NegocioException;
import com.prototype.mspay.domain.model.Pay;
import com.prototype.mspay.domain.repository.PayRepository;
import com.prototype.mspay.domain.service.util.Utils;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PayService {

	private final VendaService vendaService; 
	private final MapperConverter mapper;
	private final PayRepository repository;
	private EstrategiaPagamento tipoPamento;
	
	public boolean realizarPagamento(PayRequest payRequest) {

		VendaDTO venda = vendaService.getVenda(payRequest.getIdVenda());
		
		if(!StatusEnum.ABERTA.equals(venda.getStatus())) {
			throw new NegocioException("Não é possivel realizar o pagamento da venda, pois o status não está aberto");
		}
		
		Pay pay = mapper.dtoToentidade(payRequest, Pay.class);
		
		validarFormaPagamento(pay);
		
		// TODO enviar solicitalçao de geração de nf pelo rabbitmq
		repository.save(pay);
		
		return true;
	}

	private void validarFormaPagamento(Pay pagamento) {
		
		switch (pagamento.getTipoPagamento()) {
		
		case CREDITO:
			tipoPamento = new PagamentoCredito();
			break;
		default: 
			tipoPamento = new PagamentoDinheiroDebito();
		}
		
		tipoPamento.validarPagamento(pagamento);
		
	}
	
	public BigDecimal consultaralorParcela(Pay pagamento) {
		Utils.validarParcelamento(pagamento);
		return Utils.valorParcela(pagamento);
	}
	
	public void payment(Pay pay) {
		repository.save(pay);
	}
}

package com.prototype.mspay.domain.estrategia;

import com.prototype.mspay.domain.enuns.TipoPagamentoEnum;
import com.prototype.mspay.domain.exception.NegocioException;
import com.prototype.mspay.domain.model.Pay;

public class PagamentoDinheiroDebito implements EstrategiaPagamento{

	@Override
	public void validarPagamento(Pay pagamento) {
		
		if(!pagamento.isPagamentoParcelado() && pagamento.getTipoPagamento() != TipoPagamentoEnum.DINHEIRO_DEBITO) {
			throw new NegocioException("O pagamento do Tipo dinheiro ou débito não pode ter o status de parcelado.");
		}
		
	}

}

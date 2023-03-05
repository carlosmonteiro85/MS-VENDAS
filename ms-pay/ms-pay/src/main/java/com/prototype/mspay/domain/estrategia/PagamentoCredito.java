package com.prototype.mspay.domain.estrategia;

import com.prototype.mspay.domain.enuns.TipoPagamentoEnum;
import com.prototype.mspay.domain.exception.NegocioException;
import com.prototype.mspay.domain.model.Pay;
import com.prototype.mspay.domain.service.util.Utils;

public class PagamentoCredito implements EstrategiaPagamento{

	@Override
	public void validarPagamento(Pay pagamento) {
		
		if(pagamento.isPagamentoParcelado() && pagamento.getTipoPagamento() != TipoPagamentoEnum.CREDITO) {
			throw new NegocioException("O pagamento só pode ser parcelado quando possue o tipo Crédito");
		}
		
		Utils.validarParcelamento(pagamento);
	}
}

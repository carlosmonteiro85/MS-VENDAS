package com.prototype.mspay.domain.estrategia;

import com.prototype.mspay.domain.model.Pay;

public interface EstrategiaPagamento {

	void validarPagamento(Pay pagamento);
}

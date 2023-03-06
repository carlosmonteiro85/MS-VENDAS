package com.prototype.mspay.domain.service.util;

import java.math.BigDecimal;
import java.math.RoundingMode;

import com.prototype.mspay.domain.exception.NegocioException;
import com.prototype.mspay.domain.model.Pay;
import com.prototype.mspay.domain.service.AppContants;

public class Utils {
	
	public static Integer validarQuantidadeParcelas(BigDecimal valor) {
		
		BigDecimal valorParcela = new BigDecimal(0);
		Integer qtParcelas = 1;

		for (int i = 1; i == qtParcelas ;  i++) {
			
			qtParcelas++;
			valorParcela = valor.divide(new BigDecimal(qtParcelas), 2, RoundingMode.HALF_UP);
			
			if(valorParcela.intValue() < AppContants.VALOR_MINIMO_PARCELAMENTO) {
				return i;		
			}
			
			if(qtParcelas.equals(AppContants.PARCELAMENTO_MAXIMO)) {
				return AppContants.PARCELAMENTO_MAXIMO;
			}
		}
		return qtParcelas;
	}
	
	public static BigDecimal valorParcela(Pay pagamento) {
		return pagamento.getValorTotal().divide(new BigDecimal(pagamento.getNumeroParcelas()), 2, RoundingMode.HALF_UP);
	}
	
	public static void validarParcelamento(Pay pagamento) {
		
		Integer qtParcelasDisponiveis = Utils.validarQuantidadeParcelas(pagamento.getValorTotal());
		
		if( pagamento.getNumeroParcelas() > qtParcelasDisponiveis ) {
			throw new NegocioException("A quantidade máxima de parcela dispníveis para o valor desta venda é de " + qtParcelasDisponiveis );
		}
	}

}

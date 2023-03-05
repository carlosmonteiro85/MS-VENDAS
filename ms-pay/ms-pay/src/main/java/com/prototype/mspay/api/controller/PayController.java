package com.prototype.mspay.api.controller;

import java.math.BigDecimal;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prototype.mspay.domain.model.Pay;
import com.prototype.mspay.domain.service.PayService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("pagamento")
@RequiredArgsConstructor
public class PayController {
	
	private final PayService service;

//	@GetMapping(params = "codigo")
//	public ResponseEntity<?> efetuarPagamento(@RequestParam("codigo") Long codigo) {
//		return ResponseEntity.ok().body(service.realizarPagamento(codigo));
//	}
	
	// TODO testar
	@GetMapping(value = "valorParcela")
	public ResponseEntity<BigDecimal> obterValorParcela(@RequestBody Pay pagamento) {
		return ResponseEntity.ok().body(service.consultaralorParcela(pagamento));
	}
}

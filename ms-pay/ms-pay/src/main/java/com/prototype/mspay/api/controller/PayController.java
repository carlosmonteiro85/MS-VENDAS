package com.prototype.mspay.api.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.prototype.mspay.domain.service.PayService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("pagamento")
@RequiredArgsConstructor
public class PayController {
	
	private final PayService service;

	@GetMapping(params = "codigo")
	public ResponseEntity<?> efetuarPagamento(@RequestParam("codigo") Long codigo) {
		return ResponseEntity.ok().body(service.realizarPagamento(codigo));
	}
}

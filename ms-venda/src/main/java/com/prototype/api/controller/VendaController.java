package com.prototype.api.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.prototype.api.dto.VendaDTO;
import com.prototype.domain.service.VendaService;
import com.prototype.domain.util.AppConstants;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("vendas")
public class VendaController {
	
	private final VendaService service;
	
	@GetMapping
	public ResponseEntity<VendaDTO> criarVenda( @RequestParam(value = "cpfCliente", defaultValue = "", required = true) String cpfCliente){
		return ResponseEntity.ok().body(service.abrirVenda(cpfCliente));
	}
	
	@GetMapping(value = "add-item", params = {"idVenda", "codigoProduto", "quantidade" })
	public ResponseEntity<VendaDTO> addIttem(
			@RequestParam(value = "idVenda", required = true) Long idVenda,
			@RequestParam(value = "codigoProduto", required = true) String codigoProduto,
			@RequestParam(value = "quantidade", defaultValue = AppConstants.DEFAULT_QT) Integer quantidade){
		return ResponseEntity.ok().body(service.adicionarItem(idVenda, codigoProduto, quantidade));
	}
	
	@GetMapping(value = "remove-item", params = {"idVenda", "codigoProduto"})
	public ResponseEntity<VendaDTO> removeItem(
			@RequestParam(value = "idVenda", required = true) Long idVenda,
			@RequestParam(value = "codigoProduto", required = true) String codigoProduto){
		return ResponseEntity.ok().body(service.removerItem(idVenda, codigoProduto));
	}
	
	@GetMapping("{idVenda}")
	public ResponseEntity<VendaDTO> findById(@PathVariable("idVenda") Long idVenda){
		return ResponseEntity.ok().body(service.findById(idVenda));
	}
}

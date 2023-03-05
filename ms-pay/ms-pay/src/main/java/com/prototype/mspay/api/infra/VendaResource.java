package com.prototype.mspay.api.infra;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.prototype.mspay.api.dto.VendaDTO;


@FeignClient(value = "ms-vendas", path = "/vendas")
public interface VendaResource {
	
	@GetMapping("{idVenda}")
	public ResponseEntity<VendaDTO> findVendaById(@PathVariable("idVenda") Long idVenda);
	
	@GetMapping("gerar-nf/{idVenda}")
	public ResponseEntity<Void> gerarNf(@PathVariable("idVenda") Long idVenda);
}

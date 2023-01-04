package com.prototype.api.infra;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.prototype.api.dto.ProdutoDto;

@FeignClient(value = "ms-produtos", path = "/produtos")
public interface ProdutoResource {
	
		@GetMapping(params = "codigo")
		ResponseEntity<ProdutoDto> dadosProduto(@RequestParam("codigo") String codigo);
}

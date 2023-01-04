package com.prototype.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.prototype.api.dto.ProdutoRequest;
import com.prototype.api.dto.ProdutoResponse;
import com.prototype.core.modelmapper.Configuration;
import com.prototype.domain.service.ProdutoService;
import com.prototype.domain.utils.AppConstants;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("produtos")
@RequiredArgsConstructor
public class ProdutoController {
	
	private final ProdutoService service;

	@GetMapping()
	public ResponseEntity<Page<ProdutoResponse>> findPaginated(
			@RequestParam(value = "page", defaultValue = AppConstants.DEFAULT_NUMERO_PAGINA, required = false) int page, 
			@RequestParam(value = "size", defaultValue = AppConstants.DEFAULT_TOTAL_PAGINA, required = false) int size,
			@RequestParam(value = "sortBy", defaultValue = AppConstants.DEFAULT_SORT_POR, required = false) String sortBy,
			@RequestParam(value = "sortDir", defaultValue = AppConstants.DEFAULT_SORT_DIRECAO, required = false) String sortDir) {
	    return ResponseEntity.ok(service.findAll(page, size, sortBy, sortDir));
	}
	
	@PostMapping()
	public ResponseEntity<ProdutoResponse> saveProduto(@RequestBody ProdutoRequest produto) {
		return ResponseEntity.ok().body(service.save(produto));
	}
	
	@GetMapping(params = "codigo")
	public ResponseEntity<ProdutoResponse> findProdutoCodigo(@RequestParam("codigo") String codigo) {
		return ResponseEntity.ok().body(service.findByCodigo(codigo));
	}
	
	 @Autowired
	    private Configuration configuration;

	    @GetMapping("/endpoint")
	    public String retrieveLimits(){
	        return configuration.getValue();
	    }

}

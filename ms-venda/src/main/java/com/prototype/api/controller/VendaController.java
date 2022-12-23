package com.prototype.api.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("vendas")
public class VendaController {
	
//	@GetMapping()
//	public ResponseEntity<Page<UsuarioOutputDto>> findPaginated(
//			@RequestParam(value = "page", defaultValue = AppConstants.DEFAULT_NUMERO_PAGINA, required = false) int page, 
//			@RequestParam(value = "size", defaultValue = AppConstants.DEFAULT_TOTAL_PAGINA, required = false) int size,
//			@RequestParam(value = "sortBy", defaultValue = AppConstants.DEFAULT_SORT_POR, required = false) String sortBy,
//			@RequestParam(value = "sortDir", defaultValue = AppConstants.DEFAULT_SORT_DIRECAO, required = false) String sortDir) {
//	    return ResponseEntity.ok(service.findAll(page, size, sortBy, sortDir));
//	}

}

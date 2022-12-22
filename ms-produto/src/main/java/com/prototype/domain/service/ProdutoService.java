package com.prototype.domain.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.prototype.api.dto.ProdutoRequest;
import com.prototype.api.dto.ProdutoResponse;
import com.prototype.api.mapper.MapperConverter;
import com.prototype.domain.exception.NotFounEntityException;
import com.prototype.domain.model.Produto;
import com.prototype.domain.repository.ProdutoRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProdutoService {

	private final ProdutoRepository repository;
	private final MapperConverter map;

	public ProdutoResponse save(ProdutoRequest produto) {
		Produto produtoPersisted = repository.save(map.dtoToentidade(produto, Produto.class));
		return map.entidadeToDto(produtoPersisted, ProdutoResponse.class);
	}

	public ProdutoResponse findByCodigo(String codigo) {
		Produto produto = repository.findByCodigo(codigo)
				.orElseThrow(() -> new NotFounEntityException("Não foi encontrado um produto com o código: " + codigo));
		return map.entidadeToDto(produto, ProdutoResponse.class);
	}

	public Page<ProdutoResponse> findAll(int page, int size, String sortBy, String sortDir) {
		Pageable pageable = createPage(page, size, sortBy, sortDir);
		return map.colectionPageDto(repository.findAll(pageable), ProdutoResponse.class);
	}

	private Pageable createPage(int page, int size, String sortBy, String sortDir) {
		Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortBy).ascending()
				: Sort.by(sortBy).descending();
		return PageRequest.of(page, size, sort);
	}
}

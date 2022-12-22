package com.prototype;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.prototype.api.dto.ProdutoRequest;
import com.prototype.api.dto.ProdutoResponse;
import com.prototype.domain.exception.NotFounEntityException;
import com.prototype.domain.repository.ProdutoRepository;
import com.prototype.domain.service.ProdutoService;

public class ProdutoIntegration extends MsProdutoApplicationTests{
	
	private ProdutoRequest produto;
	@Autowired
	private ProdutoService service;
	@Autowired
	private ProdutoRepository repository;
	
	@BeforeEach
	void criarAntesDosTstes(){
		produto = criarProdutoParaTeste();
	}
	
	@AfterEach
	void aposTestes() {
		repository.deleteAll();
	}
	
	@Test
	void salvarProduto() {
		service.save(produto);
		assertNotNull(produto);
	}
	
	@Test
	void buscarProdutoPeloCodigo() {
		service.save(produto);
		ProdutoResponse produtoResponse = service.findByCodigo(produto.getCodigo());
		assertNotNull(produtoResponse);
	}
	
	@Test
	void lancarEcecaoAoNaoEncontrarProdutoPeloCodigo() {
		String menssagemErro = "Não foi encontrado um produto com o código: " + produto.getCodigo() ;
		service.save(produto);
		String codigo = produto.getCodigo();
		repository.deleteAll();
		
		NotFounEntityException error = assertThrows( NotFounEntityException.class , () -> service.findByCodigo(codigo));
		
		assertNotNull(error);
		assertEquals(menssagemErro, error.getMessage());
	}
}

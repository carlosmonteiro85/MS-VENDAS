package com.prototype;

import java.math.BigDecimal;
import java.util.Locale;

import org.springframework.boot.test.context.SpringBootTest;

import com.github.javafaker.Faker;
import com.prototype.api.dto.ProdutoRequest;

@SpringBootTest
public class MsProdutoApplicationTests {

	protected static Faker faker = Faker.instance(new Locale("pt", "BR"));
	
	public ProdutoRequest criarProdutoParaTeste() {
		return ProdutoRequest.builder()
				.nome(faker.commerce().productName())
				.descricao(faker.commerce().productName())
				.preco(new BigDecimal(faker.commerce().price().replace(",", ".")))
				.codigo(faker.commerce().promotionCode())
			.build();
	}
}

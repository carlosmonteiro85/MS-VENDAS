package com.prototype;

import java.util.Locale;

import org.springframework.boot.test.context.SpringBootTest;

import com.github.javafaker.Faker;
import com.prototype.api.dto.UsuarioInputDto;
import com.prototype.domain.model.Endereco;

@SpringBootTest
public class DemoApplicationTests {
	
	protected static Faker faker = Faker.instance(new Locale("pt", "BR"));

	public UsuarioInputDto criarUsuario() {
		UsuarioInputDto usuario = new UsuarioInputDto();
		usuario.setNome(faker.name().fullName());
		usuario.setCpf(faker.number().digits(11));
		return usuario;
	}
	
	public Endereco criarEndereco() {
		Endereco endereco = new Endereco();
		
		endereco.setLogradouro(faker.address().streetName());
		endereco.setNumero(faker.address().buildingNumber());
		endereco.setBairro(faker.address().streetAddress());
		endereco.setCep(faker.address().zipCode());
		endereco.setLocalidade(faker.address().city());
		endereco.setUf(faker.address().cityPrefix());
		
		return endereco;
	}
}

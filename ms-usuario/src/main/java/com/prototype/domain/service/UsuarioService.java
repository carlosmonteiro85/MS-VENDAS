package com.prototype.domain.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.prototype.api.dto.UsuarioInputDto;
import com.prototype.api.dto.UsuarioOutputDto;
import com.prototype.core.modelmapper.MapperConverter;
import com.prototype.domain.exception.EntidadeDuplicadaException;
import com.prototype.domain.exception.NotFounEntityException;
import com.prototype.domain.model.Usuario;
import com.prototype.domain.repository.UsuarioRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UsuarioService {

	private final UsuarioRepository repository;

	private final MapperConverter map;

	public UsuarioOutputDto findByCpf(String cpf) {

		Usuario usuario = repository.obterPorCpf(cpf)
				.orElseThrow(() -> new NotFounEntityException("Não existe um usuario com o cpf informado."));

		return map.entidadeToDto(usuario, UsuarioOutputDto.class);
	}

	public UsuarioOutputDto save(UsuarioInputDto usuario) {

		validarDublicidadeCpf(usuario.getCpf());

		Usuario usuarioPersisted = map.dtoToentidade(usuario, Usuario.class);
		repository.save(usuarioPersisted);
		return map.entidadeToDto(usuarioPersisted, UsuarioOutputDto.class);
	}

	private void validarDublicidadeCpf(String cpf) {
		Optional<Usuario> usuarioBd = repository.obterPorCpf(cpf);

		if (usuarioBd.isPresent()) {
			throw new EntidadeDuplicadaException("Já exist um usuario com o cpf " + cpf + " cadastrado.");
		}
	}

	public Page<UsuarioOutputDto> findAll(int page, int size, String sortBy, String sortDir) {
		Pageable pageable = createPage(page, size, sortBy, sortDir);
		return map.colectionPageDto(repository.findAll(pageable), UsuarioOutputDto.class);
	}

	private Pageable createPage(int page, int size, String sortBy, String sortDir) {
		Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortBy).ascending()
				: Sort.by(sortBy).descending();
		return PageRequest.of(page, size, sort);
	}
}

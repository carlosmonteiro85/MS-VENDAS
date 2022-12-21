package com.prototype.domain.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.prototype.api.dto.UsuarioInputDto;
import com.prototype.api.dto.UsuarioOutputDto;
import com.prototype.core.modelmapper.MapperConverter;
import com.prototype.domain.exception.EntidadeDuplicadaException;
import com.prototype.domain.model.Usuario;
import com.prototype.domain.repository.UsuarioRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UsuarioService {

	private final UsuarioRepository repository;

	private final MapperConverter map;

	public Usuario findByUsuarioForCpf(String cpf) {
		return repository.findByCpf(cpf).orElseThrow(
				() -> new EntidadeDuplicadaException("Já existe um usuário cadastrado com o cpf informado."));
	}

	public UsuarioOutputDto save(UsuarioInputDto usuario) {
		Usuario usuarioPersisted = map.dtoToentidade(usuario, Usuario.class);
		repository.save(usuarioPersisted);
		return map.entidadeToDto(usuarioPersisted, UsuarioOutputDto.class);
	}

	public Page<UsuarioOutputDto> findAll(int page, int size, String sortBy, String sortDir) {
		Pageable pageable = createPage(page, size, sortBy, sortDir);
		return map.colectionPageDto(repository.findAll(pageable), UsuarioOutputDto.class);
	}

	private Pageable createPage(int page, int size, String sortBy, String sortDir) {
		Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();
		return PageRequest.of(page, size, sort);
	}
}

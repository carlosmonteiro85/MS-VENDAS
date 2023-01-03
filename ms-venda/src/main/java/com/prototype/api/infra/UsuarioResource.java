package com.prototype.api.infra;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.prototype.api.dto.UsuarioResponsavelDTO;

@FeignClient(value = "ms-usuarios", path = "/usuarios")
public interface UsuarioResource {
	
		@GetMapping(params = "cpf")
		ResponseEntity<UsuarioResponsavelDTO> getUsuario(@RequestParam("cpf") String cpf);
}

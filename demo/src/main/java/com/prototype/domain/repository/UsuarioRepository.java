package com.prototype.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prototype.domain.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

}

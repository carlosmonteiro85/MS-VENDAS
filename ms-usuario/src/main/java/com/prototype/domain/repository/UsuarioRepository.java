package com.prototype.domain.repository;

import org.springframework.data.domain.Pageable;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.prototype.domain.model.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
	
	@Query(value = "select * from usuarios u where u.cpf = :cpf", nativeQuery = true)
	Optional<Usuario> findByCpf(@Param("cpf")   String cpf);
	
	@Query(value = "select u from Usuario u" )
	Page<Usuario> findAll(Pageable page);
}

package com.prototype.domain.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.prototype.domain.model.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long>{

	@Query(value = "select p from Produto p where p.codigo = :codigo ")
	Optional<Produto> findByCodigo(@Param("codigo") String codigo);

}

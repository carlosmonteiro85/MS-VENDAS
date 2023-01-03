package com.prototype.domain.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.prototype.domain.model.Venda;
import com.prototype.domain.model.enuns.StatusEnum;

@Repository
public interface VendasRepository extends JpaRepository<Venda, Long>{
	
	@Query(value = "select * from vendas where cpf = :cpfCliente and status = :status ", nativeQuery = true)
	Optional<Venda> obterVendaPorStatusECpfCliente(@Param("cpfCliente") String cpfCliente, @Param("status") StatusEnum status);
}

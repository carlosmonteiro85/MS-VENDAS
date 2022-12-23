package com.prototype.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.prototype.domain.model.Venda;

@Repository
public interface VendasRepository extends JpaRepository<Venda, Long>{
}

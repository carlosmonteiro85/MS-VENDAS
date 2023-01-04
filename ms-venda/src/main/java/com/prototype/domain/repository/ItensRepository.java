package com.prototype.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.prototype.domain.model.Item;

@Repository
public interface ItensRepository extends JpaRepository<Item, Long>{
}

package com.prototype.mspay.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prototype.mspay.domain.model.Pay;

public interface PayRepository extends JpaRepository<Pay, Long>{
}

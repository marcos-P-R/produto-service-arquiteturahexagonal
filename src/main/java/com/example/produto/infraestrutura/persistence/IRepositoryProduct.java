package com.example.produto.infraestrutura.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRepositoryProduct extends JpaRepository<Product, Integer> {
}

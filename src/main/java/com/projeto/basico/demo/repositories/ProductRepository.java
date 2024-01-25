package com.projeto.basico.demo.repositories;

import com.projeto.basico.demo.entities.Category;
import com.projeto.basico.demo.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}

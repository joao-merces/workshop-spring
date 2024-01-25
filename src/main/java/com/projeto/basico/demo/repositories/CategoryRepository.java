package com.projeto.basico.demo.repositories;

import com.projeto.basico.demo.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}

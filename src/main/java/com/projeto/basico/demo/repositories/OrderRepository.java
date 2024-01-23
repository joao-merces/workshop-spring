package com.projeto.basico.demo.repositories;

import com.projeto.basico.demo.entities.Order;
import com.projeto.basico.demo.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {

}

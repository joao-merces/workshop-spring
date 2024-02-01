package com.projeto.basico.demo.repositories;

import com.projeto.basico.demo.entities.OrderItem;
import com.projeto.basico.demo.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {

}

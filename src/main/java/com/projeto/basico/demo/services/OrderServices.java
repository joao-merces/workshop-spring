package com.projeto.basico.demo.services;

// Esta seria a camada de serviço, a mesma fica entre o acesso aos dados e a camada de controllers, pode ser usada para
// aplicar regras de negocios ou fazer verificações, enquanto a camada de controllers simplismente chama essa camada, e
// a camada de acesso aos dados apenas acessa ou insere dados ao db

import com.projeto.basico.demo.entities.Order;
import com.projeto.basico.demo.entities.User;
import com.projeto.basico.demo.repositories.OrderRepository;
import com.projeto.basico.demo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

// O @Component registra a classe UserServices como componente para ser usado
// Mas pode-se usar o @Service para ficar mais semanticamente correto
@Service
public class OrderServices {

    // Autorwired cria uma dependencia automaticamente injetada
    @Autowired
    private OrderRepository repository;

    public Order finById(Long id) {
        Optional<Order> obj = repository.findById(id);
        return obj.get();
    }

    public List<Order> findAll() {
        return repository.findAll();
    }

}

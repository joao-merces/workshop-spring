package com.projeto.basico.demo.services;

// Esta seria a camada de serviço, a mesma fica entre o acesso aos dados e a camada de controllers, pode ser usada para
// aplicar regras de negocios ou fazer verificações, enquanto a camada de controllers simplismente chama essa camada, e
// a camada de acesso aos dados apenas acessa ou insere dados ao db

import com.projeto.basico.demo.entities.Product;
import com.projeto.basico.demo.entities.User;
import com.projeto.basico.demo.repositories.ProductRepository;
import com.projeto.basico.demo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

// O @Component registra a classe UserServices como componente para ser usado
// Mas pode-se usar o @Service para ficar mais semanticamente correto
@Service
public class ProductServices {

    // Autorwired cria uma dependencia automaticamente injetada
    @Autowired
    private ProductRepository repository;

    public Product finById(Long id) {
        Optional<Product> obj = repository.findById(id);
        return obj.get();
    }

    public List<Product> findAll() {
        return repository.findAll();
    }

}

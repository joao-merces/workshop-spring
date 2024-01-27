package com.projeto.basico.demo.config;

import com.projeto.basico.demo.entities.Category;
import com.projeto.basico.demo.entities.Order;
import com.projeto.basico.demo.entities.Product;
import com.projeto.basico.demo.entities.enums.OrderStatus;
import com.projeto.basico.demo.repositories.CategoryRepository;
import com.projeto.basico.demo.repositories.OrderRepository;
import com.projeto.basico.demo.repositories.ProductRepository;
import com.projeto.basico.demo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import com.projeto.basico.demo.entities.User;

import java.time.Instant;
import java.util.Arrays;

// Quando estiver no perfil de teste usara essa classe para testes
// Essa classe tem por objetivo popular o db para testes
@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ProductRepository productRepository;

    // Este metodo executa todas as linhas dentro dele quando a aplicação for iniciada (necessario implementar o commandlinerunner)
    @Override
    public void run(String... args) throws Exception {
        User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
        User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");

        /* Como todo pedido tem um user associado, para instanciar uma order, passa-se o pedido e o user que fez o pedido*/
        Order o1 = new Order(null, OrderStatus.PAID, Instant.parse("2019-06-20T19:53:07Z"), u1);
        Order o2 = new Order(null, OrderStatus.WAITING_PAYMENT, Instant.parse("2019-07-21T03:42:10Z"), u2);
        Order o3 = new Order(null, OrderStatus.WAITING_PAYMENT, Instant.parse("2019-07-22T15:21:22Z"),u1);

        Category c1 = new Category(null, "Eletronics");
        Category c2 = new Category(null, "Books");
        Category c3 = new Category(null, "Computers");

        Product p1 = new Product(null,"test","test","teste");
        Product p2 = new Product(null,"test","test","teste");
        Product p3 = new Product(null,"test","test","teste");


        userRepository.saveAll(Arrays.asList(u1,u2));
        orderRepository.saveAll(Arrays.asList(o1,o2,o3));
        categoryRepository.saveAll(Arrays.asList(c1,c2,c3));
        productRepository.saveAll(Arrays.asList(p1,p2,p3));

        p1.getCategories().add(c2);
        p2.getCategories().add(c1);
        p2.getCategories().add(c3);
        p3.getCategories().add(c3);
        productRepository.saveAll(Arrays.asList(p1,p2,p3));
    }
}

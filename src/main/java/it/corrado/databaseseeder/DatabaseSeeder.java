package it.corrado.databaseseeder;

import it.corrado.enums.OrderStatus;
import it.corrado.enums.Role;
import it.corrado.model.*;
import it.corrado.repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
public class DatabaseSeeder implements CommandLineRunner {

    private final UserRepository userRepository;
    private final ProductRepository productRepository;
    private final OrderRepository orderRepository;
    private final AddressRepository addressRepository;
    private final FavoriteProductRepository favoriteProductRepository;

    public DatabaseSeeder(UserRepository userRepository, ProductRepository productRepository,
                          OrderRepository orderRepository,
                          AddressRepository addressRepository, FavoriteProductRepository favoriteProductRepository, FavoriteProductRepository favoriteProductRepository1) {
        this.userRepository = userRepository;
        this.productRepository = productRepository;
        this.orderRepository = orderRepository;
        this.addressRepository = addressRepository;
        this.favoriteProductRepository = favoriteProductRepository1;
    }

    @Override
    public void run(String... args) {
        seed();

        System.out.println("Database seeded successfully!");
    }

    private void seed() {
        if (userRepository.count() == 0) {
            User admin = new User("admin@example.com", "123456789", new BigDecimal(10000), Role.ADMIN);
            User user = new User("user@example.com", "987654321", new BigDecimal(500), Role.USER);

            userRepository.saveAll(List.of(admin, user));
            System.out.println("Users seeded.");
        }
        if (productRepository.count() == 0) {
            Product product1 = new Product("Product A", 99.99, 10, "image1.jpg");
            Product product2 = new Product("Product B", 49.99, 20, "image2.jpg");
            productRepository.saveAll(List.of(product1, product2));
            System.out.println("Products seeded.");
        }
        if (addressRepository.count() == 0) {
            User user = userRepository.getUserByEmail("user@example.com").orElse(null);
            if (user != null) {
                Address address = new Address("Via Roma 123", "Roma", "00100", "Italia",Boolean.TRUE, user);
                addressRepository.save(address);
                System.out.println("Addresses seeded.");
            }
        }
        if (orderRepository.count() == 0) {
            User user = userRepository.getUserByEmail("user@example.com").orElse(null);
            Address address = addressRepository.findById(1L).orElse(null);
            Set<Product> productSet = new HashSet<>();
            if (user != null) {
                Order order = new Order(new BigDecimal(149.98), OrderStatus.CANCELLED, "CREDIT_CARD", user,address,productSet);
                Product product1 = productRepository.getProductByName("Product A").orElse(null);
                Product product2 = productRepository.getProductByName("Product B").orElse(null);
                if (order != null && product1 != null && product2 != null) {
                    order.getProductSet().add(product1);
                    order.getProductSet().add(product2);
                    orderRepository.save(order);
                }
                System.out.println("Orders seeded.");
            }



        }
    }
    }

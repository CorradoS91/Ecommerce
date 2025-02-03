package it.corrado.databaseseeder;

import it.corrado.enums.OrderStatus;
import it.corrado.enums.Role;
import it.corrado.model.*;
import it.corrado.repository.*;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Component
@RequiredArgsConstructor

public class DatabaseSeeder {

    private final UserRepository userRepository;
    private final AddressRepository addressRepository;
    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;
    private final FavoriteProductRepository favoriteProductRepository;
    private final UserAddressRepository userAddressRepository;

    @PostConstruct
    public void seedDatabase() {
        if (userRepository.count() == 0) {
            // Creazione degli utenti
            User user1 = new User("mario.rossi@email.com", "1234567890", new BigDecimal("500.00"), Role.ADMIN, new HashSet<>(), new HashSet<>());
            User user2 = new User("luca.bianchi@email.com", "0987654321", new BigDecimal("1000.00"), Role.USER, new HashSet<>(), new HashSet<>());

            userRepository.save(user1);
            userRepository.save(user2);

            // Creazione degli indirizzi
            Address address1 = new Address("Via Roma, 10", "Milano", "20100", "Italia", true, new HashSet<>());
            Address address2 = new Address("Piazza Duomo, 5", "Roma", "00100", "Italia", false, new HashSet<>());

            addressRepository.save(address1);
            addressRepository.save(address2);

            // Associazione utenti e indirizzi
            user1.getAddressesSet().add(address1);
            user2.getAddressesSet().add(address2);

            userRepository.save(user1);
            userRepository.save(user2);

            // Creazione di prodotti
            Product product1 = new Product("Laptop Dell", 899.99, 10, "https://example.com/dell.jpg");
            Product product2 = new Product("Smartphone Samsung", 599.99, 20, "https://example.com/samsung.jpg");

            productRepository.save(product1);
            productRepository.save(product2);

            // Creazione di ordini
            Order order1 = new Order(new BigDecimal("899.99"), OrderStatus.CANCELLED, "Carta di credito", user1, address1, Set.of(product1));
            Order order2 = new Order(new BigDecimal("599.99"), OrderStatus.DELIVERED, "Paypal", user2, address2, Set.of(product2));

            orderRepository.save(order1);
            orderRepository.save(order2);

            // Creazione di prodotti preferiti
            FavoriteProduct favorite1 = new FavoriteProduct(user1, product1);
            FavoriteProduct favorite2 = new FavoriteProduct(user2, product2);

            favoriteProductRepository.save(favorite1);
            favoriteProductRepository.save(favorite2);

            // Creazione della relazione UserAddress
            UserAddress userAddress1 = new UserAddress(null, user1, address1, true);
            UserAddress userAddress2 = new UserAddress(null, user2, address2, false);

            userAddressRepository.save(userAddress1);
            userAddressRepository.save(userAddress2);

            System.out.println("Database seeded successfully!");
        }
    }
}


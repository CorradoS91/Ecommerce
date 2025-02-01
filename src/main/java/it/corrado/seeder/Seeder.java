package it.corrado.seeder;

import it.corrado.model.Address;
import it.corrado.model.Product;
import it.corrado.enums.Role;
import it.corrado.model.User;
import it.corrado.repository.AddressRepository;
import it.corrado.repository.ProductRepository;
import it.corrado.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;

public class Seeder implements CommandLineRunner {
    private final UserRepository userRepository;
    private final ProductRepository productRepository;
    private final AddressRepository addressRepository;

    public Seeder(UserRepository userRepository, ProductRepository productRepository,AddressRepository addressRepository) {
        this.userRepository = userRepository;
        this.productRepository = productRepository;
        this.addressRepository= addressRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        User admin = new User();
        admin.setEmail("admin@example.com");
        admin.setPhone("123456789");
        admin.setBalance(10000);
        admin.setRole(Role.ADMIN);
        userRepository.save(admin);

        Address address = new Address();
        address.setStreet("Via Roma 123");
        address.setCity("Roma");
        address.setPostalCode("00100");
        address.setCountry("Italia");
        address.setUser(admin);
        addressRepository.save(address);

        User user = new User();
        user.setEmail("user@example.com");
        user.setPhone("987654321");
        user.setBalance(500);
        user.setRole(Role.USER);
        userRepository.save(user);

        Address address1 = new Address();
        address1.setStreet("Via Rosvaldo 10");
        address1.setCity("Roma");
        address1.setPostalCode("00100");
        address1.setCountry("Italia");
        address1.setUser(admin);
        addressRepository.save(address1);

        Product product1 = new Product();
        product1.setName("Product A");
        product1.setPrice(99.99);
        product1.setQuantity(10);
        productRepository.save(product1);

        Product product2 = new Product();
        product2.setName("Product B");
        product2.setPrice(49.99);
        product2.setQuantity(20);
        productRepository.save(product2);

        System.out.println("Database seeded with sample data.");
    }
}

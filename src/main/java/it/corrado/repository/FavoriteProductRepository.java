package it.corrado.repository;

import it.corrado.model.FavoriteProduct;
import it.corrado.model.Product;
import it.corrado.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository

public interface FavoriteProductRepository extends JpaRepository<FavoriteProduct, Long> {

    List<FavoriteProduct> findByUser(User user);

    List<FavoriteProduct> findByProduct(Product product);

    boolean existsByUserAndProduct(User user, Product product);

    Optional <FavoriteProduct> findByUserAndProduct(User user, Product product);
}


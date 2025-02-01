package it.corrado.model;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity(name ="FavoriteProduct")
@Table(name="FAVORITE_PRODUCT")
public class FavoriteProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long favoriteProductId;
    @ManyToOne
    @JoinColumn(name = "USER_ID", nullable = false)
    private User user;
    @ManyToOne
    @JoinColumn(name = "ASIN", nullable = false)
    private Product product;

    public FavoriteProduct(User user, Product product) {
        this.user = user;
        this.product = product;
    }
}

package it.corrado.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity(name ="Product")
@Table(name="PRODUCT_ECOMMERCE")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ASIN")
    private long asin;
    @Column(name="NAME")
    private String name;
    @Column(name="PRICE")
    private double price;
    @Column(name="QUANTITY")
    private int quantity;
    @Column(name="IMAGE_URL")
    private String imageUrl;
    @ManyToMany(mappedBy = "productSet")
    private Set<Order> orderSet;
    @OneToMany(mappedBy = "product")
    private Set<FavoriteProduct> favoriteProducts = new HashSet<>();

    public Product(String name, double price, int quantity, String imageUrl) {
        this.name=name;
        this.price=price;
        this.quantity=quantity;
        this.imageUrl=imageUrl;
    }
}

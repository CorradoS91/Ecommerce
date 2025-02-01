package it.corrado.model;

import jakarta.persistence.*;
import lombok.*;

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
    private String quantity;
    @ManyToMany(mappedBy = "productSet")
    private Set<Order> orderSet;

}

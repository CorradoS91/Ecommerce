package it.corrado.model;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity(name ="product")
@Table(name="PRODUCT_ECOMMERCE")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ASIN")
    private long Asin;
    @Column(name="NAME")
    private String name;
    @Column(name="PRICE")
    private double price;
    @Column(name="QUANTITY")
    private String quantity;


}

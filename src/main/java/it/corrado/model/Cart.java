package it.corrado.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity(name ="Cart")
@Table(name="CART")

public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "CART_ID")
    private long cartId;

    @Column(name="CART_TOTAL")
    private BigDecimal cartTotal;

    @ManyToOne
    @JoinColumn(name="USER_ID", nullable = false)
    private User user;

    @ManyToMany
    @JoinTable(
            name="CART_PRODUCT",
            joinColumns =@JoinColumn(name="CART_ID"),
            inverseJoinColumns = @JoinColumn(name="ASIN")
    )
    private Set<Product> productSet;

    @OneToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="ADDRESS_ID",nullable = false)
    private Address address;

}

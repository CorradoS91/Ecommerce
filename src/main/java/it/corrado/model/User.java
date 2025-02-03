package it.corrado.model;

import it.corrado.enums.Role;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity(name="User")
@Table(name="USER_ECOMMERCE")

public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="USER_ID")
    private long id;

    @Column(name="EMAIL",unique = true, nullable=false)
    private String email;

    @Column(name="PHONE")
    private String phone;

    @Column(name="BALANCE")
    private BigDecimal balance;

    @Enumerated(EnumType.STRING)
    @Column(name="ROLE")
    private Role role;

    @OneToMany(mappedBy="user", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Order> orderSet = new HashSet<>();

    @OneToMany(mappedBy = "user")
    private Set<FavoriteProduct> favoriteProductSet=new HashSet<>();

    @ManyToMany
    @JoinTable(
            name = "USER_ADDRESS",
            joinColumns = @JoinColumn(name = "USER_ID"),
            inverseJoinColumns = @JoinColumn(name = "ADDRESS_ID")
    )
    private Set<Address> addressesSet = new HashSet<>();

    @OneToMany(mappedBy = "user")
    private Set<UserAddress> userAddresses = new HashSet<>();

    public User(String email, String phone, BigDecimal balance, Role role, Set<Order> orderSet, Set<Address> addressesSet) {
        this.email = email;
        this.phone = phone;
        this.balance = balance;
        this.role = role;
        this.orderSet=orderSet;
        this.addressesSet=addressesSet;
    }
}

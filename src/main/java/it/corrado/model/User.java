package it.corrado.model;

import jakarta.persistence.*;
import lombok.*;
import java.util.List;
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
    private long balance;
    @Enumerated(EnumType.STRING)
    @Column(name="ROLE")
    private Role role;
    @OneToMany(mappedBy="user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Order> orderList;
    @OneToMany(mappedBy = "user")
    private Set<FavoriteProduct> favoriteProducts;
}

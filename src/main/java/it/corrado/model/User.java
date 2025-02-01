package it.corrado.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
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
    @Column(name="ROLE")
    private String role;
    @OneToMany(mappedBy="user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Order> orderList;
}

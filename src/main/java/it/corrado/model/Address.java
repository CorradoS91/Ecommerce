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
@Entity(name ="Address")
@Table(name="ADDRESS")

public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ADDRESS_ID")
    private long addressId;

    @Column(name = "STREET")
    private String street;

    @Column(name = "CITY")
    private String city;

    @Column(name = "POSTAL_CODE")
    private String postalCode;

    @Column(name = "COUNTRY")
    private String country;

    @OneToOne(mappedBy = "address")
    private Order order;

    @ManyToMany(mappedBy = "addressesSet")
    private Set<User> usersSet = new HashSet<>();

    @OneToMany(mappedBy = "address")
    private Set<UserAddress> userAddresses = new HashSet<>();

    public Address(String street, String city, String postalCode, String country,Boolean isDefault,Set<User> usersSet) {
        this.street=street;
        this.city=city;
        this.postalCode=postalCode;
        this.country=country;
        this.usersSet=usersSet;
    }
}

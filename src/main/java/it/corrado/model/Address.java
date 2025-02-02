package it.corrado.model;

import jakarta.persistence.*;
import lombok.*;

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

    @Column(name="IS_DEFAULT")
    private boolean isDefault;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "USER_ID", nullable = false)
    private User user;

    @OneToOne(mappedBy = "address")
    private Order order;

    public Address(String street, String city, String postalCode, String country,Boolean isDefault , User user) {
        this.street=street;
        this.city=city;
        this.postalCode=postalCode;
        this.country=country;
        this.isDefault=isDefault;
        this.user=user;
    }
}

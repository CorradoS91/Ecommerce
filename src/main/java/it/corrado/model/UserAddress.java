package it.corrado.model;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity(name ="UserAddress")
@Table(name="USER_ADDRESS")

public class UserAddress {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "USER_ID")
    private User user;

    @ManyToOne
    @JoinColumn(name = "ADDRESS_ID")
    private Address address;

    @Column(name="IS_PRIMARY")
    private Boolean isPrimary;

}

package it.corrado.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity(name ="Order")
@Table(name="ECOMMERCE_ORDER")
public class Order {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name="ECOMMERCE_ORDER_ID")
        private long orderId;
        @Column(name="ORDER_TOTAL")
        private BigDecimal orderTotal;
        @Enumerated(EnumType.STRING)
        @Column(name="ORDER_STATUS")
        private OrderStatus orderStatus;
        @Column(name="ORDER_PAYMENT")
        private String orderPayment;
        @Column(name="DONE_AT")
        private LocalDate doneAt;
        @Column(name="RECEIVED_AT")
        private LocalDate receivedAt;
        @ManyToOne
        @JoinColumn(name="USER_ID",nullable=false)
        private User user;
        @ManyToMany
        @JoinTable(
                name="ORDER_PRODUCT",
                joinColumns = @JoinColumn(name="ECOMMERCE_ORDER_ID"),
                inverseJoinColumns = @JoinColumn(name="ASIN")
        )
        private Set<Product> productSet;
}

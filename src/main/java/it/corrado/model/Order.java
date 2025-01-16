package it.corrado.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity(name ="order")
@Table(name="ORDER_ECOMMERCE")
public class Order {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name="ORDER_ID")
        private long orderId;
        @Column(name="ORDER_TOTAL")
        private String orderTotal;
        @Column(name="ORDER_STATUS")
        private String orderStatus;
        @Column(name="ORDER_PAYMENT")
        private String orderPayment;
        @Column(name="DONE_AT")
        private LocalDate doneAt;
        @Column(name="RECEIVED_AT")
        private LocalDate receivedAt;
}

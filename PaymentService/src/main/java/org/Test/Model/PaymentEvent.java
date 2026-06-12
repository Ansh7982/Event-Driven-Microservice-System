package org.Test.Model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaymentEvent {
    private String paymentid;
    private String  orderid;
    private double amount;
    private LocalDateTime created;
    private PaymentStaus staus;

    public PaymentEvent(String paymentid,
                        String orderid,
                        double amount,
                        PaymentStaus status) {
        this.paymentid = paymentid;
        this.orderid = orderid;
        this.amount = amount;
        this.staus = status;
        this.created = LocalDateTime.now();
    }

}

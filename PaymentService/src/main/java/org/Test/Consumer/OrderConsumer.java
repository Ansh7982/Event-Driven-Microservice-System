package org.Test.Consumer;


import org.Test.Model.PaymentEvent;
import org.Test.Model.PaymentStaus;
import org.Test.Producer.PaymentProducer;
import org.springframework.stereotype.Component;

import com.OrderProducer.demo.OdService.Orderdetail;
import java.util.UUID;
import java.util.function.Consumer;
@Component
public class OrderConsumer implements Consumer<Orderdetail> {

    private PaymentProducer paymentProducer;

    public OrderConsumer(PaymentProducer paymentProducer) {
        this.paymentProducer = paymentProducer;
    }

    @Override
    public void accept(Orderdetail orderdetail) {
     boolean success=true;
        PaymentEvent event = new PaymentEvent(
                UUID.randomUUID().toString(),
                orderdetail.getId(),
                orderdetail.getPrice(),
                success? PaymentStaus.SUCCESS:PaymentStaus.FAILED
        );
             paymentProducer.send(event);
    }
}

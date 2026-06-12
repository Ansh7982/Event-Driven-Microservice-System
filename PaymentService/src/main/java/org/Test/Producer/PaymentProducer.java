package org.Test.Producer;

import org.Test.Model.PaymentEvent;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.stereotype.Service;

@Service
public class PaymentProducer {

    private final StreamBridge streamBridge;

    public PaymentProducer(StreamBridge streamBridge) {
        this.streamBridge = streamBridge;
    }
    public  void send(PaymentEvent event){
        streamBridge.send("payments-out-0",event);
    }

}

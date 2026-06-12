package com.OrderProducer.demo.OrderApi;


import com.OrderProducer.demo.OdService.Orderdetail;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class OrApi {
    private final StreamBridge streamBridge;

    public OrApi(StreamBridge streamBridge) {
        this.streamBridge = streamBridge;
    }

    @PostMapping
    public ResponseEntity<String> PlaceOrder(@RequestBody Orderdetail orderdetail){
        streamBridge.send("orderdetail-out-0",orderdetail);
        return  ResponseEntity.ok("Order Sent to Kafka "+orderdetail.getId()
        );
    }


}

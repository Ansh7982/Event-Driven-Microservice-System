package org.Test.Inventory;

import com.OrderProducer.demo.OdService.Orderdetail;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.stereotype.Component;

import java.util.function.Consumer;

@Component
public class InventoryConsumer implements Consumer<Orderdetail> {

    private  final StreamBridge streamBridge;

    public InventoryConsumer(StreamBridge streamBridge) {
        this.streamBridge = streamBridge;
    }


    @Override
    public void accept(Orderdetail orderdetail) {
        System.out.println("Stock is updated "+ orderdetail.getProduct());
        InventoryEvent event= new InventoryEvent(
                orderdetail.getId(),
                orderdetail.getProduct(),
                "STOCK UPDATED"
        );
        streamBridge.send("inventoryConsumer-out-0", event);

    }
}

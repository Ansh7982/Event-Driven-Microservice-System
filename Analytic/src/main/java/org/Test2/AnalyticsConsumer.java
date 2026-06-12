package org.Test2;

import com.OrderProducer.demo.OdService.Orderdetail;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

@Component
public class AnalyticsConsumer implements Consumer<Orderdetail> {

    private final StreamBridge streamBridge;
    private final Map<String, AnalyticsEvent> analyticsMap = new HashMap<>();

    public AnalyticsConsumer(StreamBridge streamBridge) {
        this.streamBridge = streamBridge;
    }

    @Override
    public void accept(Orderdetail orderdetail) {

        String product = orderdetail.getProduct();


        AnalyticsEvent event = analyticsMap.get(product);

        if (event == null) {

            event = new AnalyticsEvent(product, orderdetail.getPrice(), 1);
        } else {
            // Update totals
            event.setTotalSales(event.getTotalSales() + orderdetail.getPrice());
            event.setTotalOrders(event.getTotalOrders() + 1);
        }


        analyticsMap.put(product, event);


        streamBridge.send("analyticsConsumer-out-0", event);

        System.out.println("Analytics Updated: " + event);
    }
}

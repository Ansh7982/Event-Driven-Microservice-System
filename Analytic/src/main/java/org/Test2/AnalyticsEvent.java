package org.Test2;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AnalyticsEvent {
    private String product;
    private  double totalSales;
    private long totalOrders;
}

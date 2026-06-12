package org.Test.Inventory;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class InventoryEvent {
    private String orderid;
    private String product;
    private String status;

    public InventoryEvent(String orderid, String product, String status) {
        this.orderid = orderid;
        this.product = product;
        this.status = status;
    }


}

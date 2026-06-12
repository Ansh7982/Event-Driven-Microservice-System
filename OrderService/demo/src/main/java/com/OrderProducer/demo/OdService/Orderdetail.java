package com.OrderProducer.demo.OdService;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Orderdetail {
    private String id;
    private String uid;
    private String product ;
    private double price;
}

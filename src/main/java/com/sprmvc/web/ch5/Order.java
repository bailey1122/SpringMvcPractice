package com.sprmvc.web.ch5;

import java.io.Serializable;
import java.util.Date;

public class Order implements Serializable {
    private String item;
    private int qty;
    private Date orderDate;

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    @Override
    public String toString() {
        return "Order{" +
                "item='" + item + '\'' +
                ", qty=" + qty +
                ", orderDate=" + orderDate +
                '}';
    }
}
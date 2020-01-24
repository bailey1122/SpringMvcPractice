//package com.sprmvc.web.ch5.services;
//
//import com.sprmvc.web.ch5.Order;
//
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.List;
//
//public class OrderServiceImpl implements OrderService {
//    private List<Order> orders = new ArrayList<>();
//
//    @Override
//    public void placeOrder(String item, int quantity) {
//        Order order = new Order();
//        order.setItem(item);
//        order.setQty(quantity);
//        order.setOrderDate(new Date());
//        System.out.println("placing order: " + order);
//        orders.add(order);
//    }
//
//    @Override
//    public List<Order> getOrderList() {
//        return new ArrayList<>(orders);
//    }
//}
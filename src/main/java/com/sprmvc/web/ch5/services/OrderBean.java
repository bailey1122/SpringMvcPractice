//package com.sprmvc.web.ch5.services;
//
//import com.sprmvc.web.ch5.Order;
//import com.sprmvc.web.ch5.Spitter;
//import com.sprmvc.web.ch5.Spittle;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import java.util.List;
//
//public class OrderBean {
//
////    @Autowired
//    private OrderService orderService;
//
//    @Autowired
//    private SpitterService spitterService;
//
//    public void placeOrder() {
//        System.out.println("-- placing orders --");
//        orderService.placeOrder("ABC Tablet", 2);
//        orderService.placeOrder("XYZ Desktop", 3);
//    }
//
//    public void listOrders() {
//        System.out.println("-- getting order list from service --");
//        List<Order> orderList = orderService.getOrderList();
//        System.out.println(orderList);
//    }
//
//    public void getSpittles() {
//        List<Spittle> orderList = spitterService.getSpittlesForSpitter(new Spitter());
//        System.out.println(orderList);
//    }
//}
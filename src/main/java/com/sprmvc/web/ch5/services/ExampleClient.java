package com.sprmvc.web.ch5.services;

import com.sprmvc.web.ch5.Spitter;
import org.springframework.context.annotation.*;
import org.springframework.remoting.caucho.BurlapProxyFactoryBean;
import org.springframework.remoting.httpinvoker.HttpInvokerProxyFactoryBean;
import org.springframework.remoting.jaxws.JaxWsPortProxyFactoryBean;

import java.net.MalformedURLException;
import java.net.URL;

@Configuration
public class ExampleClient {
//    @Bean
//    public OrderBean orderBean() {
//        return new OrderBean();
//    }

//
//    @Bean
//    public BurlapProxyFactoryBean exporter() {
//        BurlapProxyFactoryBean b = new BurlapProxyFactoryBean();
//        b.setServiceUrl("http://localhost:8080/SpringMvcPractice/OrderService");
//        b.setServiceInterface(OrderService.class);
//        return b;
//    }

//    @Bean
//    public BurlapProxyFactoryBean spitterService() {
//        BurlapProxyFactoryBean proxy = new BurlapProxyFactoryBean();
////        proxy.setServiceUrl("http://localhost:8080/SpringMvcPractice/SpitterService");
//        proxy.setServiceUrl("http://localhost:8080/SpringMvcPractice/spitter.service");
//        proxy.setServiceInterface(SpitterService.class);
//        return proxy;
//    }

    @Bean
    public HttpInvokerProxyFactoryBean spitterService() {
        HttpInvokerProxyFactoryBean proxy = new HttpInvokerProxyFactoryBean();
        proxy.setServiceUrl("http://localhost:8080/SpringMvcPractice/spitter.service");
        proxy.setServiceInterface(SpitterService.class);
        return proxy;
    }


//    @Bean
//    public JaxWsPortProxyFactoryBean spitterService() {
//        JaxWsPortProxyFactoryBean proxy = new JaxWsPortProxyFactoryBean();
//        try {
//            proxy.setWsdlDocumentUrl(new URL("http://localhost:8080/SpringMvcPractice/ws/spitterServiceEndp?wsdl"));
//            proxy.setServiceInterface(SpitterService.class);
//            proxy.setServiceName("spitterServiceEndp");
//            proxy.setPortName("SpitterServiceEndpointPort");
//            proxy.setNamespaceUri("http://spitter.com");
//        } catch (MalformedURLException e) {
//            e.printStackTrace();
//        }
//        return proxy;
//    }

//    public static void main(String[] args) {
//        AnnotationConfigApplicationContext context =
//                new AnnotationConfigApplicationContext(ExampleClient.class);
////        OrderBean bean = context.getBean(OrderBean.class);
////        bean.placeOrder();
////        bean.listOrders();
////        bean.getSpittles();
//
//        SpitterService bean3 = context.getBean(SpitterService.class);
//        System.out.println(bean3.deleteSpittle(11));
////        SpitterServiceEndpoint bean2 = context.getBean(SpitterServiceEndpoint.class);
////        bean2.deleteSpittle(11);
//    }
}
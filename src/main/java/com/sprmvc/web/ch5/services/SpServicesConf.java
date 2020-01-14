//package com.sprmvc.web.ch5.services;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.remoting.caucho.HessianServiceExporter;
//import org.springframework.remoting.rmi.RmiProxyFactoryBean;
//import org.springframework.remoting.rmi.RmiServiceExporter;
//
//@Configuration
//@ComponentScan
//public class SpServicesConf {
//
//    @Bean
//    public SpitterService spitterService() {
//        return new SpitterServiceImpl();
//    }
//
//
////    @Bean
////    @Autowired
////    public RmiServiceExporter rmiExporter(SpitterService spitterService) {
////        RmiServiceExporter rmiExporter = new RmiServiceExporter();
////        rmiExporter.setService(spitterService);
////        rmiExporter.setServiceName("SpitterService");
////        rmiExporter.setServiceInterface(SpitterService.class);
////        return rmiExporter;
////    }
////
////    @Bean
////    public RmiProxyFactoryBean spitterService() {
////        RmiProxyFactoryBean rmiProxy = new RmiProxyFactoryBean();
////        rmiProxy.setServiceUrl("rmi://localhost/SpitterService");
////        rmiProxy.setServiceInterface(SpitterService.class);
////        return rmiProxy;
////    }
//}

//package com.sprmvc.web.ch5.services;
//
//import com.sprmvc.web.ch5.Spitter;
//import com.sprmvc.web.ch5.Spittle;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.stereotype.Component;
//import org.springframework.web.context.support.SpringBeanAutowiringSupport;
//
//import javax.jws.WebMethod;
//import javax.jws.WebService;
//import javax.jws.soap.SOAPBinding;
//import java.util.List;
//
//@WebService(serviceName = "spitterServiceEndp", targetNamespace = "http://spitter.com")
//@SOAPBinding(style = SOAPBinding.Style.DOCUMENT, use = SOAPBinding.Use.LITERAL)
//public class SpitterServiceEndpoint {
////        extends SpringBeanAutowiringSupport {
//
//    private SpitterService spitterService;
//
//    @WebMethod(exclude = true)
//    public void setSpitterService(SpitterService spitterService) {
//        this.spitterService = spitterService;
//    }
//
//    @WebMethod(operationName = "saveSpittle")
//    public String addSpittle(Spittle spittle) {
//        String m = spitterService.saveSpittle(spittle);
//        return m;
//    }
//
//    @WebMethod(operationName = "deleteSpittle")
//    public String deleteSpittle(long spittleId) {
//        String m = spitterService.deleteSpittle(spittleId);
//        System.out.println(m);
//        return m;
//    }
//
//    @WebMethod(operationName = "getRecentSpittles")
//    public List<Spittle> getRecentSpittles(int spittleCount) {
//        return spitterService.getRecentSpittles(spittleCount);
//    }
//
//    @WebMethod(operationName = "getSpittlesForSpitter")
//    public List<Spittle> getSpittlesForSpitter(Spitter spitter) {
//        return spitterService.getSpittlesForSpitter(spitter);
//    }
//}

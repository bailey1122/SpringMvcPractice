package com.sprmvc.web.ch5.services;

import com.sprmvc.web.ch5.Spitter;
import com.sprmvc.web.ch5.Spittle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.List;

@WebService(serviceName = "SpitterService")
public class SpitterServiceEndpoint {
//        extends SpringBeanAutowiringSupport {

    @Autowired
    SpitterService spitterService;

    @WebMethod
    public void addSpittle(Spittle spittle) {
        spitterService.saveSpittle(spittle);
    }

    @WebMethod
    public void deleteSpittle(long spittleId) {
        spitterService.deleteSpittle(spittleId);
    }

    @WebMethod
    public List<Spittle> getRecentSpittles(int spittleCount) {
        return spitterService.getRecentSpittles(spittleCount);
    }

    @WebMethod
    public List<Spittle> getSpittlesForSpitter(Spitter spitter) {
        return spitterService.getSpittlesForSpitter(spitter);
    }
}

package com.sprmvc.web.ch5.services;

import com.sprmvc.web.ch5.Spitter;
import com.sprmvc.web.ch5.Spittle;

import javax.jws.WebService;
import java.util.List;

//@WebService(serviceName = "spitterClient", targetNamespace = "http://spitter.com")
public interface SpitterService {
    List<Spittle> getRecentSpittles(int count);
    String saveSpittle(Spittle spittle);
//    void saveSpitter(Spitter spitter);
//    Spitter getSpitter(long id);
//    void startFollowing(Spitter follower, Spitter followee);
    List<Spittle> getSpittlesForSpitter(Spitter spitter);
//    List<Spittle> getSpittlesForSpitter(String username);
//    Spitter getSpitter(String username);
//    Spittle getSpittleById(long id);
    String deleteSpittle(long id);
//    List<Spitter> getAllSpitters();
}

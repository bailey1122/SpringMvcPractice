package com.sprmvc.web.ch5.services;

import com.sprmvc.web.ch5.Spitter;
import com.sprmvc.web.ch5.Spittle;

import java.util.List;

public interface SpitterService {
    List<Spittle> getRecentSpittles(int count);
    void saveSpittle(Spittle spittle);
    void saveSpitter(Spitter spitter);
    Spitter getSpitter(long id);
    void startFollowing(Spitter follower, Spitter followee);
    List<Spittle> getSpittlesForSpitter(Spitter spitter);
    List<Spittle> getSpittlesForSpitter(String username);
    Spitter getSpitter(String username);
    Spittle getSpittleById(long id);
    void deleteSpittle(long id);
    List<Spitter> getAllSpitters();
}

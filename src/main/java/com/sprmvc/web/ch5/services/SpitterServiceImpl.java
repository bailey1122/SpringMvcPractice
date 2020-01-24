package com.sprmvc.web.ch5.services;

import com.sprmvc.web.ch5.Spitter;
import com.sprmvc.web.ch5.Spittle;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SpitterServiceImpl implements SpitterService {
    @Override
    public List<Spittle> getRecentSpittles(int count) {
        return null;
    }

    @Override
    public String saveSpittle(Spittle spittle) {
        return spittle.getMessage();
    }

//    @Override
//    public void saveSpitter(Spitter spitter) {
//
//    }
//
//    @Override
//    public Spitter getSpitter(long id) {
//        return null;
//    }
//
//    @Override
//    public void startFollowing(Spitter follower, Spitter followee) {
//
//    }

    @Override
    public List<Spittle> getSpittlesForSpitter(Spitter spitter) {
        List<Spittle> spittles = new ArrayList<Spittle>();
        spittles.add(new Spittle("First", new Date()));
        spittles.add(new Spittle("Second", new Date()));
        spittles.add(new Spittle("Third", new Date()));
        return spittles;
    }

//    @Override
//    public List<Spittle> getSpittlesForSpitter(String username) {
//        return null;
//    }
//
//    @Override
//    public Spitter getSpitter(String username) {
//        return new Spitter(username, "no pass", "spitter", "new", "email");
//    }
//
//    @Override
//    public Spittle getSpittleById(long id) {
//        return null;
//    }

    @Override
    public String deleteSpittle(long id) {
        return "Spittle was deleted";
    }

//    @Override
//    public List<Spitter> getAllSpitters() {
//        return null;
//    }

}

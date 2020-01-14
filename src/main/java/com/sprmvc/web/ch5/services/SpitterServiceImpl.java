package com.sprmvc.web.ch5.services;

import com.sprmvc.web.ch5.Spitter;
import com.sprmvc.web.ch5.Spittle;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class SpitterServiceImpl implements SpitterService {
    @Override
    public List<Spittle> getRecentSpittles(int count) {
        return null;
    }

    @Override
    public void saveSpittle(Spittle spittle) {

    }

    @Override
    public void saveSpitter(Spitter spitter) {

    }

    @Override
    public Spitter getSpitter(long id) {
        return null;
    }

    @Override
    public void startFollowing(Spitter follower, Spitter followee) {

    }

    @Override
    public List<Spittle> getSpittlesForSpitter(Spitter spitter) {
        List<Spittle> list = new ArrayList<Spittle>();
        list.add(new Spittle("First", new Date()));
        list.add(new Spittle("Second", new Date()));
        list.add(new Spittle("Third", new Date()));
        return list;
    }

    @Override
    public List<Spittle> getSpittlesForSpitter(String username) {
        return null;
    }

    @Override
    public Spitter getSpitter(String username) {
        return new Spitter("First", "no pass", "spitter", "new", "email");
    }

    @Override
    public Spittle getSpittleById(long id) {
        return null;
    }

    @Override
    public void deleteSpittle(long id) {

    }

    @Override
    public List<Spitter> getAllSpitters() {
        return null;
    }
}

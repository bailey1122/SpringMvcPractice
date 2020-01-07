package com.sprmvc.web.ch5.data;

import com.sprmvc.web.ch5.Spittle;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Repository
public class SpittleRepositoryImpl implements SpittleRepository {

    @Override
    public List<Spittle> findSpittles(long max, int count) {
        List<Spittle> spittles = new ArrayList<Spittle>();
        for (int i = 0; i < count; i++) {
            spittles.add(new Spittle("Spittle " + i, new Date()));
        }
        return spittles;
    }

    @Override
    public Spittle findOne(long spittleid) {
        return new Spittle("Spittle " + spittleid + " is found ", new Date());
    }
}

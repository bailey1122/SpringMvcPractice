package com.sprmvc.web.ch5.data;

import com.sprmvc.web.ch5.Spittle;

import java.util.List;

public interface SpittleRepository {
    List<Spittle> findSpittles(long max, int count);

    Spittle findOne(long spittleid);
}

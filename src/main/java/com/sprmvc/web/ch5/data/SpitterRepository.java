package com.sprmvc.web.ch5.data;

import com.sprmvc.web.ch5.Spitter;

public interface SpitterRepository {
    Spitter save(Spitter spitter);
    Spitter findByUsername(String username);
}

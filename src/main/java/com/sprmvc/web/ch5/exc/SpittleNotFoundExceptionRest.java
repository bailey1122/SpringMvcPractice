package com.sprmvc.web.ch5.exc;

public class SpittleNotFoundExceptionRest extends RuntimeException {
    private long spittleId;
    public SpittleNotFoundExceptionRest(long spittleId) {
        this.spittleId = spittleId;
    }

    public long getSpittleId() {
        return spittleId;
    }
}

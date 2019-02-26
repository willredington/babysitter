package com.willredington.babysitter.model.impl;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.willredington.babysitter.model.AbstractPayRange;

import java.time.LocalDateTime;

public class AfterPayRange extends AbstractPayRange {

    @JsonProperty
    private boolean inclusive;

    @JsonProperty
    private LocalDateTime after;

    public AfterPayRange() {
    }

    public AfterPayRange(int rate, LocalDateTime after) {
        super(rate);
        this.after = after;
    }

    public AfterPayRange(int rate, boolean inclusive, LocalDateTime after) {
        super(rate);
        this.inclusive = inclusive;
        this.after = after;
    }

    public AfterPayRange(LocalDateTime after) {
        this.after = after;
    }

    @Override
    public boolean isActive(LocalDateTime time) {
        return inclusive ? time.isEqual(after) || time.isAfter(after) : time.isAfter(after);
    }

    public LocalDateTime getAfter() {
        return after;
    }

    public void setAfter(LocalDateTime after) {
        this.after = after;
    }

    @Override
    public String toString() {
        return "AfterPayRange{" +
                "after=" + after +
                '}';
    }
}

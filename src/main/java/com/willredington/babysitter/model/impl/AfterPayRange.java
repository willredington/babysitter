package com.willredington.babysitter.model.impl;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.willredington.babysitter.model.AbstractPayRange;

import java.time.LocalDateTime;

public class AfterPayRange extends AbstractPayRange {

    @JsonProperty
    private LocalDateTime after;

    public AfterPayRange() {
    }

    public AfterPayRange(LocalDateTime after) {
        this.after = after;
    }

    @Override
    public boolean isActive(LocalDateTime time) {
        return time.isAfter(after);
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

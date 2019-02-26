package com.willredington.babysitter.model.impl;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.willredington.babysitter.model.AbstractPayRange;

import java.time.LocalDateTime;

/**
 * A pay range for anytime before a specific date/time, can be inclusive
 */
public class BeforePayRange extends AbstractPayRange {

    @JsonProperty
    private boolean inclusive;

    @JsonProperty
    private LocalDateTime before;

    public BeforePayRange() {
    }

    public BeforePayRange(int rate, boolean inclusive, LocalDateTime before) {
        super(rate);
        this.inclusive = inclusive;
        this.before = before;
    }

    public BeforePayRange(int rate, LocalDateTime before) {
        super(rate);
        this.before = before;
    }

    public BeforePayRange(LocalDateTime before) {
        this.before = before;
    }

    @Override
    public boolean isActive(LocalDateTime time) {
        return inclusive ? time.isBefore(before) || time.isEqual(before) : time.isBefore(before);
    }

    public LocalDateTime getBefore() {
        return before;
    }

    public void setBefore(LocalDateTime before) {
        this.before = before;
    }

    @Override
    public String toString() {
        return "BeforePayRange{" +
                "before=" + before +
                '}';
    }
}

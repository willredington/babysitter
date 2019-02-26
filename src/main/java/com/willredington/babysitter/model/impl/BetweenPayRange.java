package com.willredington.babysitter.model.impl;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.willredington.babysitter.model.AbstractPayRange;

import java.time.LocalDateTime;

public class BetweenPayRange extends AbstractPayRange {

    @JsonProperty
    private boolean inclusive;

    @JsonProperty
    private LocalDateTime start;

    @JsonProperty
    private LocalDateTime end;

    public BetweenPayRange() {
    }

    public BetweenPayRange(int rate, boolean inclusive, LocalDateTime start, LocalDateTime end) {
        super(rate);
        this.inclusive = inclusive;
        this.start = start;
        this.end = end;
    }

    public BetweenPayRange(LocalDateTime start, LocalDateTime end) {
        this.start = start;
        this.end = end;
    }

    private boolean isAfter(LocalDateTime time) {
        return inclusive ? time.isAfter(start) || time.isEqual(start) : time.isAfter(start);
    }

    private boolean isBefore(LocalDateTime time) {
        return inclusive ? time.isBefore(end) || time.isEqual(end) : time.isBefore(end);
    }

    @Override
    public boolean isActive(LocalDateTime time) {
        return isAfter(time) && isBefore(time);
    }

    public LocalDateTime getStart() {
        return start;
    }

    public void setStart(LocalDateTime start) {
        this.start = start;
    }

    public LocalDateTime getEnd() {
        return end;
    }

    public void setEnd(LocalDateTime end) {
        this.end = end;
    }

    @Override
    public String toString() {
        return "BetweenPayRange{" +
                "start=" + start +
                ", end=" + end +
                '}';
    }
}

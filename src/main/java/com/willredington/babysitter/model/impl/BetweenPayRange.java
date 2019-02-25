package com.willredington.babysitter.model.impl;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.willredington.babysitter.model.AbstractPayRange;

import java.time.LocalDateTime;

public class BetweenPayRange extends AbstractPayRange {

    @JsonProperty
    private LocalDateTime start;

    @JsonProperty
    private LocalDateTime end;

    public BetweenPayRange() {
    }

    public BetweenPayRange(LocalDateTime start, LocalDateTime end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public boolean isActive(LocalDateTime time) {
        return time.isAfter(start) && time.isBefore(end);
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

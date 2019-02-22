package com.willredington.babysitter.model.impl;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.willredington.babysitter.model.AbstractPayRange;

import java.time.LocalDateTime;

public class BeforePayRange extends AbstractPayRange {

    @JsonProperty
    private LocalDateTime before;

    @Override
    public boolean isActive(LocalDateTime time) {
        return time.isBefore(before) || before.isEqual(time);
    }

    public LocalDateTime getBefore() {
        return before;
    }

    public void setBefore(LocalDateTime before) {
        this.before = before;
    }
}

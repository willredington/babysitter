package com.willredington.babysitter.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.willredington.babysitter.model.impl.AfterPayRange;
import com.willredington.babysitter.model.impl.BeforePayRange;
import com.willredington.babysitter.model.impl.BetweenPayRange;

import java.time.LocalDateTime;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = BeforePayRange.class, name = "before"),
        @JsonSubTypes.Type(value = AfterPayRange.class, name = "after"),
        @JsonSubTypes.Type(value = BetweenPayRange.class, name = "between")
})
public abstract class AbstractPayRange {

    @JsonProperty
    private String name;

    @JsonProperty
    private int rate;

    public AbstractPayRange() {
    }

    public AbstractPayRange(int rate) {
        this.rate = rate;
    }

    public abstract boolean isActive(LocalDateTime time);

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }
}

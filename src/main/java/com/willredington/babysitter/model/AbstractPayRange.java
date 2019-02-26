package com.willredington.babysitter.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.willredington.babysitter.model.impl.AfterPayRange;
import com.willredington.babysitter.model.impl.BeforePayRange;
import com.willredington.babysitter.model.impl.BetweenPayRange;

import java.time.LocalDateTime;

/**
 * Parent class for all the pay ranges
 * Generally wouldn't include business logic in a POJO, but it makes sense for a PayRange to know when it is active
 */
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

    /**
     * Instantiates a new Abstract pay range.
     */
    public AbstractPayRange() {
    }

    /**
     * Instantiates a new Abstract pay range.
     *
     * @param rate the rate
     */
    public AbstractPayRange(int rate) {
        this.rate = rate;
    }

    /**
     * Is active boolean.
     *
     * @param time the time
     * @return the boolean
     */
    public abstract boolean isActive(LocalDateTime time);

    /**
     * Gets name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets name.
     *
     * @param name the name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets rate.
     *
     * @return the rate
     */
    public int getRate() {
        return rate;
    }

    /**
     * Sets rate.
     *
     * @param rate the rate
     */
    public void setRate(int rate) {
        this.rate = rate;
    }
}

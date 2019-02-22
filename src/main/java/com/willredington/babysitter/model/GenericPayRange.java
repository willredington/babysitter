package com.willredington.babysitter.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.willredington.babysitter.constant.PayRangeType;

import java.time.LocalDateTime;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GenericPayRange {

    @JsonProperty
    private int rate;

    @JsonProperty(value = "type")
    private PayRangeType rangeType;

    @JsonProperty(value = "range")
    private List<LocalDateTime> timeRange;

    public GenericPayRange() {
    }

    public GenericPayRange(int rate, PayRangeType rangeType, List<LocalDateTime> timeRange) {
        this.rate = rate;
        this.rangeType = rangeType;
        this.timeRange = timeRange;
    }

    private boolean isActiveBefore(LocalDateTime time) {
        return time.isBefore(timeRange.get(0)) || timeRange.get(0).isEqual(time);
    }

    private boolean isActiveAfter(LocalDateTime time) {
        return isActiveAfter(time, 0);
    }

    private boolean isActiveAfter(LocalDateTime time, int timeRangeIndex) {
        return time.isAfter(timeRange.get(timeRangeIndex)) || timeRange.get(timeRangeIndex).isEqual(time);
    }

    private boolean isActiveBetween(LocalDateTime time) {
        return time.isAfter(timeRange.get(0)) && time.isBefore(timeRange.get(1));
    }

    public boolean isActive(LocalDateTime time) {
        switch (rangeType) {
            case BEFORE:
                return isActiveBefore(time);
            case AFTER:
                return isActiveAfter(time);
            case BETWEEN:
                return isActiveBetween(time);
            default:
                return false;
        }
    }

    public int getRate() {
        return rate;
    }
}

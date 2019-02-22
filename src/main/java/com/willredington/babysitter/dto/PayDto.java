package com.willredington.babysitter.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.willredington.babysitter.model.GenericPayRange;

import java.time.LocalDateTime;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PayDto {

    @JsonProperty
    private LocalDateTime start;

    @JsonProperty
    private LocalDateTime end;

    @JsonProperty(value = "ranges")
    private List<GenericPayRange> payRanges;

    public PayDto() {
    }

    public PayDto(LocalDateTime start, LocalDateTime end, List<GenericPayRange> payRanges) {
        this.start = start;
        this.end = end;
        this.payRanges = payRanges;
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

    public List<GenericPayRange> getPayRanges() {
        return payRanges;
    }

    public void setPayRanges(List<GenericPayRange> payRanges) {
        this.payRanges = payRanges;
    }
}

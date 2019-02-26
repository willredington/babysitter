package com.willredington.babysitter.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.willredington.babysitter.model.AbstractPayRange;

import java.time.LocalDateTime;
import java.util.List;

/**
 * The DTO that holds the start and end dates of a sitter's actively working range, in addition to the pay ranges per family
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class PayDto {

    @JsonProperty
    private LocalDateTime start;

    @JsonProperty
    private LocalDateTime end;

    @JsonProperty(value = "ranges")
    private List<AbstractPayRange> payRanges;

    public PayDto() {
    }

    public PayDto(LocalDateTime start, LocalDateTime end, List<AbstractPayRange> payRanges) {
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

    public List<AbstractPayRange> getPayRanges() {
        return payRanges;
    }

    public void setPayRanges(List<AbstractPayRange> payRanges) {
        this.payRanges = payRanges;
    }
}

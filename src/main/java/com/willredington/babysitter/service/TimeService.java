package com.willredington.babysitter.service;

import com.willredington.babysitter.model.AbstractPayRange;

import java.time.LocalDateTime;
import java.time.temporal.TemporalAmount;
import java.util.List;
import java.util.Set;

/**
 * The interface Time service.
 */
public interface TimeService {

    /**
     * Generate time range for a start and end time based on the amount, almost always 1 hour increments
     *
     * @param start          the start
     * @param end            the end
     * @param temporalAmount the temporal amount
     * @return the list
     */
    List<LocalDateTime> generateTimeRange(LocalDateTime start, LocalDateTime end, TemporalAmount temporalAmount);

    /**
     * Gets time range for pay range based on the amount, almost always 1 hour increments
     *
     * @param start          the start
     * @param end            the end
     * @param payRange       the pay range
     * @param temporalAmount the temporal amount
     * @return the time range for pay range
     */
    Set<LocalDateTime> getTimeRangeForPayRange(LocalDateTime start, LocalDateTime end, AbstractPayRange payRange, TemporalAmount temporalAmount);
}

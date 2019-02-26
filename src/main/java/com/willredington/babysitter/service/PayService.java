package com.willredington.babysitter.service;

import com.willredington.babysitter.model.AbstractPayRange;

import java.time.LocalDateTime;
import java.util.List;

/**
 * The interface Pay service.
 */
public interface PayService {

    /**
     * Calculate for pay ranges int.
     *
     * @param start     the start
     * @param end       the end
     * @param payRanges the pay ranges
     * @return the int
     */
    int calculateForPayRanges(LocalDateTime start, LocalDateTime end, List<AbstractPayRange> payRanges);
}

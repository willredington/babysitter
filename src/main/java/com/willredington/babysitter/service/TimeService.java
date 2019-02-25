package com.willredington.babysitter.service;

import com.willredington.babysitter.model.AbstractPayRange;

import java.time.LocalDateTime;
import java.time.temporal.TemporalAmount;
import java.util.List;
import java.util.Set;

public interface TimeService {

    List<LocalDateTime> generateTimeRange(LocalDateTime start, LocalDateTime end, TemporalAmount temporalAmount);

    Set<LocalDateTime> getTimeRangeForPayRange(LocalDateTime start, LocalDateTime end, AbstractPayRange payRange, TemporalAmount temporalAmount);
}

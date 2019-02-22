package com.willredington.babysitter.service;

import java.time.LocalDateTime;
import java.time.temporal.TemporalAmount;
import java.util.List;

public interface TimeService {

    List<LocalDateTime> generateTimeRange(LocalDateTime start, LocalDateTime end, TemporalAmount temporalAmount);
}

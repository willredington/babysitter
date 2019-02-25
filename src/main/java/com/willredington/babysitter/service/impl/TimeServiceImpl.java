package com.willredington.babysitter.service.impl;

import com.willredington.babysitter.model.AbstractPayRange;
import com.willredington.babysitter.service.TimeService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.temporal.TemporalAmount;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class TimeServiceImpl implements TimeService {

    @Override
    public Set<LocalDateTime> getTimeRangeForPayRange(LocalDateTime start, LocalDateTime end, AbstractPayRange payRange, TemporalAmount temporalAmount) {

        Set<LocalDateTime> range = new HashSet<>();
        LocalDateTime current = start;

        while (current.isBefore(end) || current.isEqual(end)) {
            if(!range.isEmpty() && !payRange.isActive(current)) {
                break;
            }

            range.add(current);
            current = current.plus(temporalAmount);
        }

        return range;
    }

    @Override
    public List<LocalDateTime> generateTimeRange(LocalDateTime start, LocalDateTime end, TemporalAmount temporalAmount) {

        List<LocalDateTime> range = new ArrayList<>();
        LocalDateTime current = start;

        while (current.isBefore(end) || current.isEqual(end)) {
            range.add(current);
            current = current.plus(temporalAmount);
        }

        return range;
    }
}

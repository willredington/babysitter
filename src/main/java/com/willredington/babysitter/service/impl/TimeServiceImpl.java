package com.willredington.babysitter.service.impl;

import com.willredington.babysitter.service.TimeService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.temporal.TemporalAmount;
import java.util.ArrayList;
import java.util.List;

@Service
public class TimeServiceImpl implements TimeService {

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

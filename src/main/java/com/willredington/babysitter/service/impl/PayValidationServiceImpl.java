package com.willredington.babysitter.service.impl;

import com.willredington.babysitter.model.AbstractPayRange;
import com.willredington.babysitter.service.PayValidationService;
import com.willredington.babysitter.service.TimeService;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.temporal.TemporalAmount;
import java.util.List;

@Service
public class PayValidationServiceImpl implements PayValidationService {

    private static final TemporalAmount OFFSET = Duration.ofMinutes(1);

    private final TimeService timeService;

    public PayValidationServiceImpl(TimeService timeService) {
        this.timeService = timeService;
    }

    @Override
    public boolean isValid(LocalDateTime start, LocalDateTime end, List<AbstractPayRange> payRanges) {
        for (LocalDateTime time : timeService.generateTimeRange(start, end, OFFSET)) {
            for (int i = 1; i < payRanges.size(); i++) {
                AbstractPayRange payRange = payRanges.get(i);
                AbstractPayRange prevPayRange = payRanges.get(i - 1);
                if (payRange.isActive(time) && prevPayRange.isActive(time)) {
                    return false;
                }
            }
        }

        return true;
    }
}

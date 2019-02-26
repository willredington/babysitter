package com.willredington.babysitter.service.impl;

import com.willredington.babysitter.model.AbstractPayRange;
import com.willredington.babysitter.service.PayService;
import com.willredington.babysitter.service.TimeService;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class PayServiceImpl implements PayService {

    private final TimeService timeService;

    public PayServiceImpl(TimeService timeService) {
        this.timeService = timeService;
    }

    @Override
    public int calculateForPayRanges(LocalDateTime start, LocalDateTime end, List<AbstractPayRange> payRanges) {

        int sum = 0;

        List<LocalDateTime> timeRange = timeService.generateTimeRange(start, end, Duration.ofHours(1));

        for (LocalDateTime time : timeRange) {
            for (AbstractPayRange payRange : payRanges) {
                if (payRange.isActive(time)) {
                    sum += payRange.getRate();
                }
            }
        }

        return sum;
    }
}

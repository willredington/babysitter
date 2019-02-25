package com.willredington.babysitter.service.impl;

import com.willredington.babysitter.dto.PayDto;
import com.willredington.babysitter.model.AbstractPayRange;
import com.willredington.babysitter.model.impl.AfterPayRange;
import com.willredington.babysitter.model.impl.BeforePayRange;
import com.willredington.babysitter.service.PayValidationService;
import com.willredington.babysitter.service.TimeService;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


public class PayValidationServiceImplTest {

    private static final Logger LOG = LoggerFactory.getLogger(PayValidationServiceImplTest.class);

    private PayDto generateDtoForRanges(List<AbstractPayRange> payRanges) {
        LocalDateTime then = LocalDateTime.now();
        return new PayDto(then.minusHours(5), then, payRanges);
    }

    @Test
    public void shouldNotBeValid() throws IOException {

        LocalDateTime then = LocalDateTime.now();
        List<AbstractPayRange> payRanges = Arrays.asList(
                new BeforePayRange(then),
                new AfterPayRange(then.minusHours(2))
        );

        for (AbstractPayRange payRange : payRanges) {
            LOG.info(payRange.toString());
        }

        PayDto dto = generateDtoForRanges(payRanges);
        TimeService timeService = new TimeServiceImpl();
        PayValidationService validationService = new PayValidationServiceImpl(timeService);
        boolean result = validationService.isValid(dto.getStart(), dto.getEnd(), dto.getPayRanges());
        assertThat(result).isFalse();
    }

    @Test
    public void shouldBeValid() throws IOException {

        LocalDateTime then = LocalDateTime.now();
        List<AbstractPayRange> payRanges = Arrays.asList(
                new BeforePayRange(then.minusHours(2)),
                new AfterPayRange(then.minusHours(1))
        );

        PayDto dto = generateDtoForRanges(payRanges);
        TimeService timeService = new TimeServiceImpl();
        PayValidationService validationService = new PayValidationServiceImpl(timeService);
        boolean result = validationService.isValid(dto.getStart(), dto.getEnd(), dto.getPayRanges());
        assertThat(result).isTrue();
    }
}
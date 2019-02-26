package com.willredington.babysitter.testcase;

import com.willredington.babysitter.model.AbstractPayRange;
import com.willredington.babysitter.model.impl.AfterPayRange;
import com.willredington.babysitter.model.impl.BeforePayRange;
import com.willredington.babysitter.model.impl.BetweenPayRange;
import com.willredington.babysitter.service.PayService;
import com.willredington.babysitter.service.PayValidationService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestCase {

    private static final Logger LOG = LoggerFactory.getLogger(TestCase.class);

    @Autowired
    private PayService payService;

    @Autowired
    private PayValidationService validationService;

    @Test
    public void familyATestCase() {

        LocalDateTime start = LocalDateTime.of(2019, 2, 1, 16, 0);
        LocalDateTime end = LocalDateTime.of(2019, 2, 2, 3, 0);

        LocalDateTime elevenPm = LocalDateTime.of(2019, 2, 1, 22, 0);

        List<AbstractPayRange> payRanges = Arrays.asList(
                new BeforePayRange(15, elevenPm),
                new AfterPayRange(20, true, elevenPm)
        );

        // should be valid
        assertThat(validationService.isValid(start, end, payRanges)).isTrue();

        // should equal expected value
        int result = payService.calculateForPayRanges(start, end, payRanges);
        assertThat(result).isEqualTo(210);

        LOG.info(String.format("Family A pays $15 per hour before 11pm, and $20 per hour the rest of the night; result %d", result));
    }

    @Test
    public void familyBTestCase() {

        LocalDateTime start = LocalDateTime.of(2019, 2, 1, 16, 0);
        LocalDateTime end = LocalDateTime.of(2019, 2, 2, 3, 0);

        LocalDateTime tenPm = LocalDateTime.of(2019, 2, 1, 21, 0);
        LocalDateTime midnight = LocalDateTime.of(2019, 2, 1, 23, 0);

        List<AbstractPayRange> payRanges = Arrays.asList(
                new BeforePayRange(12, tenPm),
                new BetweenPayRange(8, true, tenPm, midnight),
                new AfterPayRange(16, midnight)

        );

        // should be valid
        assertThat(validationService.isValid(start, end, payRanges)).isTrue();

        // should equal expected value
        int result = payService.calculateForPayRanges(start, end, payRanges);
        assertThat(result).isEqualTo(148);

        LOG.info(String.format("Family B pays $12 per hour before 10pm, $8 between 10 and 12, and $16 the rest of the night; result %d", result));
    }

    @Test
    public void familyCTestCase() {

        LocalDateTime start = LocalDateTime.of(2019, 2, 1, 16, 0);
        LocalDateTime end = LocalDateTime.of(2019, 2, 2, 3, 0);

        LocalDateTime ninePm = LocalDateTime.of(2019, 2, 1, 20, 0);

        List<AbstractPayRange> payRanges = Arrays.asList(
                new BeforePayRange(21, ninePm),
                new AfterPayRange(15, ninePm)
        );

        // should be valid
        assertThat(validationService.isValid(start, end, payRanges)).isTrue();

        // should equal expected value
        int result = payService.calculateForPayRanges(start, end, payRanges);
        assertThat(result).isEqualTo(189);

        LOG.info(String.format("Family C pays $21 per hour before 9pm, then $15 the rest of the night; result %d", result));
    }
}

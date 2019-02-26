package com.willredington.babysitter.controller;

import com.willredington.babysitter.dto.PayDto;
import com.willredington.babysitter.exception.InvalidPayRangeException;
import com.willredington.babysitter.model.AbstractPayRange;
import com.willredington.babysitter.model.impl.AfterPayRange;
import com.willredington.babysitter.model.impl.BeforePayRange;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.fail;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MainCtrlTest {

    @Autowired
    private MainCtrl mainCtrl;

    @Test
    public void shouldThrowAnExceptionForBadStartAndEndTimes() {

        LocalDateTime start = LocalDateTime.of(2019, 2, 3, 16, 0);
        LocalDateTime end = LocalDateTime.of(2019, 2, 2, 3, 0);

        try {
            mainCtrl.getTotal(new PayDto(start, end, Collections.emptyList()));
            fail("should've thrown an exception");
        } catch (Exception ex) {
            assertThat(ex)
                    .isNotNull()
                    .isInstanceOf(InvalidPayRangeException.class);
        }
    }

    @Test
    public void shouldThrowAnExceptionForBadRanges() {

        LocalDateTime start = LocalDateTime.of(2019, 2, 1, 16, 0);
        LocalDateTime end = LocalDateTime.of(2019, 2, 2, 3, 0);

        // overlapping ranges
        List<AbstractPayRange> payRanges = Arrays.asList(
                new BeforePayRange(1, end.minusHours(4)),
                new AfterPayRange(1, end.minusHours(5))
        );

        try {
            mainCtrl.getTotal(new PayDto(start, end, payRanges));
            fail("should've thrown an exception");
        } catch (Exception ex) {
            assertThat(ex)
                    .isNotNull()
                    .isInstanceOf(InvalidPayRangeException.class);
        }
    }
}
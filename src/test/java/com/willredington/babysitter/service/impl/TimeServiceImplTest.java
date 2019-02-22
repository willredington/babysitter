package com.willredington.babysitter.service.impl;

import org.junit.Test;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

import static org.junit.Assert.*;

public class TimeServiceImplTest {

    @Test
    public void shouldGenerateTimeRange() {

        LocalDateTime end = LocalDateTime.now();
        LocalDateTime start = end.minusHours(5);

        TimeServiceImpl service = new TimeServiceImpl();
        List<LocalDateTime> range = service.generateTimeRange(start, end, Duration.ofHours(1));

        assertEquals("should contain 6 datetimes", range.size(), 6);
        assertEquals("should equal first range point", range.get(0), start);
        assertEquals("should equal last range point", range.get(range.size() - 1), end);
    }
}
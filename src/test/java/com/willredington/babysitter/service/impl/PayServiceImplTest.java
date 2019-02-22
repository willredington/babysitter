//package com.willredington.babysitter.service.impl;
//
//import com.willredington.babysitter.constant.PayRangeType;
//import com.willredington.babysitter.model.AbstractPayRange;
//import org.junit.Test;
//
//import java.time.LocalDateTime;
//import java.util.Collections;
//import java.util.List;
//
//import static org.junit.Assert.assertEquals;
//
//public class PayServiceImplTest {
//
//    @Test
//    public void shouldCalculatePayForRanges() {
//
//        LocalDateTime end = LocalDateTime.now();
//        LocalDateTime start = end.minusHours(5);
//
//        List<AbstractPayRange> payRanges = Collections.singletonList(
//                new AbstractPayRange(10, PayRangeType.BEFORE, Collections.singletonList(end.minusHours(4)))
//        );
//
//        TimeServiceImpl timeService = new TimeServiceImpl();
//        PayServiceImpl service = new PayServiceImpl(timeService);
//
//        int result = service.calculateForPayRanges(start, end, payRanges);
//        assertEquals("should equal expected pay total", 20, result);
//    }
//}
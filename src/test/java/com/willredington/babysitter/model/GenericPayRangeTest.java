//package com.willredington.babysitter.model;
//
//import com.willredington.babysitter.constant.PayRangeType;
//import org.junit.Test;
//
//import java.time.LocalDateTime;
//import java.util.Arrays;
//import java.util.Collections;
//
//import static org.junit.Assert.*;
//
//public class GenericPayRangeTest {
//
//    @Test
//    public void shouldBeBeforeTime() {
//        LocalDateTime now = LocalDateTime.now();
//        LocalDateTime then = now.minusHours(1);
//        AbstractPayRange payRange = new AbstractPayRange(10, PayRangeType.BEFORE, Collections.singletonList(now));
//        assertTrue(payRange.isActive(then));
//    }
//
//    @Test
//    public void shouldBeAfterTime() {
//        LocalDateTime now = LocalDateTime.now();
//        LocalDateTime then = now.plusHours(1);
//        AbstractPayRange payRange = new AbstractPayRange(10, PayRangeType.AFTER, Collections.singletonList(now));
//        assertTrue(payRange.isActive(then));
//    }
//
//    @Test
//    public void shouldBeBetweenTime() {
//        LocalDateTime now = LocalDateTime.now();
//        AbstractPayRange payRange = new AbstractPayRange(10, PayRangeType.BETWEEN, Arrays.asList(now.minusHours(1), now.plusHours(1)));
//        assertTrue(payRange.isActive(now));
//    }
//}
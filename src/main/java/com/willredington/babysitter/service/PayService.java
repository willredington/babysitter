package com.willredington.babysitter.service;

import com.willredington.babysitter.model.GenericPayRange;

import java.time.LocalDateTime;
import java.util.List;

public interface PayService {

    int calculateForPayRanges(LocalDateTime start, LocalDateTime end, List<GenericPayRange> payRanges);
}

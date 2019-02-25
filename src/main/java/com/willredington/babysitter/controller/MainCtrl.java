package com.willredington.babysitter.controller;

import com.willredington.babysitter.dto.PayDto;
import com.willredington.babysitter.exception.InvalidPayRangeException;
import com.willredington.babysitter.service.PayService;
import com.willredington.babysitter.service.PayValidationService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainCtrl {

    private final PayService payService;
    private final PayValidationService payValidationService;

    public MainCtrl(PayService payService, PayValidationService payValidationService) {
        this.payValidationService = payValidationService;
        this.payService = payService;
    }

    @PostMapping(value = "total")
    public Integer getTotal(@RequestBody PayDto payDto) throws InvalidPayRangeException {

        if (!payValidationService.isValid(payDto.getStart(), payDto.getEnd(), payDto.getPayRanges())) {
            throw new InvalidPayRangeException();
        }

        return payService.calculateForPayRanges(
                payDto.getStart(),
                payDto.getEnd(),
                payDto.getPayRanges()
        );
    }
}

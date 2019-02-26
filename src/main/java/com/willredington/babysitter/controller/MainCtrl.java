package com.willredington.babysitter.controller;

import com.willredington.babysitter.dto.PayDto;
import com.willredington.babysitter.exception.InvalidPayRangeException;
import com.willredington.babysitter.service.PayService;
import com.willredington.babysitter.service.PayValidationService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Main entry point for API requests
 */
@RestController
public class MainCtrl {

    private final PayService payService;
    private final PayValidationService payValidationService;

    public MainCtrl(PayService payService, PayValidationService payValidationService) {
        this.payValidationService = payValidationService;
        this.payService = payService;
    }

    /**
     * Calculates total sum for a babysitter's salary
     *
     * @param payDto the object containing pertinent info for the service to consume
     * @return the total sum
     * @throws InvalidPayRangeException the invalid pay range exception
     */
    @PostMapping(value = "total")
    public Integer getTotal(@RequestBody PayDto payDto) throws InvalidPayRangeException {

        // if its not valid, thrown an exception
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

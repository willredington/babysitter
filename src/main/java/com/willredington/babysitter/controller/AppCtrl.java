package com.willredington.babysitter.controller;

import com.willredington.babysitter.dto.PayDto;
import com.willredington.babysitter.service.PayService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppCtrl {

    private static final Logger LOG = LoggerFactory.getLogger(AppCtrl.class);

    private final PayService payService;

    public AppCtrl(PayService payService) {
        this.payService = payService;
    }

    @PostMapping(value = "total", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Integer getTotal(@RequestBody PayDto dto) {
        return payService.calculateForPayRanges(
                dto.getStart(),
                dto.getEnd(),
                dto.getPayRanges()
        );
    }
}

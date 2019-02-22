package com.willredington.babysitter.controller;

import com.willredington.babysitter.dto.PayDto;
import com.willredington.babysitter.service.PayService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * The app controller endpoint
 */
@RestController
public class AppCtrl {

    private final PayService payService;

    public AppCtrl(PayService payService) {
        this.payService = payService;
    }

    /**
     * Gets total sum of the pay ranges between ranges start and end
     *
     * @param dto the dto
     * @return the total
     */
    @PostMapping(value = "total", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Integer getTotal(@RequestBody PayDto dto) {
        return payService.calculateForPayRanges(
                dto.getStart(),
                dto.getEnd(),
                dto.getPayRanges()
        );
    }
}

package com.willredington.babysitter.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Thrown for an invalid pay range, could be a bad start and end time, or just overlapping ranges
 */
@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "range is invalid")
public class InvalidPayRangeException extends RuntimeException {
}

package com.willredington.babysitter.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "range is invalid")
public class InvalidPayRangeException extends RuntimeException {
}

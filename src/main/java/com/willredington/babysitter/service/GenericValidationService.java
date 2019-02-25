package com.willredington.babysitter.service;

import java.time.LocalDateTime;

public interface GenericValidationService<T> {

    boolean isValid(LocalDateTime start, LocalDateTime end, T t);
}

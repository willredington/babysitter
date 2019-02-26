package com.willredington.babysitter.service;

import java.time.LocalDateTime;

/**
 * Validates the item T is valid for the given time range
 *
 * @param <T> the type parameter
 */
public interface GenericValidationService<T> {

    /**
     * Is valid boolean.
     *
     * @param start the start
     * @param end   the end
     * @param t     the t
     * @return the boolean
     */
    boolean isValid(LocalDateTime start, LocalDateTime end, T t);
}

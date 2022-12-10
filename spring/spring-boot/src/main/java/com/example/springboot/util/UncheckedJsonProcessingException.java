package com.example.springboot.util;

import com.fasterxml.jackson.core.JsonProcessingException;

import java.io.UncheckedIOException;

/**
 * Unchecked version of {@link JsonProcessingException}
 */
public class UncheckedJsonProcessingException extends UncheckedIOException {

    public UncheckedJsonProcessingException(JsonProcessingException cause) {
        super(cause.getMessage(), cause);
    }
}

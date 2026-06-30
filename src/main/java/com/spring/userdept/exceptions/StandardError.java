package com.spring.userdept.exceptions;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Setter
@Getter
public class StandardError {

    private Instant timestamp;
    private Integer status;
    private String error;
    private String message;
    private String path;
    private List<FieldErrorDetails> errors = new ArrayList<>();

    @Getter
    public static class FieldErrorDetails {
        private final String field;
        private final String message;

        public FieldErrorDetails(String field, String message) {
            this.field = field;
            this.message = message;
        }
    }

}

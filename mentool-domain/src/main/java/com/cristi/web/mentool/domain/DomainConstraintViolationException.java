package com.cristi.web.mentool.domain;

public class DomainConstraintViolationException extends RuntimeException {

    public DomainConstraintViolationException(String message) {
        super(message);
    }
}

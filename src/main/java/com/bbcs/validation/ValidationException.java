package com.bbcs.validation;

public class ValidationException extends Throwable {
    public ValidationException(Validator.Error e) {
        super(e.getDetail());
    }
}

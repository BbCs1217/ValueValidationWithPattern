package com.bbcs.validation;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public abstract class AbstractValidatorHandler<T> implements com.bbcs.validation.ValidatorHandler<T> {
    com.bbcs.validation.ValidatorHandler<T> next;
    @Override
    public List<Validator.Error> isValid(T input) {
        if(next == null) {
            var result = new ArrayList<Validator.Error>();
            handleInputValid(input).ifPresent(result::add);
            return result;
        }

        List<Validator.Error> result = next.isValid(input);
        handleInputValid(input).ifPresent(result::add);
        return result;
    }

    @Override
    public com.bbcs.validation.ValidatorHandler<T> getNext() {
        return next;
    }

    protected abstract Optional<Validator.Error> handleInputValid(T input);
}

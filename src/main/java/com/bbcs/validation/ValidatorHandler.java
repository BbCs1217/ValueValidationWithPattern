package com.bbcs.validation;

import java.util.List;

public interface ValidatorHandler<T> {
    List<Validator.Error> isValid(T input);
    com.bbcs.validation.ValidatorHandler<T> getNext();
}

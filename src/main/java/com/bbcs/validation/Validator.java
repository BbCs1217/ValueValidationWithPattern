package com.bbcs.validation;

import java.util.LinkedList;
import java.util.stream.Stream;

public abstract class Validator<T> {
    public interface Error {
        String getDetail();
    }
    private final LinkedList<com.bbcs.validation.ValidatorHandler<T>> handlers = new LinkedList<>();

    protected com.bbcs.validation.Validator<T> addHandler(com.bbcs.validation.ValidatorHandler<T> handler) {
        handlers.addLast(handler);
        return this;
    }

    public Stream<Error> validate(T input) {
        if(handlers.isEmpty())
            return Stream.empty();
         return handlers.getFirst().isValid(input).stream();
    }
}

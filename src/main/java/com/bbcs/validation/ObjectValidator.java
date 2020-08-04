package com.bbcs.validation;

import java.util.Optional;

public class ObjectValidator extends Validator<Object> {
    public enum ObjectError implements Error {Null, Type;

        @Override
        public String getDetail() {
            return name() + " error";
        }
    }
    public com.bbcs.validation.ObjectValidator isNull() {
        return (com.bbcs.validation.ObjectValidator) addHandler(new ObjectNullValidator());
    }

    public com.bbcs.validation.ObjectValidator isTypeOf(Class<?> type) {
        return (com.bbcs.validation.ObjectValidator) addHandler(new ObjectTypeValidator(type));
    }

    public static class ObjectNullValidator extends AbstractValidatorHandler<Object> {
        @Override
        protected Optional<Error> handleInputValid(Object input) {
            return (input == null) ? Optional.of(ObjectError.Null) : Optional.empty();
        }
    }

    public static class ObjectTypeValidator extends AbstractValidatorHandler<Object> {
        private final Class<?> type;

        public ObjectTypeValidator(Class<?> type) {
            this.type = type;
        }

        @Override
        protected Optional<Error> handleInputValid(Object input) {
            return (input.getClass() != type) ? Optional.of(ObjectError.Type) : Optional.empty();
        }
    }
}

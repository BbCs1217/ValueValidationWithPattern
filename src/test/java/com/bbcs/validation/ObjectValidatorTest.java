package com.bbcs.validation;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ObjectValidatorTest {
    @Test
    public void isNullTest() {
        new ObjectValidator()
                .isNull()
                .validate(null)
                .forEach(e -> assertEquals(ObjectValidator.ObjectError.Null, e));
    }

    @Test
    public void typeMismatchTest() {
        new ObjectValidator()
                .isTypeOf(TestClass1.class)
                .validate(new TestClass2())
                .forEach(e -> assertEquals(ObjectValidator.ObjectError.Type, e));
    }

    private static class TestClass1 {
    }

    private static class TestClass2 {
    }
}
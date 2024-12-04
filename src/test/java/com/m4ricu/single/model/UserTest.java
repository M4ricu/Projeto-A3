package com.m4ricu.single.model;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Set;

import org.junit.jupiter.api.Test;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;

class UserTest {

    @Test
    void testUser_validCPF() {
        User user = new User();
        user.setCpf("123.456.789-00"); // CPF válido
        user.setUsername("testuser");
        user.setPassword("password");

        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();

        Set<ConstraintViolation<User>> violations = validator.validate(user);

        assertTrue(violations.isEmpty());

    }

    @Test
    void testUser_invalidCPF() {
        User user = new User();
        user.setCpf("123.21");
        user.setUsername("testuser");
        user.setPassword("password");

        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();

        Set<ConstraintViolation<User>> violations = validator.validate(user);

        assertFalse(violations.isEmpty());

    }

    @Test
    void testUser_nullUsername() {
        User user = new User();
        user.setCpf("123.456.789-00");
        user.setPassword("password");

        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();

        Set<ConstraintViolation<User>> violations = validator.validate(user);

        assertTrue(violations.isEmpty());

    }

    @Test
    void testUser_emptyValues() {
        User user = new User();

        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();

        Set<ConstraintViolation<User>> violations = validator.validate(user);
        assertFalse(violations.isEmpty());

    }
}

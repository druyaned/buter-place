package com.github.druyaned.buters.validation;

import com.github.druyaned.buters.data.UserRepository;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class UsernameValidator implements ConstraintValidator<UsernameConstraint, String> {
    
    private final UserRepository repo;
    
    public UsernameValidator(UserRepository repo) {
        this.repo = repo;
    }

    @Override
    public boolean isValid(String username, ConstraintValidatorContext cvc) {
        return username != null
                && !username.isEmpty()
                && repo.findByUsername(username) == null;
    }

}

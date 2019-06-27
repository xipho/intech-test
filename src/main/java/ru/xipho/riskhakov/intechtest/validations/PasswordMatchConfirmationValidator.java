package ru.xipho.riskhakov.intechtest.validations;

import ru.xipho.riskhakov.intechtest.dto.UserDto;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PasswordMatchConfirmationValidator implements ConstraintValidator<PasswordMatchConfirmation, Object> {

    @Override
    public void initialize(PasswordMatchConfirmation constraintAnnotation) {}

    @Override
    public boolean isValid(Object o, ConstraintValidatorContext constraintValidatorContext) {
        UserDto userDto = (UserDto) o;
        return userDto.getPassword().equals(userDto.getConfirmPassword());
    }
}

package org.itstep.domain.validator;

import org.itstep.domain.dto.CustomUserDto;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class CustomUserDtoValidator implements Validator {
    @Override
    public boolean supports(Class<?> aClass) {
        return CustomUserDto.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        System.out.println("Validate");
        CustomUserDto customUserDto = (CustomUserDto) o;

        if (!customUserDto.getPassword().equals(customUserDto.getConfirmPassword())) {
            errors.rejectValue("confirmPassword", "NotIdentityPasswords");
        }
        ValidationUtils
                .rejectIfEmptyOrWhitespace(errors,"login", "EmptyOrNull");
    }
}

package org.itstep.domain.validator;

import org.itstep.domain.dto.CustomUserDto;
import org.itstep.domain.repository.CustomUserRepository;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CustomUserDtoValidator implements Validator {

    private final CustomUserRepository repository;

    public CustomUserDtoValidator(CustomUserRepository repository) {
        this.repository = repository;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return CustomUserDto.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        System.out.println("Validate");
        CustomUserDto user = (CustomUserDto) o;

        if (loginIsExist(user.getLogin()))
            errors.rejectValue("login", "IsExist");
        if (!matchPattern(user.getLogin(), ".{6,}"))
            errors.rejectValue("login", "BadCharNumber");
        if (!matchPattern(user.getPassword(), ".{6,}"))
            errors.reject("password", "LengthLessMin");
        if (!matchPattern(user.getPassword(), ".{0,20}"))
            errors.rejectValue("password", "LengthGatherMax");
        if (!matchPattern(user.getPassword(), ".*[0-9]+.*"))
            errors.rejectValue("password", "MustBeNumbers");
        if (!matchPattern(user.getPassword(), ".*[a-z]+.*"))
            errors.rejectValue("password", "MustBeLittleLetters");
        if (!matchPattern(user.getPassword(), ".*[A-Z]+.*"))
            errors.rejectValue("password", "MustBeBigLetters");
        if (!matchPattern(user.getPassword(), ".*[#?!@$%^&*-]+.*"))
            errors.rejectValue("password", "MustBeSpecialSymbols");
        if (!user.getPassword().equals(user.getConfirmPassword())) {
            errors.rejectValue("confirmPassword", "NotIdentityPasswords");
        }
        ValidationUtils
                .rejectIfEmptyOrWhitespace(errors,"login", "EmptyOrNull");
    }

    private boolean loginIsExist(String str){
        return repository.findCustomUserByLogin(str) != null;
    }

    private static boolean matchPattern(String str, String pattern) {
        Pattern prn = Pattern.compile(pattern);
        Matcher matcher = prn.matcher(str);
        return matcher.matches();
    }

}

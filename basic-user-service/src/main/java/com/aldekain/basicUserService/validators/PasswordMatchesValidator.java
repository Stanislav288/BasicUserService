package com.aldekain.basicUserService.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.aldekain.basicUserService.annotations.PasswordMatches;
import com.aldekain.basicUserService.models.bindingModels.UserRegister;

public class PasswordMatchesValidator implements ConstraintValidator<PasswordMatches, Object>{

    @Override
    public boolean isValid(Object obj, ConstraintValidatorContext context){
        UserRegister user = (UserRegister) obj;
        return user.getPassword().equals(user.getConfirmPassword());
    }
}

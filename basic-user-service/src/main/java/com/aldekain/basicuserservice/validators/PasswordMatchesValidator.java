package com.aldekain.basicuserservice.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.aldekain.basicuserservice.annotations.PasswordMatches;
import com.aldekain.basicuserservice.models.bindingmodels.UserRegister;



public class PasswordMatchesValidator implements ConstraintValidator<PasswordMatches, Object>{

    @Override
    public boolean isValid(Object obj, ConstraintValidatorContext context){
        UserRegister user = (UserRegister) obj;
        return user.getPassword().equals(user.getConfirmPassword());
    }
}

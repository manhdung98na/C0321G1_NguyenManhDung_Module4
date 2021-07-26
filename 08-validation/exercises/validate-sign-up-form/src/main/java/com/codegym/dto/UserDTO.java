package com.codegym.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Getter
@Setter
@NoArgsConstructor
public class UserDTO implements Validator {
    private Integer id;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private Integer age;
    private String email;

    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        UserDTO userDTO = (UserDTO) target;
        if (userDTO.firstName.trim().length() <5 || userDTO.firstName.trim().length() > 45){
            errors.rejectValue("firstName", "first-name-length-error");
        }
        if (userDTO.lastName.trim().length() <5 || userDTO.lastName.trim().length() > 45){
            errors.rejectValue("lastName", "last-name-length-error");
        }
        String patternPhoneNumber = "^(\\\\+84|0)[0-9]{9}$";
        if (!Pattern.matches(patternPhoneNumber, userDTO.phoneNumber)){
            errors.rejectValue("phoneNumber", "phone-number-error");
        }
        if (userDTO.age < 18){
            errors.rejectValue("age", "age-error");
        }
        String patternEmail = "^[A-Za-z0-9]+[A-Za-z0-9]*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)";
        if (!Pattern.matches(patternEmail, userDTO.email)){
            errors.rejectValue("email", "email-error");
        }
    }
}

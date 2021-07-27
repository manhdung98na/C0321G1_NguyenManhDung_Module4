package com.codegym.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class BookDTO implements Validator {
    private String id;

    private String nameOfBook;
    private Integer quantityOfBook;

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        BookDTO bookDTO = (BookDTO) target;
        if (bookDTO.quantityOfBook < 0) errors.rejectValue("quantity", "quantity-book-error");
    }
}

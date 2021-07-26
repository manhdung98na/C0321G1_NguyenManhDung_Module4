package com.codegym.my_validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = MyValidationImpl.class)
@Target( { ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface MyValidation {
    String message() default "Tên phải viết hoa chữ cái đầu tiên mỗi từ";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}

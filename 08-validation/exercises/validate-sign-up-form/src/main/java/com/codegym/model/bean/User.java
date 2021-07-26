package com.codegym.model.bean;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty
    @Size(min = 5, max = 45, message = "Min length is 5 characters and max length is 45 characters")
    private String firstName;

    @NotEmpty
    @Size(min = 5, max = 45, message = "Min length is 5 characters and max length is 45 characters")
    private String lastName;

    @Pattern(regexp = "^(\\+84|0)[0-9]{9}$", message = "Format: (+84)xxx xxx xxx | 0xxx xxx xxx")
    private String phoneNumber;

    @Min(value = 18, message = "Min age is 18")
    private Integer age;

    @Email
    private String email;

}

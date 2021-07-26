package com.codegym.model.bean;

import com.codegym.my_validation.MyValidation;

import javax.validation.constraints.Min;

public class User {

    @MyValidation
    private String name;

    @Min(18)
    private int age;

    public User() {
    }

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
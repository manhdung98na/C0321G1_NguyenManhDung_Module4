package com.codegym.model.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Book {
    @Id
    private String id;

    private String nameOfBook;
    private Integer quantityOfBook;

}

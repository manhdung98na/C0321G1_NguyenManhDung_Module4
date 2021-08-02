package com.codegym.model.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor

public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String titleBlog;
    private String contentBlog;

    @ManyToOne(targetEntity = Category.class)
    @JoinColumn(name = "category_id", referencedColumnName = "id")
    @JsonManagedReference
    private Category category;


    @Column(name = "create_date", columnDefinition = "DATE")
    private String dateCreate;

    public Blog(String titleBlog, String contentBlog, Category category, String dateCreate) {
        this.titleBlog = titleBlog;
        this.contentBlog = contentBlog;
        this.category = category;
        this.dateCreate = dateCreate;
    }
}

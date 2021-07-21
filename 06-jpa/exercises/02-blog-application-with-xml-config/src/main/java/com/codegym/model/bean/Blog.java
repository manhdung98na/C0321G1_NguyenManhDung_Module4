package com.codegym.model.bean;

import javax.persistence.*;

@Entity(name = "blog")
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String titleBlog;
    private String contentBlog;

    public Blog() {
    }

    public Blog(String titleBlog, String contentBlog) {
        this.titleBlog = titleBlog;
        this.contentBlog = contentBlog;
    }

    public Blog(Integer id, String titleBlog, String contentBlog) {
        this.id = id;
        this.titleBlog = titleBlog;
        this.contentBlog = contentBlog;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitleBlog() {
        return titleBlog;
    }

    public void setTitleBlog(String titleBlog) {
        this.titleBlog = titleBlog;
    }

    public String getContentBlog() {
        return contentBlog;
    }

    public void setContentBlog(String contentBlog) {
        this.contentBlog = contentBlog;
    }
}

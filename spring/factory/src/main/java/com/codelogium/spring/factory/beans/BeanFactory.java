package com.codelogium.spring.factory.beans;

public class BeanFactory {
    private String name;


    public BeanFactory() {
    }

    public BeanFactory(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

}

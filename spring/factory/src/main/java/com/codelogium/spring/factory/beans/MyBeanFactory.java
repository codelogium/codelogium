package com.codelogium.spring.factory.beans;

public class MyBeanFactory {
    
    String name;

    public MyBeanFactory() {
    }

    public MyBeanFactory(String name) {
        this.name = name;
    }

    public static MyBeanFactory createInstance() {
        return new MyBeanFactory(); // return an instance of this bean
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public MyBeanFactory name(String name) {
        setName(name);
        return this;
    }
    
}

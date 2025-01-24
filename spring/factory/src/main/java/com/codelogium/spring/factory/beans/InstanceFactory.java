package com.codelogium.spring.factory.beans;

public class InstanceFactory {
    
    String name;

    public InstanceFactory() {
    }

    public InstanceFactory(String name) {
        this.name = name;
    }

    //Factory method: a method on an existing bean (an instance) that returns an instance of another bean.
    public static InstanceFactory createInstance() {
        return new InstanceFactory(); // return an instance of this bean
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public InstanceFactory name(String name) {
        setName(name);
        return this;
    }
    
}

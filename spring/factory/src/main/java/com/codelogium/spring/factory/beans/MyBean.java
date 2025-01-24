package com.codelogium.spring.factory.beans;

/*
 * The Factory Design Pattern is a creational design pattern used to abstract the instantiation logic of objects. It provides a way to create objects without exposing the creation logic to the client, instead using a common interface or abstract method to instantiate and return objects.
 * 
*/

public class MyBean {
    private String name;


    public MyBean() {
    }

    public MyBean(String name) {
        this.name = name;
    }

    /*
     * Static factory method responsible for creating and initializing a MyBean
     * instance
     * The factory method pattern is used here, allowing centralized control over
     * the creation logic.
     * 
     * A factory method is a method that creates and returns an instance of a bean. Instead of relying on a constructor to instantiate a class, you can use a factory method to control how and when the object is created.
     */
    public static MyBean createInstance() {
        return new MyBean("Created via static Factory method");
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public MyBean name(String name) {
        setName(name);
        return this;
    }

}

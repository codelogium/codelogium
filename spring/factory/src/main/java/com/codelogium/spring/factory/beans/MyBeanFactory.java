package com.codelogium.spring.factory.beans;

import org.springframework.beans.factory.FactoryBean;

/*
 * A FactoryBean is a special Spring-provided interface that allows you to customize how beans are created. It is a factory for creating other beans.
 * 
 * Key Characteristics:
A class that implements FactoryBean<T> is itself a Spring bean, but its primary purpose is to create or manage another bean of type T.
Allows for advanced customization, such as creating a proxy object or dynamically determining the object to be returned.
The getObject() method in the FactoryBean implementation is called by Spring to create the actual bean.
 */
public class MyBeanFactory implements FactoryBean<BeanFactory> {

    @Override
    public BeanFactory getObject() throws Exception {
        BeanFactory beanFactory = new BeanFactory();
        beanFactory.setName("Created by FactoryBean special-spring interface, using its getObject()");
        return beanFactory;
    }

    @Override
    public Class<?> getObjectType() {
        return BeanFactory.class;
    }
    
}

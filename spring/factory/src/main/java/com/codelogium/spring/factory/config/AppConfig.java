package com.codelogium.spring.factory.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.codelogium.spring.factory.beans.MyBean;
import com.codelogium.spring.factory.beans.MyBeanFactory;

@Configuration
// @ComponentScan(basePackages = "com.example.demo") // Scans the specified package
public class AppConfig {

    /**
     * Declares a Spring-managed bean of type MyBean.
     * 
     * - The @Bean annotation tells Spring to invoke this method during application
     * context initialization and register the returned object as a bean.
     * - The method name ('myBean') becomes the default bean name in the Spring context.
     * 
     * This method uses a static factory method (`createInstance`) to create and initialize an instance of MyBean instead of directly invoking the constructor.
     * 
     * The returned MyBean instance is automatically REGISTERED as a Spring bean with the name myBean
     * 
     * Benefits of this approach:
     * 1. Centralized Creation Logic: The factory method encapsulates the creation and initialization logic, allowing you to modify the object creation without changing client code.
     * 2. Flexibility: The factory method can return different objects or pre-configured instances, depending on application requirements.
     * 3. Consistent Initialization: Ensures all beans of this type are initialized in a controlled and consistent way.
     * 
     * Without @Primary: If you have multiple beans of the same type, Spring will not know which one to inject and will throw an exception like NoUniqueBeanDefinitionException, because it finds more than one match. The @Qualifier annotation can help resolve this conflict by explicitly specifying which bean to inject.
     */
    @Bean(name="StaticBean")
    @Primary //Mark static creation as the default and whenever Spring encounter a dependency injection, it will use this one
    public MyBean myBean() {
        return MyBean.createInstance(); // call the static Factory method
    }

    // The Factory class needs to be configured as a bean itself before it can be used
    @Bean
    public MyFactory MyFactory() {
        return new MyFactory();
    }

    //Use the Factory Bean to create MyBeanFactory instance
    @Bean(name = "InstanceFactory")
    public MyBean myInstanceBeanFactory(MyFactory myFactory) {
       return myFactory.createInstance();
    }

    // Using MyBeanFactory which implements FactoryBean specialized interface, it takes care of the bean cration and all.
    @Bean(name="MyBeanFactory")
    public MyBeanFactory myBeanFactory() {
        return new MyBeanFactory();
    }

    public class MyFactory {
        //
        public MyBean createInstance() {
            MyBean mybeanFactory = new MyBean(); // Call the constructor inside the factory
            mybeanFactory.setName("Created using Factory Instance");
            return mybeanFactory;
        }
        
    }
}



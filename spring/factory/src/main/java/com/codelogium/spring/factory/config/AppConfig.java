package com.codelogium.spring.factory.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.codelogium.spring.factory.bean.MyBean;

@Configuration
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
     * The returned MyBean instance is automatically registered as a Spring bean with the name myBean
     * 
     * Benefits of this approach:
     * 1. Centralized Creation Logic: The factory method encapsulates the creation and initialization logic, allowing you to modify the object creation without changing client code.
     * 2. Flexibility: The factory method can return different objects or pre-configured instances, depending on application requirements.
     * 3. Consistent Initialization: Ensures all beans of this type are initialized in a controlled and consistent way.
     */
    
    @Bean
    public MyBean myBean() {
        return MyBean.createInstance(); // call the static Factory method
    }
}

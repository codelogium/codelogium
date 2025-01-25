package com.codelogium.spring.factory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.codelogium.spring.factory.beans.MyBean;
import com.codelogium.spring.factory.beans.MyBeanFactory;
import com.codelogium.spring.factory.beans.BeanFactory;
import com.codelogium.spring.factory.beans.InstanceFactory;
import com.codelogium.spring.factory.config.AppConfig;

@SpringBootApplication
public class FactoryApplication {

	public static void main(String[] args) {

		// Create a Spring application context using the configuration class `AppConfig`
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

		
		// Retrieve a bean of type `MyBean` from the application context
		MyBean bean = context.getBean(MyBean.class);
		InstanceFactory instactionFactory = context.getBean(InstanceFactory.class);
		MyBeanFactory myBeanFactory = context.getBean(MyBeanFactory.class);

		BeanFactory beanFactory = null;
		try {
			beanFactory = myBeanFactory.getObject();
		} catch (Exception e) {
			e.printStackTrace();
		}

		// Print the value of the `name` property of the `MyBean` instance to the console
		System.out.println(bean.getName());
		System.out.println(instactionFactory.getName());
		System.out.println(beanFactory.getName());
		System.out.println("The bean used in the FactoryBean interface is : " + myBeanFactory.getObjectType().getSimpleName());

        // Close the application context to release resources and clean up		context.close();

		SpringApplication.run(FactoryApplication.class, args);
	}

}

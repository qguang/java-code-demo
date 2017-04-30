package com.guang.first_mvn_spring;


import org.apache.commons.logging.LogFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.guang.first_mvn_spring.services.HelloWorldService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Hello {
 
	private static final Logger logger = LoggerFactory.getLogger(Hello.class);
	 
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		
		//logger.info("Guang's first maven and spring project test with slf4j with logback");
		// loading the definitions from the given XML file
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		logger.info("------------------------------------------------------");
		HelloWorldService service = (HelloWorldService) context.getBean("helloWorldService");
		String message = service.sayHello();
		logger.info(message);
 
		//set a new name
		service.setName("Spring");
		message = service.sayHello();
		logger.info(message);
		
		HelloWorldService newService = (HelloWorldService) context.getBean("helloWorldService");
		message = newService.sayHello();
		logger.info(message);
		logger.info("I am seeing 2 same message above is due to the bean scope is singleton");
		logger.info("------------------------------------------------------");
		
		logger.info("-------------------  start testing inheritance -------------------------");
		HelloWorld objA = (HelloWorld) context.getBean("helloWorld");
	    objA.getMessage1();
	    objA.getMessage2();

	    HelloIndia objB = (HelloIndia) context.getBean("helloIndia");
	    objB.getMessage1();
	    objB.getMessage2();
	    objB.getMessage3();
		
		context.registerShutdownHook();
		
	}
}
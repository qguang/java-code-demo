package com.guang.first_mvn_spring;


import org.apache.commons.logging.LogFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.guang.first_mvn_spring.services.HelloWorldService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Hello {
 
	private static final Logger logger = LoggerFactory.getLogger(Hello.class);
	 
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		
		logger.info("Guang's first maven and spring project test with slf4j with logback");
		// loading the definitions from the given XML file
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
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
	}
}
package com.guang.first_mvn_spring.services;

import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.BeansException;

public class InitHelloWorld implements BeanPostProcessor {
   public Object postProcessBeforeInitialization(Object bean, String beanName) 
      throws BeansException {
	   HelloWorldService temp = new HelloWorldService();
	   
	   if ( beanName.equals( new String("helloWorldService") )) {
		   temp = (HelloWorldService) bean;
	
		   System.out.println("---------------------------------------------------");
		   System.out.println("BeforeInitialization - beanName  : " + beanName);
		   // at this stage, the value is already set
		   System.out.println("BeforeInitialization - get value : " + temp.getName());
		   System.out.println("---------------------------------------------------");
	   }else
	   {
		   System.out.println("---------------------------------------------------");
		   System.out.println("BeforeInitialization : " + beanName);
		   System.out.println("---------------------------------------------------");
	   }
      return bean;  // you can return any other object as well
   }
   public Object postProcessAfterInitialization(Object bean, String beanName) 
      throws BeansException {
	  System.out.println("---------------------------------------------------");
      System.out.println("AfterInitialization - beanName : " + beanName);
      System.out.println("---------------------------------------------------");
      return bean;  // you can return any other object as well
   }
}
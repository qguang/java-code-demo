
package com.guang.first_mvn_spring.services;
import org.springframework.stereotype.Service;
 
@Service("helloWorldService")
public class HelloWorldService {
 
	private String name;
 
	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}
 
	public String sayHello() {
		return "Hello! " + name;
	}

	public void init(){
		System.out.println("---------------------------------------------------");
		System.out.println("init: Bean is going through init.");
		System.out.println("init: the value of name is: " + this.name);
		System.out.println("---------------------------------------------------");
	}
	public void destroy() {
		System.out.println("---------------------------------------------------");
		System.out.println("destroy: Bean will destroy now.");
		System.out.println("---------------------------------------------------");
	}
}


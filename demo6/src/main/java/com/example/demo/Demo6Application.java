package com.example.demo;

import org.springframework.beans.factory.config.Scope;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Demo6Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = new AnnotationConfigApplicationContext();
		Scope scope = new CustomThreadScope();
		context.getBeanFactory().registerScope("Threadscope" ,scope);
	}

}

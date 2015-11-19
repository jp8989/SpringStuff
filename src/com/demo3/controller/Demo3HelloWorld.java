package com.demo3.controller;
 
import org.springframework.stereotype.Controller;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
 
/*
 * author: Crunchify.com
 * 
 */
 
@Controller
public class Demo3HelloWorld {
 
	@RequestMapping("/welcome")
	public ModelAndView helloWorld() {
		
		runBean();
		
		String message = "<br><div style='text-align:center;'>"
				//+ "<h3>********** Hello World1, Spring MVC Tutorial</h3>This message is coming from CrunchifyHelloWorld.java **********</div><br><br>";
				+ "<h3>AOPService: " + runBean() + "</div><br><br>";
		
		return new ModelAndView("welcome", "message", message);
	}
	
	@ProfileExecution
	public String runBean() {
	
		ApplicationContext appContext = new ClassPathXmlApplicationContext(
			new String[] { "Spring-beans.xml" });

		AOPService cust = (AOPService) appContext.getBean("aopServiceProxy");
		cust.foo();


		return cust.getAop();

	}
}
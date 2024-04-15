package com.shankar.lc.config;



import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

/*Setting Dispatcher Servlet Approach I*/
public class LoveCalculatorApplicationInitializer //implements WebApplicationInitializer
{

	//@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		
		/* XML Configuration */
//		XmlWebApplicationContext webApplicationContext = new XmlWebApplicationContext();
//		webApplicationContext.setConfigLocation("classpath:application-context.xml");
		
		/* Java or Annotation Configuration */
		AnnotationConfigWebApplicationContext webApplicationContext = new AnnotationConfigWebApplicationContext();
		webApplicationContext.register(LoveCalculatorAppConfig.class);
		
		DispatcherServlet dispatcherServlet = new DispatcherServlet(webApplicationContext);
		
		
		ServletRegistration.Dynamic myCustomServletRegistration = servletContext.addServlet("myDispatcherServlet", dispatcherServlet);
		myCustomServletRegistration.setLoadOnStartup(1);
		myCustomServletRegistration.addMapping("/");
		
		
	}

}


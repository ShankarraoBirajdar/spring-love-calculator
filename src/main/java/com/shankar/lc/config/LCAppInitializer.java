package com.shankar.lc.config;

import java.util.logging.Logger;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;



/*Setting Dispatcher Servlet Approach II*/
public class LCAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	private final Logger logger = Logger.getLogger(this.getClass().getName());
	@Override
	protected Class<?>[] getRootConfigClasses() {
		logger.info("Inside LCAppInitializer->getRootConfigClasses()");
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		logger.info("Inside LCAppInitializer->getServletConfigClasses()");
		Class<?> arr[] = {LoveCalculatorAppConfig.class};
		return arr;
	}

	@Override
	protected String[] getServletMappings() {
		logger.info("Inside LCAppInitializer->getServletMappings()");
		String arr[] = {"/"};
		return arr;
	}

}

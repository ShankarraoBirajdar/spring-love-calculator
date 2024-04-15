package com.shankar.lc.ExceptionHandler;

import java.util.logging.Logger;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpClientErrorException.NotFound;
import org.springframework.web.client.HttpServerErrorException.InternalServerError;

@ControllerAdvice
public class GobalExceptionHandler {
	
	private final Logger logger = Logger.getLogger(this.getClass().getName());
	
	@ExceptionHandler(value = InternalServerError.class)
	public String handleInternalServerError() {
		logger.info("Inside GobalExceptionHandler->handleInternalServerError()");
		return "500-Error";
	}

	@ExceptionHandler(value = NotFound.class)
	public String handlePageNotFound() {
		logger.info("Inside GobalExceptionHandler->handlePageNotFound()");
		return "404-Error";
	}
	
	@ExceptionHandler(value = NullPointerException.class)
	public String handleNullPointerException() {
		logger.info("Inside GobalExceptionHandler->handleNullPointerException()");
		return "NullPointerException";
	}
	
	@ExceptionHandler(value = Exception.class)
	public String handleException() {
		logger.info("Inside GobalExceptionHandler->handleException()");
		return "Exception";
	}
}

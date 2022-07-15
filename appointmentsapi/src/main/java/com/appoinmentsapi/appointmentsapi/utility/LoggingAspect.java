package com.appoinmentsapi.appointmentsapi.utility;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {
	
	public static final Log LOGGER = LogFactory.getLog(LoggingAspect.class);
	
	@Autowired
	Environment env;
	
	@AfterThrowing(pointcut = "execution(* com.appoinmentsapi.appointmentsapi.service.*Impl.*(..))", throwing = "exception")
	public void logServiceException(Exception exception) {
		//Below code can be un-commented to print the stack trace of the exception
		//LOGGER.error(env.getProperty(exception.getMessage()), exception);
		
		//With this, only the configured message is displayed
		LOGGER.error(env.getProperty(exception.getMessage()));
	}
	
}

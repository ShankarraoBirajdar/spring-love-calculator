package com.shankar.lc.config;

import java.util.Properties;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.core.env.Environment;
import org.springframework.format.FormatterRegistry;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.validation.Validator;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.shankar.lc.converter.CreditCardConverter;
import com.shankar.lc.converter.CreditCardConverterObjectToString;
import com.shankar.lc.formatter.CreditCardFormatter;
import com.shankar.lc.formatter.PhoneNumberFormatter;

@EnableWebMvc
@Configuration
@PropertySources({ @PropertySource("classpath:email.properties"), @PropertySource("classpath:validator.properties") })
@ComponentScan(basePackages = "com.shankar.lc")
public class LoveCalculatorAppConfig implements WebMvcConfigurer {
	private final Logger logger = Logger.getLogger(this.getClass().getName());
	@Autowired
	private Environment env;

	@Bean
	public InternalResourceViewResolver configViewResolver() {
		logger.info("Inside LoveCalculatorAppConfig->configViewResolver()");
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();

		viewResolver.setPrefix("/WEB-INF/view/");
		viewResolver.setSuffix(".jsp");

		return viewResolver;
	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		logger.info("Inside LoveCalculatorAppConfig->addResourceHandlers()");
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
	}

	@Override
	public void addFormatters(FormatterRegistry registry) {
		logger.info("Inside LoveCalculatorAppConfig->addFormatters()");
		registry.addFormatter(new PhoneNumberFormatter());
//		registry.addFormatter(new CreditCardFormatter()); //added into @InitBinder
		
//		registry.addConverter(new CreditCardConverter());
//		registry.addConverter(new CreditCardConverterObjectToString());
	}

	@Bean
	public MessageSource messageSource() {
		logger.info("Inside LoveCalculatorAppConfig->messageSource()");
		ResourceBundleMessageSource source = new ResourceBundleMessageSource();
		source.setBasename("validator");
		return source;
	}

	@Bean
	public LocalValidatorFactoryBean validator() {
		logger.info("Inside LoveCalculatorAppConfig->validator()");
		LocalValidatorFactoryBean factoryBean = new LocalValidatorFactoryBean();
		factoryBean.setValidationMessageSource(messageSource());
		return factoryBean;
	}

	@Override
	public Validator getValidator() {
		logger.info("Inside LoveCalculatorAppConfig->getValidator()");
		return validator();
	}

	@Bean
	public JavaMailSender getJavaMailSender() {
		logger.info("Inside LoveCalculatorAppConfig->getJavaMailSender()");
		
		JavaMailSenderImpl javaMailSenderImpl = new JavaMailSenderImpl();
		javaMailSenderImpl.setHost(env.getProperty("mail.host"));
		javaMailSenderImpl.setUsername(env.getProperty("mail.username"));
		javaMailSenderImpl.setPassword(env.getProperty("mail.password"));
		javaMailSenderImpl.setPort(getIntProperty("mail.port"));
		
		javaMailSenderImpl.setJavaMailProperties(getMailProperties());

		return javaMailSenderImpl;
	}

	public int getIntProperty(String key) {
		logger.info("Inside LoveCalculatorAppConfig->getIntProperty()");
		return Integer.valueOf(env.getProperty(key));
	}
	
	private Properties getMailProperties() {
		Properties mailProperties = new Properties();
		mailProperties.put("mail.smtp.auth", true);
		mailProperties.put("mail.smtp.starttls.enable", true);
		mailProperties.put("mail.smtp.ssl.trust", "smtp.gmail.com");
		return mailProperties;
	}
}

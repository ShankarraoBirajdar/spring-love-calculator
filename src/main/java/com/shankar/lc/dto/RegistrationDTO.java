package com.shankar.lc.dto;

import java.util.Arrays;
import java.util.logging.Logger;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.shankar.lc.Annotation.Age;

public class RegistrationDTO {
	
	private final Logger logger = Logger.getLogger(this.getClass().getName());
	
	@NotEmpty(message = "{string.notEmpty}")
	private String name;
	
	@Size(min = 3, max = 15, message = "{username.size}")
	private String username;
	private char[] password;
	private String country;
	private String[] hoobies;
	private String gender;
	@Age(lower=30, upper=70)
	private Integer age;
	private Communication communication;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		logger.info("Inside Registration->setName()");
		this.name = name;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		logger.info("Inside Registration->setUsername()");
		this.username = username;
	}
	public char[] getPassword() {
		return password;
	}
	public void setPassword(char[] password) {
		logger.info("Inside Registration->setPassword()");
		this.password = password;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		logger.info("Inside Registration->setCountry()");
		this.country = country;
	}
	public String[] getHoobies() {
		return hoobies;
	}
	public void setHoobies(String[] hoobies) {
		logger.info("Inside Registration->setHoobies()");
		this.hoobies = hoobies;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		logger.info("Inside Registration->setGender()");
		this.gender = gender;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		logger.info("Inside Registration->setAge()");
		this.age = age;
	}
	public Communication getCommunication() {
		return communication;
	}
	public void setCommunication(Communication communication) {
		logger.info("Inside Registration->setCommunication()");
		this.communication = communication;
	}
	
	@Override
	public String toString() {
		return "Registration [name=" + name + ", username=" + username + ", password=" + Arrays.toString(password)
				+ ", country=" + country + ", hoobies=" + Arrays.toString(hoobies) + ", gender=" + gender + ", age="
				+ age + ", communication=" + communication + "]";
	}

}

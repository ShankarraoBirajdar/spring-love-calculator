package com.shankar.lc.dto;

import java.util.logging.Logger;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;



/*dto - data transfer object*/

public class UserInfoDTO {
	private final Logger logger = Logger.getLogger(this.getClass().getName());
//	@Min(message = "* Your Name should have at least 3 char", value = 3)
	@NotBlank(message = "* User Name can't be blank")
	@Size(message = "* Your Name should have char between 3-15", min =  3, max = 15 )
	private String userName;
	
	@NotBlank(message = "* Crush Name can't be blank")
	@Size(message = "* Crush Name should have char between 3-15", min =  3, max = 15 )
	private String crushName;
	
	@AssertTrue(message = "Please select the checkbox to agree our terms and conditions")
	private Boolean termsAndCondition;
	
	private String result;
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		logger.info("Inside UserInfo->setUserName()");
		this.userName = userName;
	}
	public String getCrushName() {
		return crushName;
	}
	public void setCrushName(String crushName) {
		logger.info("Inside UserInfo->setCrushName()");
		this.crushName = crushName;
	}
	public Boolean getTermsAndCondition() {
		return termsAndCondition;
	}
	public void setTermsAndCondition(Boolean termsAndCondition) {
		logger.info("Inside UserInfo->setTermsAndCondition()");
		this.termsAndCondition = termsAndCondition;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		logger.info("Inside UserInfo->setResult()");
		this.result = result;
	}
	
	@Override
	public String toString() {
		return "UserInfo [userName=" + userName + ", crushName=" + crushName + ", termsAndCondition="
				+ termsAndCondition + ", result=" + result + "]";
	}
}

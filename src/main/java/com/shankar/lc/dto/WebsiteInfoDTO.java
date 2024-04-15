package com.shankar.lc.dto;

import java.util.logging.Logger;

public class WebsiteInfoDTO {

	private String websiteName;
	private String websiteCategory;
	
	private final Logger logger = Logger.getLogger(this.getClass().getName());
	
	public WebsiteInfoDTO() {
		logger.info("Inside WebsiteInfoDTO->WebsiteInfoDTO()");
		logger.info(">>>> WebsiteInfoDTO Object Created");
	}
	public String getWebsiteName() {
		return websiteName;
	}
	public void setWebsiteName(String websiteName) {
		this.websiteName = websiteName;
	}
	public String getWebsiteCategory() {
		return websiteCategory;
	}
	public void setWebsiteCategory(String websiteCategory) {
		this.websiteCategory = websiteCategory;
	}
	@Override
	public String toString() {
		return "WebsiteInfoDTO [websiteName=" + websiteName + ", websiteCategory=" + websiteCategory + "]";
	}
	
}

package com.shankar.lc.controllers;



import java.util.logging.Logger;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.shankar.lc.dto.WebsiteInfoDTO;

@Controller
public class TestController {

	private final Logger logger = Logger.getLogger(this.getClass().getName());
	@RequestMapping("/test")
	public String test() {
		logger.info("Inside TestController->test()");
		return "HelloWorld";
	}
	
	@RequestMapping("/testModel")
	public String testModelAttribute(@ModelAttribute("websiteInfo") WebsiteInfoDTO websiteInfoDTO) {
		logger.info("Inside TestController->testModelAttribute()");
		
		logger.info(websiteInfoDTO.getWebsiteName());
		logger.info(websiteInfoDTO.getWebsiteCategory());
		
		return "index";
	}
}

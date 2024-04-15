package com.shankar.lc.controllers;

import java.util.logging.Logger;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.shankar.lc.dto.WebsiteInfoDTO;

@Controller
@SessionAttributes("websiteInfo")
public class MyWebsiteController {

	private final Logger logger = Logger.getLogger(this.getClass().getName());

	 @ModelAttribute("websiteInfo")
	public WebsiteInfoDTO getWebsiteInfoDTO() {
		logger.info("Inside MyWebsiteController->getWebsiteInfoDTO()");
		WebsiteInfoDTO websiteInfoDTO = new WebsiteInfoDTO();
		websiteInfoDTO.setWebsiteCategory("Google.com");
		websiteInfoDTO.setWebsiteName("Education");
		return websiteInfoDTO;
	}

//	@RequestMapping("/showInfo")
//	public String showWebsiteInfo(Model model) {
//		logger.info("Inside MyWebsiteController->showWebsiteInfo()");
//
//		WebsiteInfoDTO websiteInfoDTO = (WebsiteInfoDTO) model.getAttribute("websiteInfo");
//		model.addAttribute("websiteInfo", websiteInfoDTO);
//
//		logger.info(websiteInfoDTO.getWebsiteName());
//		logger.info(websiteInfoDTO.getWebsiteCategory());
//
//		return "index";
//	}
	
	@RequestMapping("/showInfo")
	public String showWebsiteInfo(@ModelAttribute("websiteInfo") WebsiteInfoDTO websiteInfoDTO) {
		logger.info("Inside MyWebsiteController->showWebsiteInfo()");
		
		websiteInfoDTO.setWebsiteCategory("Yahoo.com");
		websiteInfoDTO.setWebsiteName("Search");
		
		logger.info(websiteInfoDTO.getWebsiteName());
		logger.info(websiteInfoDTO.getWebsiteCategory());
		
		return "index";
	}

	@RequestMapping("/showCompanyInfo")
	public String showWebsiteCompanyInfo(@ModelAttribute("websiteInfo") WebsiteInfoDTO websiteInfoDTO) {
		logger.info("Inside MyWebsiteController->showWebsiteCompanyInfo()");

		logger.info(websiteInfoDTO.getWebsiteName());
		logger.info(websiteInfoDTO.getWebsiteCategory());

		return "index";
	}

}

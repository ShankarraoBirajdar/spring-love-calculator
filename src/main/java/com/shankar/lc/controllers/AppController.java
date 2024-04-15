package com.shankar.lc.controllers;


import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.shankar.lc.PropertyEditor.NamePropertyEditor;
import com.shankar.lc.dto.UserInfoDTO;
import com.shankar.lc.service.LCAppServiceImpl;

import javax.validation.Valid;



@Controller
@SessionAttributes("userInfoDTO")
public class AppController {
	private final Logger logger = Logger.getLogger(this.getClass().getName());
	@Autowired
	private LCAppServiceImpl LCAppService;
	@RequestMapping("/")
	public String showHomePage(Model model) {
		logger.info("Inside AppController->showHomePage()");
		model.addAttribute("userInfoDTO", new UserInfoDTO());
		return "Home-Page";
	}
	
	/* Approach 1 */
//	@RequestMapping("/processCalculate")
//	public String processCalculate(@RequestParam("userName") String username, @RequestParam("crushName") String crushname, Model model) {
//		System.out.println(username);
//		System.out.println(crushname);
//		
//		model.addAttribute("userName", username);
//		model.addAttribute("crushName", crushname);
//		
//		return "Result-Page";
//	}
	
	/* Approach 2a - if you have multiple parameter like form filing*/
//	@RequestMapping("/processCalculate")
//	public String processCalculate(UserInfo userInfo, Model model) {
//		System.out.println(userInfo.getUserName());
//		System.out.println(userInfo.getCrushName());
//		
//		model.addAttribute("userInfo", userInfo);
//		
//		return "Result-Page";
//	}
	
	/* Approach 2b - if you have multiple parameter like form filing*/
	@RequestMapping("/processCalculate")
	public String processCalculate(Model model,@Valid UserInfoDTO userInfoDTO, BindingResult result) {	
		logger.info("Inside AppController->processCalculate()");
		model.addAttribute("userInfoDTO", userInfoDTO);
		
		if (result.hasErrors()) {
			logger.info("my form has errors..");
			return "Home-Page";
		}
		
	   String appResult	= LCAppService.calculateLove(userInfoDTO.getUserName(), userInfoDTO.getCrushName());
	   userInfoDTO.setResult(appResult);
	   
		
		return "Result-Page";
	}
}

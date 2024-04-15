package com.shankar.lc.controllers;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.shankar.lc.dto.EmailDTO;
import com.shankar.lc.dto.UserInfoDTO;
import com.shankar.lc.service.LCAppEmailServiceImpl;

@Controller
public class EmailController {
	@Autowired
	private LCAppEmailServiceImpl lcAppEmailService;
	private final Logger logger = Logger.getLogger(this.getClass().getName());

	@RequestMapping("/sendEmail")
	public String sendEmail(@ModelAttribute("emailDTO") EmailDTO emailDTO) {
		logger.info("Inside EmailController->sendEmail()");
		return "send-email-page";
	}

	@RequestMapping("/process-email")
	public String processEmail(@SessionAttribute("userInfoDTO") UserInfoDTO userInfoDTO, @ModelAttribute("emailDTO") EmailDTO emailDTO) {
		logger.info("Inside EmailController->processEmail()");
		//Calling the sendMail() 
		lcAppEmailService.sendMail(userInfoDTO.getUserName(), emailDTO.getUserEmail(),userInfoDTO.getResult());
		return "process-email-page";
	}
}

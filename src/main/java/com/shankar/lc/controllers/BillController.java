package com.shankar.lc.controllers;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Currency;
import java.util.Date;
import java.util.logging.Logger;

import javax.validation.Valid;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.beans.propertyeditors.CustomNumberEditor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.shankar.lc.PropertyEditor.CreditCardEditor;
import com.shankar.lc.PropertyEditor.MyCurrencyEditor;
import com.shankar.lc.dto.BillDTO;
import com.shankar.lc.dto.CreditCard;
import com.shankar.lc.formatter.CreditCardFormatter;

@Controller
@RequestMapping("/creditCard")
public class BillController {
	private final Logger logger = Logger.getLogger(this.getClass().getName());
	
	@RequestMapping("/bill")
	public String showHomePage(@ModelAttribute BillDTO billDTO) {
		
		logger.info("Inside BillController->showHomePage()");
		
		CreditCard creditCard = new CreditCard();
		creditCard.setFirstFourDigit(1234);
		creditCard.setSecondFourDigit(1111);
		creditCard.setThirdFourDigit(2222);
		creditCard.setLastFourDigit(5678);
		
		billDTO.setCreditCard(creditCard);
		
		return "Bill-Page";
	}

	@RequestMapping("/process-bill")
	public String showResultPage(@Valid @ModelAttribute BillDTO billDTO, BindingResult result) {
		logger.info("Inside BillController->showResultPage()");
		
		logger.info("Date: "+billDTO.getDate());
		logger.info("Amount: "+billDTO.getAmount());
		logger.info("CreditCard: "+billDTO.getCreditCard());
		logger.info("Currency: "+billDTO.getCurrency());
		
		if (result.hasErrors()) {
			logger.info("Inside showResultPage()->hasErrors()");
			return "Bill-Page";
		}
		
		return "Bill-Result-Page";
	}
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		
		//Register Custom Editor for Date Field
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		CustomDateEditor customDateEditor = new  CustomDateEditor(dateFormat, true);
		binder.registerCustomEditor(Date.class,"date",customDateEditor);
		
		//Register Custom Editor for Amount Field
		NumberFormat numberFormat = new DecimalFormat("##,###.00");
		CustomNumberEditor customNumberEditor = new CustomNumberEditor(BigDecimal.class,numberFormat, true);
		binder.registerCustomEditor(BigDecimal.class,"amount",customNumberEditor);
		
		//Register Custom Editor for Currency Field
		MyCurrencyEditor currencyEditor =  new MyCurrencyEditor();
		binder.registerCustomEditor(Currency.class,"currency", currencyEditor);
		
		//Adding a custom Formatter
		binder.addCustomFormatter(new CreditCardFormatter());
		
		//Register Custom Editor for creditCard Field
		CreditCardEditor creditCardEditor = new CreditCardEditor();
		binder.registerCustomEditor(CreditCard.class,"creditCard",creditCardEditor);
		
		
	}
}

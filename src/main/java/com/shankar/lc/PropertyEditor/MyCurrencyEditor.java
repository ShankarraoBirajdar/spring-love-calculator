package com.shankar.lc.PropertyEditor;

import java.beans.PropertyEditorSupport;
import java.util.Currency;
import java.util.logging.Logger;

public class MyCurrencyEditor extends PropertyEditorSupport {

	private final Logger logger = Logger.getLogger(this.getClass().getName());
	
	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		logger.info("Inside MyCurrencyEditor->setAsText()");
		Currency currency = Currency.getInstance(text.toUpperCase());
		setValue(currency);
	}
}

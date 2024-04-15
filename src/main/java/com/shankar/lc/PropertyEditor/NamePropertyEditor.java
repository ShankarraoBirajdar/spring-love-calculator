package com.shankar.lc.PropertyEditor;

import java.beans.PropertyEditorSupport;
import java.util.logging.Logger;

public class NamePropertyEditor extends PropertyEditorSupport {

	private final Logger logger = Logger.getLogger(this.getClass().getName());
	
	@Override
	public String getAsText() {
		logger.info("Inside NamePropertyEditor->getAsText()");
		return null;
	}

	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		logger.info("Inside NamePropertyEditor->setAsText()");
		String myCovertedStringValue = text.toUpperCase();
		setValue(myCovertedStringValue);
	}
}

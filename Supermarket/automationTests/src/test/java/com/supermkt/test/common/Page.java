package com.supermkt.test.common;

import org.openqa.selenium.WebDriver;

public class Page {
	protected WebDriver driver;

	public Page(WebDriver driver) {
		this.driver = driver;
	}

	public void checkHeader(String headerText) {
		// Assert if header text matches the string passed.
	}

	public boolean checkFooter(String footerText) {
		// Assert if footer text matches the string passed.
		return footerText.equalsIgnoreCase("This is a footer");
	}

	public void navigateTo(String link) {
		// Clicks on link specified
	}
}

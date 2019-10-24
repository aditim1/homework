package com.supermkt.test.common;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class Page {
	protected WebDriver driver;

	public Page(WebDriver driver) {
		this.driver = driver;
	}

	public void isPageLoaded(String header) {
		Assert.assertTrue("Header not found!", checkHeader(header));
		Assert.assertTrue("Footer not found!", checkFooter());
	}
	
	public boolean checkHeader(String headerText) {
		String actualHeader = driver.findElement(By.id("header")).getText();
		return actualHeader.equalsIgnoreCase(headerText);
	}

	public boolean checkFooter() {
		String footerText = driver.findElement(By.id("footer")).getText();
		return footerText.equalsIgnoreCase("This is a footer");
	}

	public void logout() {
		driver.findElement(By.id("logout")).click();
	}
}

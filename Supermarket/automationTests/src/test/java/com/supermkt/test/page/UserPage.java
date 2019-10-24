package com.supermkt.test.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.supermkt.test.common.Page;

public class UserPage extends Page {
	private By nameField = By.name("name");
	private By addressField = By.id("address");
	private By submitButton = By.id("submit");

	public UserPage(WebDriver driver) {
		super(driver);
	}

	public void setNameField(String name) {
		driver.findElement(nameField).sendKeys(name);
	}

	public void setAddressField(String address) {
		driver.findElement(addressField).sendKeys(address);
	}

	public void submit() {
		driver.findElement(submitButton).click();
	}

}

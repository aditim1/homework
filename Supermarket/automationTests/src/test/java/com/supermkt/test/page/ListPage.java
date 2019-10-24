package com.supermkt.test.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.supermkt.test.common.Page;

public class ListPage extends Page {
	private By searchText = By.name("enterSearchText");
	private By submitButton = By.id("submit");

	public ListPage(WebDriver driver) {
		super(driver);
	}
	
	public void setSearchText(String textToSearch) {
		driver.findElement(searchText).sendKeys(textToSearch);
	}

	public void submit() {
		driver.findElement(submitButton).click();
	}

	public void performSearch(String textToSearch) {
		isPageLoaded("List Results Page");
		setSearchText("Category 1");
		submit();
	}

	@Override
	public void logout() {
		driver.findElement(By.id("listLogoutLink")).click();
	}
}

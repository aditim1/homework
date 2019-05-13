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

	public By getSearchText() {
		return searchText;
	}

	public void setSearchText(By searchText) {
		this.searchText = searchText;
	}

	public void submit() {
		driver.findElement(submitButton).click();
	}

	public void performSearch(String textToSearch) {
		setSearchText(searchText);
		submit();
	}

	@Override
	public boolean checkFooter(String str) {
		return false;
	}
}

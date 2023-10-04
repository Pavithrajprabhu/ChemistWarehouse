package com.chemistWarehousePages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage {
	public static WebDriver driver;
	

	@FindBy(xpath = "//a[text()='CONTINUE']")
	private WebElement cookies;
	
	@FindBy(xpath = "(//label[@class='menu-icon'])[2]")
	private WebElement allCategories;
	
	@FindBy(xpath = "(//span[text()='Baby Care'])[2]")
	private WebElement babyCare;

	public LandingPage(WebDriver driver) {
		LandingPage.driver=driver;
		PageFactory.initElements(driver,this);
	}

	public WebElement getCookies() {
		return cookies;
	}
	public WebElement getAllCategories() {
		return allCategories;
	}
	public WebElement getBabyCare() {
		return babyCare;
	}
}

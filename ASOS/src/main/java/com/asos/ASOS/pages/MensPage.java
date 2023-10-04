package com.asos.ASOS.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MensPage {
	
	public static WebDriver driver;
	
	@FindBy(xpath ="//p[text()='FRESH COATS']")
	private WebElement coats;
	
	public MensPage(WebDriver driver) {
		MensPage.driver = driver;
		PageFactory.initElements(driver,this);
	}

	public WebElement getCoats() {
		return coats;
	}
	
}

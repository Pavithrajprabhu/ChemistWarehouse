package com.asos.ASOS.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage {
	
	public static WebDriver driver;
	
	@FindBy(id = "men-floor")
	private WebElement mens;

	public LandingPage(WebDriver driver) {
		LandingPage.driver = driver;
		PageFactory.initElements(driver,this);
	}
	
	public WebElement getMens() {
		return mens;
	}
	

}

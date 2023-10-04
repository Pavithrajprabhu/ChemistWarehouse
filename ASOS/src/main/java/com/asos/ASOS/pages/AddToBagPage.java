package com.asos.ASOS.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddToBagPage {
	public static WebDriver driver;
	
	@FindBy(id = "variantSelector")
	private WebElement variant;
	
	@FindBy(xpath ="//div[@data-testid='primaryActions']")
	private WebElement addBag;
	
	
	public AddToBagPage(WebDriver driver) {
		AddToBagPage.driver=driver;
		PageFactory.initElements(driver,this);
	}

	public WebElement getVariant() {
		return variant;
	}
	
	public WebElement getAddBag() {
		return addBag;
	}

}

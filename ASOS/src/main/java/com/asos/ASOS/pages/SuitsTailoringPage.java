package com.asos.ASOS.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SuitsTailoringPage {

	public static WebDriver driver;

	@FindBy(xpath = "(//div[contains(@class,'productHeroContainer')])[2]")
	private WebElement jacket;

	public SuitsTailoringPage(WebDriver driver) {
		SuitsTailoringPage.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	public WebElement getJacket() {
		return jacket;
	}
}

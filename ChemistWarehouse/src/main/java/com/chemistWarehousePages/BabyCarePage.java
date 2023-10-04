package com.chemistWarehousePages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BabyCarePage {
	public static WebDriver driver;
	@FindBy(xpath ="//span[text()='Verify you are human']")
	private WebElement checbox;
	

	public BabyCarePage(WebDriver driver) {
		BabyCarePage.driver=driver;
		PageFactory.initElements(driver,this);
	}
	public WebElement getChecbox() {
		return checbox;
	}

}

package com.asos.ASOS;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.asos.ASOS.base.B;
import com.asos.ASOS.pages.AddToBagPage;
import com.asos.ASOS.pages.AllCoatsPage;
import com.asos.ASOS.pages.LandingPage;
import com.asos.ASOS.pages.MensPage;
import com.asos.ASOS.pages.SuitsTailoringPage;

public class Runner extends B {

	public static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		// Launching the Browser
		driver = launchBrowserOptions("chrome");

		// Navigate to the URL
		getUrl("https://www.asos.com/");

		// Home page select mens/woman category
		LandingPage lp = new LandingPage(driver);
		clickOnThelement(lp.getMens());

		// Selecting the category
		MensPage mp = new MensPage(driver);
		scrollIntoView(mp.getCoats());
		clickOnThelement(mp.getCoats());

		// In coats page selecting Categoru
		AllCoatsPage acp = new AllCoatsPage(driver);

		clickOnThelement(acp.getCategory());

		JavascriptExecutor js = (JavascriptExecutor) driver;

		// Locate the option in the dropdown menu

		WebElement container = driver.findElement(By.xpath("(//li[@class='li_uumN_'])[3]/child::div/child::div"));

		WebElement option = driver.findElement(By.xpath("//div[text()='Suits & Tailoring']"));

		// Scroll to the option
		js.executeScript("arguments[0].scrollTop = arguments[1].offsetTop;", container, option);

		// Click on the option to select it
		option.click();
		
		//Select the coats
		SuitsTailoringPage stp =new SuitsTailoringPage(driver);
		clickOnThelement(acp.getCategory());
		clickOnThelement(stp.getJacket());
		
		//Selecting size
		AddToBagPage atbp = new AddToBagPage (driver);
		
		dropDown(atbp.getVariant(),"byIndex", "5");
		
		clickOnThelement(atbp.getAddBag());
		

	}

}

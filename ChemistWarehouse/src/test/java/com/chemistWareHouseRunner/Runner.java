package com.chemistWareHouseRunner;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.chemistWarehouseBase.B;
import com.chemistWarehousePages.BabyCarePage;
import com.chemistWarehousePages.LandingPage;

public class Runner extends B {

	public static WebDriver driver;

	public static void main(String[] args) {
		// Launch the Browser
		driver = launchBrowserOptions("chrome");

		// Navigate to the Url
		getUrl("https://www.chemistwarehouse.com.au/");

		// Accepting the Site Cookies
		explicitWaitByLocator(By.linkText("CONTINUE"), 30);

		LandingPage lp = new LandingPage(driver);
		clickOnThelement(lp.getCookies());

		// click on All Categories
		explicitWaitByLocator(By.xpath("//span[text()='ALL CATEGORIES']"), 30);
		clickOnThelement(lp.getAllCategories());
		
		// Select the category
		explicitWaitByLocator(By.xpath("(//span[text()='Baby Care'])[2]"), 30);
		clickOnThelement(lp.getBabyCare());

		// handle robot checkbox
		BabyCarePage bcp = new BabyCarePage(driver);

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(
				By.xpath("//iframe[@title='Widget containing a Cloudflare security challenge']")));
		WebElement checkbox = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Verify you are human']")));
		checkbox.click();

	}

}

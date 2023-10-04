package com.chemistWarehouseBase;

import java.awt.AWTException;
import java.awt.Checkbox;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.List;
import org.apache.commons.io.FileSystemUtils;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.firefox.*;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.*;

import io.github.bonigarcia.wdm.WebDriverManager;

public class B {
	public static WebDriver driver;
	public static Actions action;

	// Method Creation to launch the browser
	public static WebDriver browserLauncher(String browserName) {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		if (browserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver(options);
		} else if (browserName.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		driver.manage().window().maximize();

		return driver;
	}
	
	//To launch the browser using Browser Options
	public static WebDriver launchBrowserOptions(String browserName) {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--ignore-certificate-errors");
		options.addArguments("chrome.switches", "--disable-extensions");
		options.addArguments("--disable-notifications");
		options.addArguments("enable-automation");
		options.addArguments("--incognito");
		options.addArguments("--start-maximized");
		//options.setAcceptInsecureCerts(true);
		
		
		
		if(browserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			DesiredCapabilities cap = new DesiredCapabilities();
			cap.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
			options.merge(cap);
			driver = new ChromeDriver(options);
		}
		else if (browserName.equalsIgnoreCase("firefox")){
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			FirefoxProfile profile = new FirefoxProfile();
			FirefoxOptions optionsFirefox = new FirefoxOptions();
			profile.setPreference("extensions.enabled", false);
			optionsFirefox.setProfile(profile);
			driver.manage().window().maximize();
		}
		else if (browserName.equalsIgnoreCase("ie")) {
			WebDriverManager.edgedriver().setup();
			driver = new InternetExplorerDriver();
		}
		
		return driver;
	}
	
	
	// Method Creation to click on web Elements
	public static void clickOnThelement(WebElement element) {
		element.click();
	}
	
	// Method Creation for passing sendKeys
	public static void inputValueElement(WebElement element, String value) {
		element.sendKeys(value);
	}
	
	//Method Creation for Clearing the input
	public static void inputClear(WebElement ele) {
	ele.clear();
	}

	// Method Creation for navigating to the URL
	public static WebDriver getUrl(String url) {
		driver.get(url);
		return driver;
	}

	// Method creation for close the browser
	public static WebDriver closeCurrentWindow() {
		driver.close();
		return driver;
	}

	// Method creation for quit the browser
	public static WebDriver quitMultipleWindows() {
		driver.quit();
		return driver;
	}

	// Method creation to get current url
	public static String currentUrl() {
		return driver.getCurrentUrl();
	}

	// Method creation to get title
	public static String titleOfWebpage() {
		return driver.getTitle();
	}

	// Method creation to get text
	public static String webText(WebElement ele) {
		return ele.getText();
	}

	// Method creation to get attribute
	public static String webAttribute(WebElement ele, String attributeName) {
		String attribute = ele.getAttribute(attributeName);
		return attribute;
	}

	// Method creation for explicit wait
	public static void explicitWait(int timeDuration, WebElement ele) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeDuration));
		wait.until(ExpectedConditions.visibilityOf(ele));
	}
	
	//Method Creation for Wait By Locator
	public static void explicitWaitByLocator(By locator, int duration) {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(duration));
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

	// Method creation for implicit wait
	public static void implicitWait(int timeDuration) {
		driver.manage().timeouts().implicitlyWait(timeDuration, TimeUnit.SECONDS);
	}

	// Method creation for handling frames
//	public static WebElement framesWindows(String nameOrId, int index, WebElement ele) {
//		if (nameOrId != null && !nameOrId.isEmpty()) {
//			driver.switchTo().frame(nameOrId);
//		} else if (index >= 0) {
//			driver.switchTo().frame(index);
//		} else if (ele != null)
//			driver.switchTo().frame(ele);
//		return null;
//	}
	public static void switchtoIframe(String options, Object value) {
		try {
			if (options.equalsIgnoreCase("index")) {
				driver.switchTo().frame(Integer.parseInt((String) value));
			} else if (options.equalsIgnoreCase("name")) {
				driver.switchTo().frame((String) value);
			} else if (options.equalsIgnoreCase("element")) {
				driver.switchTo().frame((WebElement) value);
			}
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	// Method creation for handling Js Alerts
	public static void alertPopUp() {
		driver.switchTo().alert().accept();
	}

	// Method creation for Navigate To
	public static void toNavigate(String url) {

		driver.navigate().to(url);
	}

	// Method creation for Navigate forward
	public static void forwardNavigate() {
		driver.navigate().forward();
	}

	// Method creation for Navigate back
	public static void backNavigate() {
		driver.navigate().back();
	}

	// Method creation for Navigate and refresh
	public static void refreshNavigate() {
		driver.navigate().refresh();
	}

	// Method Creation to perform action-Right Click/context click
	public static void actionClass(WebElement ele) {
		action = new Actions(driver);
		action.contextClick(ele).build().perform();
	}

	// Method Creation to perform action-MoveToElement
	public static void mouseHovering(WebElement ele) {
		action = new Actions(driver);
		action.moveToElement(ele).build().perform();
	}
	
	// Method Creation to perform action-MoveToElement
		public static void doublClick(WebElement ele) {
			action = new Actions(driver);
			action.doubleClick(ele).build().perform();
		}

	// Method Creation to perform action-Drag&Drop---Method(1)
	public static void dragAndDrop(WebElement from, WebElement to) {
		action = new Actions(driver);
		action.dragAndDrop(from, to).build().perform();
	}

	// Method Creation to perform action-Drag&Drop---Method(2)
	public static void clickHoldAndDrop(WebElement from, WebElement to) {
		action = new Actions(driver);
		action.clickAndHold(from).build().perform();
		action.moveToElement(to).build().perform();
		// action.sendKeys(input).build().perform();
	}

	// Method to send input using actions
	public static void sendInput(WebElement input, String value) {
		action = new Actions(driver);
		action.sendKeys(input, value).build().perform();
	}

	// Method creation for Robot Class
	public static void keyboardKeysPress() throws AWTException {
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_DOWN);
		robot.keyRelease(KeyEvent.VK_DOWN);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
	}

	// Method creation for JavaScript executor-up
	public static void pageUp() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,-500)");
	}

	// Method creation for JavaScript executor-down
	public static void pageDown() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1000)");
	}

	// Method creation for JavaScript executor-View of Element
	public static void scrollIntoView(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", element);
	}

	// Method creation for windows handling Using FOR-Each to get the title of the
	// Tabs
	public static void windowHandlesTitle() {
		Set<String> element = driver.getWindowHandles();

		for (String st : element) {
			String title = driver.switchTo().window(st).getTitle();
			System.out.println(title);
		}

	}

	// Method creation for windows handling Using FOR-Each to get the desired TAB
	public static void windowHandles() {
		Set<String> element = driver.getWindowHandles();

		String selenium = "The Selenium Browser Automation Project | Selenium";
		for (String string : element) {
			if (driver.switchTo().window(string).getTitle().contains(selenium)) {
				break;
			}
		}
	}

	// Method creation for windows handling Using ITERATION to get the desired TAB
	public static void iterationWidowHandling() {
		String homeTab = driver.getWindowHandle();//// Storing the current window in a Variable
		Set<String> windowHandels = driver.getWindowHandles();// Storing all window handels
		Iterator<String> childTab = windowHandels.iterator();// Now iterate using Iterator
		while (childTab.hasNext()) {
			String selenium = childTab.next();
			String title = "WebDriver | Selenium";
			if (driver.switchTo().window(selenium).getTitle().contains(title)) {
				break;
			}
		}
	}

	// Method Creation for the radio Btn
	public static void clickRadoiBtn(WebElement ele) {
		ele.click();
	}

	// Method Creation for the radio Btn Status-isSelected
	public static void radoiBtnStatus(WebElement ele) {
		boolean selected = ele.isSelected();
		if (selected) {
			System.out.println("Button not selected");
		} else {
			System.out.println("Button is selected");
		}
	}

	// Method Creation for the radio Btn Status-Enabled
	public static void radoiBtnEnabled(WebElement ele) {
		boolean enabled = ele.isEnabled();
		if (enabled) {
			System.out.println("Button is enabled");
		} else {
			System.out.println("Button not enabled");
		}
	}

	// Method Creation for the radio Btn Status-Displayed
	public static void radoiBtndisplayed(WebElement ele) {
		boolean display = ele.isDisplayed();
		if (display) {
			System.out.println("Button is display");
		} else {
			System.out.println("Button not display");
		}
	}

	// Method Creation to handel dropdown
	public static void dropDown(WebElement element, String Option, String value) {
		Select sc = new Select(element);

		if (Option.equalsIgnoreCase("byIndex")) {
			int parseInt = Integer.parseInt(value);//Value is by default 'String' in the webpage so it is converted into the 'Integer' 
			sc.selectByIndex(parseInt);
		} else if (Option.equalsIgnoreCase("byValue")) {
			sc.selectByValue(value);
		} else if (Option.equalsIgnoreCase("byVisibleText")) {
			sc.selectByVisibleText(value);
		} else {
			System.out.println("Invalid option");
		}
	}

	// Method Creation to handel dropdown
	public static void dropDownOption(WebElement ele) {
		Select dropOptions = new Select(ele);

		List<WebElement> options = dropOptions.getOptions();

		for (WebElement option : options) {
			System.out.println(option.getText());
		}

	}

	// Method Creation to get firstSelectedOption from dropdown-Note which retrieve
	// the option we select
	public static WebElement dropDownFirstOption(WebElement ele) {
		Select firstOptions = new Select(ele);
		WebElement firstSelectedOption = firstOptions.getFirstSelectedOption();
		String first = firstSelectedOption.getText();
		System.out.println(first);
		return firstSelectedOption;
	}

	// Method Creation to get Get all selected options from dropdown-It retrieves
	// the all the selected options
	public static void dropDownAllOption(WebElement ele) {
		Select allOptions = new Select(ele);
		List<WebElement> allTheOptions = allOptions.getAllSelectedOptions();
		for (WebElement all : allTheOptions) {
			System.out.println(all.getText());
		}
	}

	// Method creation for checkbox
	public static void checkBoxHandle(WebElement ele) {
		ele.click();
	}
	//MethodCreation For taking Screenshot
	public static void screenshot(String path) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File sourceFile = ts.getScreenshotAs(OutputType.FILE);
		File destinateFile = new File(path);
		FileUtils.copyFileToDirectory(sourceFile, destinateFile);

	}
}

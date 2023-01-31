package com.business.tonikPages;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.AssertJUnit.assertNotNull;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.List;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;

import com.Datasheet.RingPay_TestData_DataProvider;
import com.android.selectors.Stash_StashHomeSelectors;
import com.driverInstance.CommandBase;
import com.extent.ExtentReporter;
import com.propertyfilereader.PropertyFileReader;
import com.utility.LoggingUtils;
import com.utility.Utilities;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class BasePage extends Utilities {

	public String formattedDate =null;

	public String txt=null;

	public BasePage() throws InterruptedException {
		//new CommandBase(Application);
		init();
	}

	public BasePage(String Application) throws InterruptedException {
		new CommandBase(Application);
		init();
	}

	public int timeout;
	SoftAssert softAssertion = new SoftAssert();
	boolean launch = "" != null;
	/** Retry Count */
	public int retryCount;
	ExtentReporter extent = new ExtentReporter();

	/** The Constant logger. */
	public static LoggingUtils logger = new LoggingUtils();

	/** The Android driver. */
	public AndroidDriver<AndroidElement> androidDriver;

	public static boolean relaunchFlag = false;
	public static boolean appliTools = false;

	public static boolean PopUp = false;

	public int getTimeout() {
		return timeout;
	}

	public void setTimeout(int timeout) {
		this.timeout = timeout;
	}

	public int getRetryCount() {
		return retryCount;
	}

	public void setRetryCount(int retryCount) {
		this.retryCount = retryCount;

	}


	/**
	 * Initiate Property File.
	 *
	 * @param byLocator the by locator
	 */

	public void init() {

		PropertyFileReader handler = new PropertyFileReader("properties/Execution.properties");
		setTimeout(Integer.parseInt(handler.getproperty("TIMEOUT")));
		setRetryCount(Integer.parseInt(handler.getproperty("RETRY_COUNT")));
		logger.info(
				"Loaded the following properties" + " TimeOut :" + getTimeout() + " RetryCount :" + getRetryCount());
	}
	/**
	 * This Business Method to close the Application
	 */
	public void TearDown() {
		logger.info("App tear Down");
		getDriver().quit();
	}

	/**
	 * This Generic function is to get the current date and time of any format
	 * dd MMM YYYY hh:mm a ----> 12 Jan 2023 10:00 PM/AM
	 * Time Zone ---> UTC+08:00 (Philippines)
	 * @return
	 */
	public  String dateComparison() {
		LocalDateTime myDateObj = LocalDateTime.now(ZoneId.of("UTC+08:00"));
		System.out.println("Before formatting: " + myDateObj);
		DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd MMM YYYY hh.mm a");
		formattedDate= myDateObj.format(myFormatObj);
		System.out.println("After formatting: " + formattedDate);
		ZoneId zone = ZoneId.of("UTC+08:00");
		ZonedDateTime zdt = myDateObj.atZone(zone);
		Instant instant = zdt.toInstant();
		instant.toString();
		return formattedDate;
	}

	/**
	 * This Generic function is to get the current date format
	 * dd MMM YYYY hh:mm a ----> 12 Jan 2023
	 * Time Zone ---> UTC+08:00 (Philippines)
	 * @return
	 */
	public  String dateComparisonWithoutTime() {
		LocalDateTime myDateObj = LocalDateTime.now(ZoneId.of("UTC+08:00"));
		System.out.println("Before formatting: " + myDateObj);
		DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd MMM YYYY");
		formattedDate= myDateObj.format(myFormatObj);
		System.out.println("After formatting: " + formattedDate);
		ZoneId zone = ZoneId.of("UTC+08:00");
		ZonedDateTime zdt = myDateObj.atZone(zone);
		Instant instant = zdt.toInstant();
		instant.toString();
		return formattedDate;
	}
	/**
	 * This Generic function is to get the current date and time and Following Months and Year of any format
	 * dd MMM YYYY hh:mm a ----> 12 Jan 2023 10:00 PM/AM
	 * Time Zone ---> UTC+08:00 (Philippines)
	 * @return
	 */
	public  String dateComparisonWithoutTimeAndFutureDates(int months) {
		LocalDateTime myDateObj = LocalDateTime.now(ZoneId.of("UTC+08:00")).plusMonths(months);
		System.out.println("Before formatting: " + myDateObj);
		DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd MMM YYYY");
		//Calendar cal = Calendar.getInstance();
		//	cal.add(Calendar.MONTH, months);
		formattedDate= myDateObj.format(myFormatObj);
		System.out.println("After formatting: " + formattedDate);
		ZoneId zone = ZoneId.of("UTC+08:00");
		ZonedDateTime zdt = myDateObj.atZone(zone);
		Instant instant = zdt.toInstant();
		instant.toString();
		return formattedDate;
	}
	/**
	 * This generic function is to move from Existing page to previous Page
	 * @param count ---> 1 
	 */
	public void moveToPreviousPage(int count) {
		Back(count);
		waitTime(6000);
	}
	/**
	 * This generic function to get percentage of background-color of particular element
	 * @param byLocator
	 * @return
	 * @throws Exception
	 */

	public int fetchElementColor(By byLocator) throws Exception {
		WebElement elem = findElement(byLocator);

		Point point = ((MobileElement) elem).getCenter();
		//	String color = elem.getCssValue("background-color");
		//	System.out.println(color);
		int centerX = point.getX();
		int centerY = point.getY();

		File scrFile = ((TakesScreenshot)getDriver()).getScreenshotAs(OutputType.FILE);

		BufferedImage image = ImageIO.read(scrFile);
		// Getting pixel color by position x and y 
		int clr = image.getRGB(centerX,centerY); 
		int red   = (clr & 0x00ff0000) >> 16;
		int green = (clr & 0x0000ff00) >> 8;
		int blue  =  clr & 0x000000ff;
		System.out.println("Red Color value = "+ red);
		System.out.println("Green Color value = "+ green);
		System.out.println("Blue Color value = "+ blue);
		return clr;
	}
	/**
	 * This Business Method is to fetch all the created Stashes Names in Stash Home Page
	 * @throws Exception
	 */
	public void fetchAllStashNames() throws Exception
	{
		if(verifyElementPresent(Stash_StashHomeSelectors.txtStash, "Stash")) {
			List<WebElement> list = getDriver().findElements(Stash_StashHomeSelectors.txtStash);
			for(WebElement wb : list)
			{
				txt = wb.getText();
				System.out.println("Stash Name ----->"+txt);
			}
		}
		Swipe("up", 1);
		if(verifyElementPresent(Stash_StashHomeSelectors.txtStash, "Stash")) {
			List<WebElement> lis = getDriver().findElements(Stash_StashHomeSelectors.txtStash);
			for(WebElement wb : lis) 
			{
				txt = wb.getText();
				System.out.println("Stash Name ----->"+txt);
			}
		}
		Swipe("up", 2);
		if(verifyElementPresent(Stash_StashHomeSelectors.txtStash, "Stash")) {
			List<WebElement> lis = getDriver().findElements(Stash_StashHomeSelectors.txtStash);
			for(WebElement wb : lis)
			{
				txt = wb.getText();
				System.out.println("Stash Name ----->"+txt);
			}
		}
		Swipe("down", 3);
	}
	
}

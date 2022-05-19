package project;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class Activity4_1 {
  
	AppiumDriver<MobileElement> driver = null;
	WebDriverWait wait;
	
	@BeforeTest
	public void setup() throws MalformedURLException {
		
		DesiredCapabilities caps = new DesiredCapabilities();
		 caps.setCapability("deviceName", "PixelEmulatorTest");
	     caps.setCapability("platformName", "android");
	     caps.setCapability("appPackage", "com.android.chrome");
	     caps.setCapability("appActivity", "com.google.android.apps.chrome.Main");
	     caps.setCapability("noReset", true);

		
		URL appServer = new URL("http://0.0.0.0:4723/wd/hub");
		driver = new AndroidDriver<MobileElement>(appServer, caps);
		wait = new WebDriverWait(driver,30);
		
	}
	
	@Test
	public void chromeTesting() throws InterruptedException {
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    driver.get("https://www.training-support.net/selenium");
		
//		driver.findElementById("search_box_text").click();
//		driver.findElementById("url_bar").click();
//		driver.findElementById("url_bar").sendKeys("https://www.training-support.net/selenium");
//		Actions action = new Actions(driver); 
//		action.sendKeys(Keys.ENTER).build().perform();
		//Thread.sleep(5000);
		//driver.navigate().to("https://www.training-support.net/selenium");
		Thread.sleep(5000);
				
		//driver.findElementByXPath("//*[contains(@text, 'To-Do List')]").click();
		
		
		//driver.findElement(MobileBy.AndroidUIAutomator("UiScrollable(UiSelector()).scrollTextIntoView(\"To-Do List\"))")).click();
		
		driver.findElement(MobileBy.AndroidUIAutomator(
		        "new UiScrollable(new UiSelector().scrollable(true))" +
		         ".scrollIntoView(new UiSelector().textContains(\"To-Do List\"))")).click();

		//driver.findElement(MobileBy.AndroidUIAutomator("UiScrollable(UiSelector()).getChildByText(UiSelector().className(\"android.view.View\"), \"To-Do List\")")).click();

		
		
		
	
	}
	
	
}

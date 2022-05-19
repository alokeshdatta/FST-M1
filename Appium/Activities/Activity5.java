package activities;

import java.awt.event.KeyEvent;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;


public class Activity5 {
  
	AppiumDriver<MobileElement> driver = null;
	WebDriverWait wait;
	@BeforeTest
	public void setup() throws MalformedURLException {
		
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("deviceName", "PixelEmulatorTest");
		caps.setCapability("platformName", "android");
		caps.setCapability("appPackage", "com.google.android.apps.messaging");
		caps.setCapability("appActivity", ".ui.ConversationListActivity");
		caps.setCapability("noReset", true);
		
		URL appServer = new URL("http://0.0.0.0:4723/wd/hub");
		driver = new AndroidDriver<MobileElement>(appServer, caps);
		wait = new WebDriverWait(driver,30);
	}

	@Test
	public void smsApplication() throws InterruptedException {
		
		driver.findElementById("start_new_conversation_button").click();
		Thread.sleep(5000);
		//wait.until(ExpectedConditions.elementToBeClickable(driver.findElementById("recipient_text_view")));
		driver.findElementById("recipient_text_view").sendKeys("9722156790");
		//driver.findElementById("recipient_text_view").sendKeys(Keys.ENTER);
		
		Actions action = new Actions(driver); 
		action.sendKeys(Keys.ENTER).build().perform();
		
		//wait.until(ExpectedConditions.elementToBeClickable(driver.findElementById("contact_picker_create_group")));
		Thread.sleep(2000);
		
		//driver.findElement(MobileBy.AndroidUIAutomator("resourceId(\"com.google.android.apps.messaging:id/contact_picker_create_group\")")).click();
		
		//driver.findElementById("contact_picker_create_group").click();
		System.out.println("Test");
		
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElementById("compose_message_text")));
		driver.findElementById("compose_message_text").sendKeys("Hello from Appium.");
		//wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(MobileBy.AndroidUIAutomator("resourceId(\"com.google.android.apps.messaging:id/compose_message_text\")"))));
		//driver.findElement(MobileBy.AndroidUIAutomator("resourceId(\"com.google.android.apps.messaging:id/compose_message_text\")")).sendKeys("Hello from Appium.");
				
		
		driver.findElementById("send_message_button_icon").click();
		
		String sentMessegeLocator = "com.google.android.apps.messaging:id/message_text";
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElementById(sentMessegeLocator)));
		
		Assert.assertEquals(driver.findElementById(sentMessegeLocator).getText(), "Hello from Appium.");
		System.out.println("passed");
		
		
	}
	
}

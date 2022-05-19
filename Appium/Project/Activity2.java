package project;

import java.net.MalformedURLException;
import java.net.URL;

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

public class Activity2 {
  
	AppiumDriver<MobileElement> driver = null;
	WebDriverWait wait;
	
	@BeforeTest
	public void setup() throws MalformedURLException {
		
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("deviceName", "PixelEmulatorTest");
		caps.setCapability("platformName", "android");
		caps.setCapability("appPackage", "com.google.android.keep");
		caps.setCapability("appActivity", ".activities.BrowseActivity");
		caps.setCapability("noReset", true);
		
		URL appServer = new URL("http://0.0.0.0:4723/wd/hub");
		driver = new AndroidDriver<MobileElement>(appServer, caps);
		wait = new WebDriverWait(driver,30);
	
	}	
	@Test
  public void googleKeep() throws InterruptedException {
	
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElementById("new_note_button")));	
		driver.findElementById("new_note_button").click();
		String title = "resourceId(\"com.google.android.keep:id/browse_note_interior_content\")";
		wait.until(ExpectedConditions.elementToBeClickable(MobileBy.AndroidUIAutomator(title)));
		//driver.findElementById("browse_note_interior_content").click(); // this was clickable=false
		driver.findElementById("browse_text_note").click();
		Thread.sleep(5000);
		driver.findElementById("browse_text_note").sendKeys("Project GKeep");
				
		//MobileElement keep = driver.findElementById("index_note_title"); // This id comes after providing value
		//keep.sendKeys("Project Keep");
		
		driver.findElement(MobileBy.AndroidUIAutomator("text(\"Note\")")).sendKeys("Project activity with Google-Keep app");
		//driver.findElement(MobileBy.AndroidUIAutomator(title)).click();
		//Thread.sleep(3000);
		//driver.findElement(MobileBy.AndroidUIAutomator(title)).sendKeys("Project GKeep");
		
		
		
		driver.findElementByAccessibilityId("Open navigation drawer").click();
		
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElementById("index_note_title")));	
		String addedTitle = driver.findElementById("index_note_title").getText();
		Assert.assertEquals(addedTitle, "Project GKeep");
		
		

  }
}

package activities;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class Activity3 {
  
	AppiumDriver<MobileElement> driver = null;
	
	@BeforeTest
	public void setup() throws MalformedURLException {
	
	DesiredCapabilities caps = new DesiredCapabilities();
	caps.setCapability("deviceName", "PixelEmulatorTest");
    caps.setCapability("platformName", "android");
	caps.setCapability("appPackage", "com.android.calculator2");
	caps.setCapability("appActivity", ".Calculator");
	caps.setCapability("noReset", true);

	// Instantiate Appium Driver
	URL appServer = new URL("http://0.0.0.0:4723/wd/hub");
	driver = new AndroidDriver<MobileElement>(appServer, caps);
	
	}
	@Test(priority=1)
    public void add() {
		
		driver.findElementById("digit_5").click();
		driver.findElementById("op_add").click();
		driver.findElementById("digit_9").click();
		
		String result = driver.findElementById("result").getText();
		System.out.println("addition result = "+result);
		Assert.assertEquals(result, "14");
    }
	
	@Test(priority=2)
	public void subtract() {
		
		driver.findElementById("digit_1").click();
        driver.findElementById("digit_0").click();
        driver.findElementById("op_sub").click();
        driver.findElementById("digit_5").click();
        
        String result = driver.findElementById("result").getText();
        System.out.println("subtraction result = "+result);
        Assert.assertEquals(result, "5");
        
    }
	
	@Test(priority=3)
	public void multiply() {
		
		driver.findElementById("digit_5").click();
        driver.findElementById("op_mul").click();
        driver.findElementById("digit_1").click();
        driver.findElementById("digit_0").click();
        driver.findElementById("digit_0").click();
		
		String result = driver.findElementById("result").getText();
		System.out.println("multiplication result = "+result);
		Assert.assertEquals(result, "500");
    }
	
	@Test(priority=4)
	public void divide() {
		
		driver.findElementById("digit_5").click();
        driver.findElementById("digit_0").click();
        driver.findElementById("op_div").click();
        driver.findElementById("digit_2").click();
		
		String result = driver.findElementById("result").getText();
		System.out.println("division result = "+ result);
		Assert.assertEquals(result, "14");
    }
	
	@AfterClass
    public void close() {
        driver.quit();
    }
}

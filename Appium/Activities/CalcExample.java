package activities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import io.appium.java_client.android.AndroidDriver;
import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.remote.DesiredCapabilities;

public class CalcExample {
    AppiumDriver<MobileElement> driver = null;
    
    // important - https://subscription.packtpub.com/book/application-development/9781784392482/1/ch01lvl1sec11/desired-capabilities
    
    @BeforeClass
    public void beforeClass() throws MalformedURLException {
        // Set the Desired Capabilities
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

    @Test
    public void multiply() {
        driver.findElementById("digit_7").click();
        driver.findElementById("op_mul").click();
        driver.findElementById("digit_4").click();
        driver.findElementById("eq").click();
        
        //Display Result
        String result = driver.findElementById("result").getText();
        System.out.println(result);
        Assert.assertEquals(result, "28");
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
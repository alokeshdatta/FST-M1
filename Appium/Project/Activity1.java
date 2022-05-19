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

public class Activity1 {
	AppiumDriver<MobileElement> driver = null;
	WebDriverWait wait;
	@BeforeTest
	public void setup() throws MalformedURLException {
		
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("deviceName", "PixelEmulatorTest");
		caps.setCapability("platformName", "android");
		caps.setCapability("appPackage", "com.google.android.apps.tasks");
		caps.setCapability("appActivity", ".ui.TaskListsActivity");
		caps.setCapability("noReset", true);
		
		URL appServer = new URL("http://0.0.0.0:4723/wd/hub");
		driver = new AndroidDriver<MobileElement>(appServer, caps);
		wait = new WebDriverWait(driver,30);
	}


	@Test
	public void googleTask() {
		
		String createNewTask = "resourceId(\"com.google.android.apps.tasks:id/tasks_fab\")";
		wait.until(ExpectedConditions.elementToBeClickable(MobileBy.AndroidUIAutomator(createNewTask)));
		driver.findElement(MobileBy.AndroidUIAutomator(createNewTask)).click();
		wait.until(ExpectedConditions.elementToBeClickable(MobileBy.AndroidUIAutomator("text(\"New task\")")));
        // Locate the button to write a new message and click it
        driver.findElement(MobileBy.AndroidUIAutomator("text(\"New task\")")).sendKeys("Complete Activity with Google Tasks");
        driver.findElement(MobileBy.AndroidUIAutomator("text(\"Save\")")).click();
        String task1 = "resourceId(\"com.google.android.apps.tasks:id/task_name\")";
        wait.until(ExpectedConditions.elementToBeClickable(MobileBy.AndroidUIAutomator(task1)));
		String inputTask1 = driver.findElement(MobileBy.AndroidUIAutomator(task1)).getText();
		System.out.println(inputTask1);
        
		wait.until(ExpectedConditions.elementToBeClickable(MobileBy.AndroidUIAutomator(createNewTask)));
		driver.findElement(MobileBy.AndroidUIAutomator(createNewTask)).click();
		wait.until(ExpectedConditions.elementToBeClickable(MobileBy.AndroidUIAutomator("text(\"New task\")")));
        // Locate the button to write a new message and click it
        driver.findElement(MobileBy.AndroidUIAutomator("text(\"New task\")")).sendKeys("Complete Activity with Google Keep");
        driver.findElement(MobileBy.AndroidUIAutomator("text(\"Save\")")).click();
        String task2 = "resourceId(\"com.google.android.apps.tasks:id/task_name\")";
        wait.until(ExpectedConditions.elementToBeClickable(MobileBy.AndroidUIAutomator(task2)));
		String inputTask2 = driver.findElement(MobileBy.AndroidUIAutomator(task2)).getText();
		System.out.println(inputTask2);
		
		
		wait.until(ExpectedConditions.elementToBeClickable(MobileBy.AndroidUIAutomator(createNewTask)));
		driver.findElement(MobileBy.AndroidUIAutomator(createNewTask)).click();
		wait.until(ExpectedConditions.elementToBeClickable(MobileBy.AndroidUIAutomator("text(\"New task\")")));
        // Locate the button to write a new message and click it
        driver.findElement(MobileBy.AndroidUIAutomator("text(\"New task\")")).sendKeys("Complete the second Activity Google Keep");
        driver.findElement(MobileBy.AndroidUIAutomator("text(\"Save\")")).click();
        String task3 = "resourceId(\"com.google.android.apps.tasks:id/task_name\")";
        wait.until(ExpectedConditions.elementToBeClickable(MobileBy.AndroidUIAutomator(task1)));
		String inputTask3 = driver.findElement(MobileBy.AndroidUIAutomator(task1)).getText();
		System.out.println(inputTask3);
		
        Assert.assertEquals(inputTask1, "Complete Activity with Google Tasks");
        Assert.assertEquals(inputTask2, "Complete Activity with Google Keep");
        Assert.assertEquals(inputTask3, "Complete the second Activity Google Keep");
        
	}

}

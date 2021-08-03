package testNGTests;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;

public class Activity1 {
  
	WebDriver driver;
  
  @Test
  public void f() {
	  String title = driver.getTitle();
	  System.out.println(title);
	  Assert.assertEquals("Training Support", title);
	  Reporter.log("home page title is matched");
	  driver.findElement(By.id("about-link")).click();
	  Assert.assertEquals(driver.getTitle(), "About Training Support");
	  
  }
  
  @BeforeMethod
  public void beforeMethod() {
	  driver = new FirefoxDriver();
	  driver.get("https://www.training-support.net");
	  }

  @AfterMethod
  public void afterMethod() {
  driver.close();
  }

}

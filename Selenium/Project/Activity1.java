package jobs_activities;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

public class Activity1 {
  
  WebDriver driver;
  
  @Test
  public void f() {
  String originalTitle = "Alchemy Jobs – Job Board Application";
  Assert.assertEquals(driver.getTitle(), originalTitle);
  
  }
  
  @BeforeMethod
  public void beforeMethod() {
	  driver = new FirefoxDriver();
	  driver.get("https://alchemy.hguy.co/jobs");
  }

  @AfterMethod
  public void afterMethod() {
  driver.close();
  }

}

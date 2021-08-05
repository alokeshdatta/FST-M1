package jobs_activities;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class Activity5 {
  WebDriver driver;
  @Test
  public void f5() {
	  
	driver.findElement(By.linkText("Jobs")).click();
	//System.out.println((driver.getTitle()));
	Assert.assertEquals(driver.getTitle(), "Jobs – Alchemy Jobs");
	  
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

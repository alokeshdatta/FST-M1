package jobs_activities;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class Activity2 {

  WebDriver driver;
  
  @Test
  public void f2() {
      System.out.println("no steps executed");
	  WebElement heading = driver.findElement(By.className("entry-title"));
	  //System.out.println(heading.getText());
	  String originalHeading = "Welcome to Alchemy Jobs";
	  Assert.assertEquals(heading.getText(), originalHeading);
	    
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

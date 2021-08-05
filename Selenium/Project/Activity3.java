package jobs_activities;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;

public class Activity3 {
  
  WebDriver driver;
  
  @Test
  public void f3() {
	  
	  WebElement image = driver.findElement(By.xpath("//img[contains(@class, 'attachment-large')]"));
	  System.out.println("The Url of the image is : "+image.getAttribute("src"));
	  
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

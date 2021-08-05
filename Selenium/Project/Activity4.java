package jobs_activities;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class Activity4 {
	WebDriver driver;
	  
	  @Test
	  public void f4() {
	  
		  WebElement heading2 = driver.findElement(By.xpath("//h2"));
		  //System.out.println(heading.getText());
		  String secondHeading = "Quia quis non";
		  Assert.assertEquals(heading2.getText(), secondHeading);
		  
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

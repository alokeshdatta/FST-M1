package jobs_activities;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class Activity8 {
  
	WebDriver driver;
	@Test
	@Parameters({"username", "password"})
	public void f8(String username, String password) {
		
		driver.findElement(By.xpath("//input[@id='user_login']")).sendKeys(username);
		driver.findElement(By.xpath("//input[@id='user_pass']")).sendKeys(password);
		
		driver.findElement(By.xpath("//input[@id='wp-submit']")).click();
		
		String name = driver.findElement(By.xpath("//ul[@id='wp-admin-bar-top-secondary']/li/a/span[@class='display-name']")).getText();
		Assert.assertEquals(name, username);
		System.out.println(username+" is logged in.");
		
	}
  @BeforeMethod
  public void beforeMethod() {
	  driver = new FirefoxDriver();
	  driver.get("https://alchemy.hguy.co/jobs/wp-admin");
	  //wait= new WebDriverWait(driver, 5);
	  
  }

  @AfterMethod
  public void afterMethod() {
  driver.close();
  }
}

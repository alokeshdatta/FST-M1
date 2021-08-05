package jobs_activities;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;

public class Activity6 {
  
  WebDriver driver;
  WebDriverWait wait;
  
  
  @Test
  public void f6() throws InterruptedException {
	  
	  driver.findElement(By.linkText("Jobs")).click();
	  driver.findElement(By.xpath("//input[@id='search_keywords']")).sendKeys("Banking");
	  driver.findElement(By.xpath("//input[@type='submit']")).click();
	  wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//article//div/ul/li[1]")));
	  
	  //which condition is better to use for an element to be present then click
	  WebElement job = driver.findElement(By.xpath("//article//div/ul/li[1]"));
	  job.click();
	  driver.findElement(By.xpath("//input[@value='Apply for job']")).click();
	  String email=driver.findElement(By.xpath("//a[@class=\"job_application_email\"]")).getText();
	  System.out.println("To apply for this job email id is : "+email);
  }
  
  @BeforeMethod
  public void beforeMethod() {
	  driver = new FirefoxDriver();
	  driver.get("https://alchemy.hguy.co/jobs");
	  wait= new WebDriverWait(driver, 5);
	  
  }

  @AfterMethod
  public void afterMethod() {
  driver.close();
  }

}

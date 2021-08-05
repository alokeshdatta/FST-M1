package jobs_activities;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class Activity7 {
	WebDriver driver;
	WebDriverWait wait;
  @Test
  public void f7() throws InterruptedException {
	  
	  driver.findElement(By.linkText("Post a Job")).click();
	  String title = "TestingADD";
	  WebElement jobTitle = driver.findElement(By.xpath("//input[@id='job_title']"));
	  WebElement email = driver.findElement(By.xpath("//input[@id='create_account_email']"));
	  WebElement url = driver.findElement(By.xpath("//input[@id='application']"));
	  WebElement companyName = driver.findElement(By.xpath("//input[@id='company_name']"));
	  WebElement previewButton = driver.findElement(By.xpath("//input[@value='Preview']"));
	  
	  driver.switchTo().frame(0);  
	  WebElement description = driver.findElement(By.xpath("//body[@id='tinymce']"));
	  //WebElement description = driver.findElement(By.cssSelector("#tinymce > p:nth-child(1)"));
	  System.out.println("Test");
	  driver.switchTo().defaultContent();
	  email.sendKeys("abc12347@mlp.com");
	  jobTitle.sendKeys(title);
	  driver.switchTo().frame(0);
	  System.out.println("Test1");
	  //new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(description)).click();
	  
	  
	  //String js = "arguments[0].setAttribute('value','"+inputText+"')"
	  //((JavascriptExecutor) driver).executeScript(js, myElement);
	  
	  description.click();
	  description.sendKeys("Test");
	  System.out.println("Test2");
	   driver.switchTo().defaultContent();
	  url.sendKeys("https://testad.com");
	  companyName.sendKeys("Orchid");
	  
	  previewButton.click();
	  
	  wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='job_preview_submit_button']")));
	  driver.findElement(By.xpath("//input[@id='job_preview_submit_button']")).click();
	  
	  driver.findElement(By.linkText("Jobs")).click();
	  wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//article//div/ul/li[3]//h3")));
	  String postedJobTitle = driver.findElement(By.xpath("//article//div/ul/li[3]//h3")).getText();
	  Assert.assertEquals(postedJobTitle, title);
	  System.out.println("Job is posted.");  
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

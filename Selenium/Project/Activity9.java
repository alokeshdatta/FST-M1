package jobs_activities;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class Activity9 {
  
	WebDriver driver;
	WebDriverWait wait;
	@Test
	@Parameters({"username", "password"})
  public void f9(String username, String password) {
		
		//String uname="root";
		driver.findElement(By.xpath("//input[@id='user_login']")).sendKeys(username);
		driver.findElement(By.xpath("//input[@id='user_pass']")).sendKeys(password);
		driver.findElement(By.xpath("//input[@id='wp-submit']")).click();
		WebElement jobListings = driver.findElement(By.xpath("//div[contains(text(), 'Job Listings')]"));
		jobListings.click();
		//Actions action=new Actions(driver);
		//action.moveToElement(jobListings).click().perform();
		
		Assert.assertEquals(driver.getCurrentUrl(), "https://alchemy.hguy.co/jobs/wp-admin/edit.php?post_type=job_listing");
		driver.findElement(By.xpath("//a[@class='page-title-action']")).click();
		
		driver.findElement(By.xpath("//button[@aria-label='Close dialog']")).click();
		
		//Alert alert= driver.switchTo().alert();
		//alert.dismiss();
		String positionName = "Test ENGineer";
		WebElement position = driver.findElement(By.xpath("//textarea[@placeholder='Position']"));
		WebElement jobLocation = driver.findElement(By.xpath("//input[@id='_job_location']"));
		WebElement companyName = driver.findElement(By.xpath("//input[@id='_company_name']"));
		WebElement compWebsite = driver.findElement(By.xpath("//input[@id='_company_website']"));
		WebElement tagline = driver.findElement(By.xpath("//input[@id='_company_tagline']"));
		WebElement twitter = driver.findElement(By.xpath("//input[@id='_company_twitter']"));
		WebElement video = driver.findElement(By.xpath("//input[@id='_company_video']"));
		WebElement publish = driver.findElement(By.xpath("//button[contains(text(), 'Publish')]"));
		
		position.sendKeys(positionName);
		jobLocation.sendKeys("Norway");
		companyName.sendKeys("Orchid");
		compWebsite.sendKeys("orchid,com");
		tagline.sendKeys("SoftTech");
		twitter.sendKeys("@orchid");
		video.sendKeys("orchid.com/videos");
		publish.click();
		driver.findElement(By.xpath("//div[@class='block-editor-editor-skeleton__body']//button[contains(@class, 'post-publish')]")).click();
		
		wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText(positionName)));
		//driver.findElement(By.linkText(positionName)).click();
		//System.out.println(driver.findElement(By.linkText(positionName)).isDisplayed());
		if (driver.findElement(By.linkText(positionName)).isDisplayed()) {
			System.out.println("Job is created!");
		}
			
	}
  
  @BeforeMethod
  public void beforeMethod() {
	  driver = new FirefoxDriver();
	  driver.get("https://alchemy.hguy.co/jobs/wp-admin");
	  wait= new WebDriverWait(driver, 5);
	  
  }

  @AfterMethod
  public void afterMethod() {
	  driver.close();
	  
  }

}

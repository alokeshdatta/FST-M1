package selenium_activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity3 {

	public static void main (String[] args) throws InterruptedException {
		
		WebDriver driver = new FirefoxDriver();
		driver.get("https://training-support.net/selenium/simple-form");
		System.out.println(driver.getTitle());
		
		WebElement firstName = driver.findElement(By.id("firstName"));
		firstName.sendKeys("alokesh");
		
		WebElement lastName = driver.findElement(By.id("lastName"));
		lastName.sendKeys("datta");
		
		driver.findElement(By.id("email")).sendKeys("abcd@xyz.com");
		
		driver.findElement(By.id("number")).sendKeys("3334445656");
		
		driver.findElement(By.xpath("//input[@value='submit']")).click();
		driver.switchTo().alert().accept();
		//Thread.sleep(2000);
		driver.close();
	}
	
}

package selenium_activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity4_2 {

public static void main (String[] args) throws InterruptedException {
		
		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.training-support.net/selenium/simple-form");
		System.out.println(driver.getTitle());
		driver.findElement(By.xpath("//input[@id = 'firstName']")).sendKeys("ab");
		driver.findElement(By.xpath("//input[@id = 'lastName']")).sendKeys("cd");
		driver.findElement(By.xpath("//input[@id = 'email']")).sendKeys("abc@xyz.com");
		driver.findElement(By.xpath("//input[@id = 'number']")).sendKeys("1112224545");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		driver.switchTo().alert().accept();
		driver.close();		
  }
}
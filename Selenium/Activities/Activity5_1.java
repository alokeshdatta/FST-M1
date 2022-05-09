package selenium_activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity5_1 {

public static void main (String[] args) throws InterruptedException {
		
		WebDriver driver = new FirefoxDriver();
		driver.get("https://training-support.net/selenium/dynamic-controls");
		System.out.println(driver.getTitle());
		WebElement checkbox = driver.findElement(By.xpath("//input[@type='checkbox']"));
		System.out.println("Is Checkbox visible? :"+ checkbox.isDisplayed());
		driver.findElement(By.id("toggleCheckbox")).click();
		System.out.println("Is Checkbox visible? :"+ checkbox.isDisplayed());
		driver.close();
 }
}

package selenium_activities;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class Activity10_2 {
	public static void main (String[] args) throws InterruptedException {
		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.training-support.net/selenium/input-events");
		System.out.println("The title is "+driver.getTitle());
		WebElement key = driver.findElement(By.id("keyPressed"));
		Actions action = new Actions(driver);
		action.sendKeys("A").build().perform();
		System.out.println("Pressed Key is : "+key.getText());
		Thread.sleep(2000);
		action.keyDown(Keys.CONTROL).sendKeys("a").sendKeys("c").keyUp(Keys.CONTROL).build().perform();
		driver.close();
	}
	
	
}

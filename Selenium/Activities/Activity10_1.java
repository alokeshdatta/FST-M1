package selenium_activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class Activity10_1 {

	public static void main (String[] args) throws InterruptedException {
		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.training-support.net/selenium/input-events");
		System.out.println("The title is "+driver.getTitle());
		Actions action = new Actions(driver);
		WebElement point = driver.findElement(By.id("wrapD3Cube"));
		Thread.sleep(4000);
		action.click(point).perform();
		System.out.println("Single Click: "+driver.findElement(By.xpath("//div[@class='active']")).getText());
		action.contextClick(point).perform();
		//Thread.sleep(3000);
		System.out.println("Right Click: "+driver.findElement(By.xpath("//div[@class='active']")).getText()); 
		action.doubleClick(point).perform(); 
		//Thread.sleep(3000);
		System.out.println("Double Click: "+driver.findElement(By.xpath("//div[@class='active']")).getText()); 
		
		driver.close();
	}
	
	
}



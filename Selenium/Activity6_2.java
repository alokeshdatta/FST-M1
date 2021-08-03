package selenium_activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Activity6_2 {

	public static void main(String[] args) {

        WebDriver driver = new FirefoxDriver();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        
        driver.get("https://training-support.net/selenium/ajax");
        String title = driver.getTitle();
        System.out.println("The page title is : "+title);
        
        driver.findElement(By.xpath("//button[contains(text(), 'Change Content')]")).click();
        //wait.until(ExpectedConditions.textToBePresentInElementValue(By.id("ajax-content"), "HELLO!"));
        // above one is for value
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.id("ajax-content"), "HELLO!"));
        String text = driver.findElement(By.id("ajax-content")).getText();
        System.out.println(text);
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.id("ajax-content"), "I'm late!"));
        String newtext = driver.findElement(By.id("ajax-content")).getText();
        System.out.println(newtext);
        
        driver.close();
	}
}

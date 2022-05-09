package selenium_activities;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity11_2 {

	public static void main(String[] args) {

		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.training-support.net/selenium/javascript-alerts");

		driver.findElement(By.id("confirm")).click();
		Alert confirmAlert1 = driver.switchTo().alert();
		System.out.println("Alert text is: " + confirmAlert1.getText());
		confirmAlert1.accept();

		driver.findElement(By.cssSelector("button#confirm")).click();
		Alert confirmAlert2 = driver.switchTo().alert();
		confirmAlert2.dismiss();

		driver.close();

	}

}
package selenium_activities;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Activity9_1 {

	public static void main (String[] args) {
		
		WebDriver driver = new FirefoxDriver();
		driver.get("https://training-support.net/selenium/selects");
		WebElement dropdown = driver.findElement(By.xpath("//select[@id = 'single-select']"));
		Select list = new Select(dropdown);
		list.selectByVisibleText("Option 2");	
		
		list.selectByIndex(3);
		list.selectByValue("4");
		
		List<WebElement> options = list.getOptions();
		for(WebElement option: options)
		{
			System.out.println(option.getText());
		}
		driver.close();
	}
	
}

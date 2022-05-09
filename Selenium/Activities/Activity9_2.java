package selenium_activities;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Activity9_2 {

public static void main (String[] args) {
		
		WebDriver driver = new FirefoxDriver();
		driver.get("https://training-support.net/selenium/selects");
		WebElement msdropdown = driver.findElement(By.xpath("//select[@id = 'multi-select']"));
		Select multilist = new Select (msdropdown);
		System.out.println("Is it a multiple list? : "+multilist.isMultiple());
		if (multilist.isMultiple()) {
		multilist.selectByIndex(4);
		multilist.selectByIndex(5);
		multilist.selectByIndex(6);
		multilist.selectByValue("node");
		multilist.selectByVisibleText("Javascript");
		multilist.deselectByValue("node");
		multilist.deselectByIndex(7);
		System.out.println("The first selected option is: "+multilist.getFirstSelectedOption().getText());
		List<WebElement> selectedvalues = multilist.getAllSelectedOptions();
		for(WebElement values:selectedvalues)
		{
			System.out.println(values.getText());
		}
		
		multilist.deselectAll();
		}
		driver.close();
	}
}

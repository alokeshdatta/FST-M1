package selenium_activities;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity8_1 {

	public static void main(String[] args) {

        WebDriver driver = new FirefoxDriver();
        
        driver.get("https://training-support.net/selenium/tables");
        List <WebElement> rows = driver.findElements(By.xpath("//table[contains(@class, 'ui celled striped table')]/tbody/tr"));
        System.out.println("No. Of rows are : "+rows.size());
        List <WebElement> cols = driver.findElements(By.xpath("//table[contains(@class, 'ui celled striped table')]/tbody/tr[1]/td"));
        System.out.println("No. Of columns are : "+cols.size());
        
        List <WebElement> thirdrow= driver.findElements(By.xpath("//table[contains(@class, 'ui celled striped table')]/tbody/tr[3]/td"));
        for(WebElement items : thirdrow) {
        System.out.println("Cell values are : "+items.getText());
        }
        
        driver.close();
	}
	
}

package selenium_activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Activity6_1 {

    public static void main(String[] args) {

        WebDriver driver = new FirefoxDriver();
        WebDriverWait wait = new WebDriverWait(driver, 5);
        
        driver.get("https://www.training-support.net/selenium/dynamic-controls");
        String title = driver.getTitle();
        System.out.println("The page title is : "+title);
        WebElement checkboxInput = driver.findElement(By.xpath("//input[@type='checkbox']"));
        WebElement toggle = driver.findElement(By.xpath("//button[@id='toggleCheckbox']"));	
        toggle.click();
        wait.until(ExpectedConditions.invisibilityOf(checkboxInput));
        toggle.click();
        wait.until(ExpectedConditions.visibilityOf(checkboxInput));
        checkboxInput.click();
        System.out.println("Is Checkbox selected ? : " + checkboxInput.isSelected());
        
        driver.close();

    }

}
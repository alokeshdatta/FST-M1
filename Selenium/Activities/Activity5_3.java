package selenium_activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;


public class Activity5_3 {

    public static void main(String[] args) {

        WebDriver driver = new FirefoxDriver();

        driver.get("https://www.training-support.net/selenium/dynamic-controls");
        String title = driver.getTitle();
        System.out.println("The page title is : "+title);
        WebElement textbox = driver.findElement(By.xpath("//input[@id='input-text']"));
        System.out.println("Is text box enabled ? : " + textbox.isEnabled());
        driver.findElement(By.id("toggleInput")).click();
        System.out.println("Is text box enabled ? : " + textbox.isEnabled());
        driver.close();

    }

}
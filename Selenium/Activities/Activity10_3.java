package selenium_activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Activity10_3 {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new FirefoxDriver();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        driver.get("https://training-support.net/selenium/drag-drop");
        wait.until(ExpectedConditions.elementToBeClickable(By.id("draggable")));
        
        // Save the different elements in variables
        WebElement ball = driver.findElement(By.id("draggable"));
        WebElement dropzone1 = driver.findElement(By.id("droppable"));
        WebElement dropzone2 = driver.findElement(By.id("dropzone2"));
        
        // Compile a custom action for Drag/Drop and perform it.
        Actions dragAndDrop = new Actions(driver);
        dragAndDrop.dragAndDrop(ball, dropzone1).build().perform();
        
        // Wait for the Dropzone's color to change 
        wait.until(ExpectedConditions.attributeToBeNotEmpty(dropzone1, "background-color"));
        System.out.println("ENTERED DROPZONE 1");
        
        // Repeat for the second dropzone
        dragAndDrop.dragAndDrop(ball, dropzone2).build().perform();
        wait.until(ExpectedConditions.attributeToBeNotEmpty(dropzone2, "background-color"));
        System.out.println("ENTERED DROPZONE 2");
        
        // Close the browser
        driver.close();
    }
}
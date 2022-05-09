package selenium_activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity4_3 {
public static void main (String[] args) throws InterruptedException {
		
		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.training-support.net/selenium/target-practice");
		System.out.println(driver.getTitle());
		String thirdHeader = driver.findElement(By.xpath("//h3[@id='third-header']")).getText();
		System.out.println("Third Header text is : "+thirdHeader);
		String colour=driver.findElement(By.xpath("//h5[contains(@class,'green')]")).getCssValue("color");
		System.out.println("Colour of the 5th header is: "+colour);
		
		System.out.println(driver.findElement(By.xpath("//button[contains(text(), 'Violet')]")).getAttribute("class"));

		WebElement greyButton=driver.findElement(By.xpath("/html/body/div/div[2]/div/div[2]/div/div/div/div[2]/div[3]/button[2]"));
        System.out.println(greyButton.getText());
        
        driver.close();
}
}

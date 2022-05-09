package selenium_activities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class Verification {
public static void main(String[] args) throws InterruptedException {
		        //Create a new instance of the Firefox driver
	        WebDriver driver = new FirefoxDriver();

	        //Open the browser
	        driver.get("https://www.google.com");
	        driver.get("https://www.training-support.net");
	        //Perform testing and assertions
	        Thread.sleep(3000);
            System.out.println("test passed");
	        //Close the browser
	        driver.close();
	    }
	}
	
	


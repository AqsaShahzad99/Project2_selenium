//import java.time.Duration;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class FilterHome {

	//@SuppressWarnings("unchecked")
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Selenium webdriver\\Chrome Driver\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://qa.therapytalk.ai/");
		driver.manage().window().maximize();
		
		
		WebElement emailField = driver.findElement(By.xpath("//input[@name='email']"));
        WebElement passwordField = driver.findElement(By.xpath("//input[@name='password']"));
        WebElement loginButton = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[2]/div/div/form/button"));

        // Perform the login action
        emailField.sendKeys("aqsaashahzad23@gmail.com");
        passwordField.sendKeys("Test12345@");
        loginButton.click();
        
      
        WebDriverWait wait1=new WebDriverWait(driver, Duration.ofSeconds(60));
         
        List<WebElement> checkboxes =  wait1.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector(".checkbox-button.hidden")));
        
     // Select only specific checkboxes (e.g., first 2 checkboxes)
        for (int i = 0; i < checkboxes.size(); i++) {
            if (i < 2 && !checkboxes.get(i).isSelected()) {
                checkboxes.get(i).click();  // Select the checkbox
            }
        }


        
        Thread.sleep(5000);
        driver.quit();
        
	}

}

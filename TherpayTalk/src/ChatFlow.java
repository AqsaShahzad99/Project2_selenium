import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ChatFlow {

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
        
        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(60));
		WebElement therapist_button =wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/div/div[3]/div[3]/a/div/div")));
		therapist_button.click();
        
		
		WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(40));
		WebElement therapist_profile =wait2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/main/div/div/div[2]/div[1]/button")));
		therapist_profile.click();
		
		
		WebElement begin_therapy =wait2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/main/div/div/div[2]/div[2]/div[1]/div[2]/form/button")));
		begin_therapy.click();
		
		
        
        String[] messages = {"Hello", "How are you?","Bye"};

        // Locator for the text area and the send button
        
        By textAreaLocator=(By.xpath("/html/body/div[2]/main/div/div/div[2]/div/div[3]/input"));
       // By sendButtonLocator=(By.xpath("/html/body/div[2]/main/div/div/div[2]/div/div[3]/button"));

        
       // WebDriverWait wait3 = new WebDriverWait(driver, Duration.ofSeconds(240));
        // Send each message with a wait in between
        for (String message : messages) {
            WebElement textArea = wait1.until(ExpectedConditions.visibilityOfElementLocated(textAreaLocator));
            //textArea.clear();
            textArea.click();
            textArea.sendKeys(message);
         
            driver.findElement(By.xpath("/html/body/div[2]/main/div/div/div[2]/div/div[3]/button")).click();
            
            
            Thread.sleep(8000);
            textArea.clear();
 

        }	
		
        Thread.sleep(10000);
        driver.quit();


	}

}

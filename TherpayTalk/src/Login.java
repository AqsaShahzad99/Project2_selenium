import org.testng.TestNG;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import java.util.ArrayList;
import java.util.List;
import org.testng.annotations.Listeners;

@Listeners(Listener.class)

public class Login {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        // Set up WebDriver (Chrome in this case)
        System.setProperty("webdriver.chrome.driver", "C:\\Selenium webdriver\\Chrome Driver\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        // Close the browser after the test
    	Thread.sleep(5000);
        driver.quit();
    }

    @DataProvider(name = "loginData")
    public Object[][] loginDataProvider() {
        return new Object[][]{
                {"aqsashehzad99@gmail.com", "Test12345@", true},
                {"aqsashehzad99@gmail.com", "Test12345", false},
                {"aqsashehzad98@gmail.com", "Test12345@", false},
                {"", "", false}, // Empty fields
        };
    }

    @Test(dataProvider = "loginData")
    public void testLogin(String email, String password, boolean expectedResult) throws InterruptedException {
        // Navigate to the login page
        driver.get("https://qa.therapytalk.ai/");

        // Find the email and password fields and the login button
        WebElement emailField = driver.findElement(By.xpath("//input[@name='email']"));
        WebElement passwordField = driver.findElement(By.xpath("//input[@name='password']"));
        WebElement loginButton = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[2]/div/div/form/button"));

        // Perform the login action
        emailField.sendKeys(email);
        passwordField.sendKeys(password);
        loginButton.click();

        // Check if login is successful or not
        boolean loginSuccessful;
        
        try {
                String currenturl = driver.getCurrentUrl();
                loginSuccessful = currenturl.equals("https://qa.therapytalk.ai/questionaire");
        	
        } catch (Exception e) {
            loginSuccessful = false;
        }

        // Validate the result based on expected outcome
        Assert.assertEquals(loginSuccessful, expectedResult);

        Thread.sleep(10000);
    }

    // Main method to run TestNG tests programmatically
    public static void main(String[] args) {
        TestNG testng = new TestNG();
        List<String> suites = new ArrayList<>();
        suites.add("path_to_your_testng.xml"); // Optionally, you can run an XML suite file
        testng.setTestClasses(new Class[]{Login.class}); // Specify the class containing TestNG tests
        testng.run();
    }
}

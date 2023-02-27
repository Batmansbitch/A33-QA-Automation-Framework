import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;


public class BaseTest {

    @BeforeSuite
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    public class LoginTests extends BaseTest {

        @Test
        public static void SuccessfulRegistrationTest() {

            WebDriver driver = new ChromeDriver();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

            String url = "https://bbb.testpro.io/";
            String urlRegistration = "https://bbb.testpro.io/registration.php"
            driver.get(url);

            WebElement registration = driver.findElement(By.id("Registration"));
            registration.click();


            Assert.assertEquals(driver.getCurrentUrl(), url);

            Assert.assertEquals(driver.getCurrentUrl(), urlRegistration);
            driver.quit();
        }
    }
}
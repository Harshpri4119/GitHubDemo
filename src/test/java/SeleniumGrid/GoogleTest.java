package SeleniumGrid;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import java.net.URL;

public class GoogleTest {

    String localHostURL = "http://192.168.0.7:4444";
    String url = "https://www.google.com";

    String browserName = "chrome";

    @Test
    public void googleTest() throws Exception {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(CapabilityType.BROWSER_NAME, browserName);

        WebDriver driver = new RemoteWebDriver(new URL(localHostURL), capabilities);
        driver.get(url);
        String pageTitle = driver.getTitle();

        System.out.println(pageTitle);

        driver.findElement(By.xpath("//input[@name='q']")).sendKeys("Lord Krishna");
        driver.findElement(By.xpath("//input[@name='q']")).sendKeys(Keys.ENTER);
        driver.close();
    }
}

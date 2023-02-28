package SeleniumGrid;

import io.netty.channel.local.LocalAddress;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import java.net.URL;

public class YoutubeTest {

    String localHost = "http://192.168.0.7:4444";
    String url = "https://www.youtube.com";

    String browserName = "firefox";

    @Test
    public void youtubeTest() throws Exception {

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(CapabilityType.BROWSER_NAME, browserName);

        WebDriver driver = new RemoteWebDriver(new URL(localHost), capabilities);

        driver.get(url);

        String pageTitle = driver.getTitle();

        System.out.println(pageTitle);

        driver.findElement(By.xpath("//input[@name='search_query']"))
                .sendKeys("Yada yada hi dharmasya mahabharat");

        driver.findElement(By.xpath("//input[@name='search_query']")).sendKeys(Keys.ENTER);

        driver.close();
    }
}

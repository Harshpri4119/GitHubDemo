package ChromeDevTools;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class CDPCommandsTest {

    @Test
    public void youtubeTest() {

        WebDriverManager.chromedriver().setup();

        ChromeDriver driver = new ChromeDriver();
        DevTools devTools = driver.getDevTools();
        devTools.createSession();

        Map<String, Object> desiredMetrics = new HashMap<>();

        desiredMetrics.put("width", 600);
        desiredMetrics.put("height",1000);
        desiredMetrics.put("deviceScaleFactor",50);
        desiredMetrics.put("mobile",true);

        driver.executeCdpCommand("Emulation.setDeviceMetricsOverride", desiredMetrics);

        driver.manage().window().maximize();

        driver.get("https://www.youtube.com");
        driver.findElement(By.xpath("//input[@id='search']")).sendKeys("Mahabharat Lord Krishna");
        driver.findElement(By.xpath("//input[@id='search']")).sendKeys(Keys.ENTER);

    }
}

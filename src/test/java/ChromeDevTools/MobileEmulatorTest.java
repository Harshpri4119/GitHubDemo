package ChromeDevTools;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v109.emulation.Emulation;
import org.testng.annotations.Test;

import java.util.Optional;

public class MobileEmulatorTest {

    @Test
    public void mobileEmulatorTest(){

        WebDriverManager.chromedriver().setup();

        // Invokes Chrome Driver to CDP using getDevTools()
        ChromeDriver driver = new ChromeDriver();
        DevTools devTools = driver.getDevTools();
        devTools.createSession();

        devTools.send(Emulation.setDeviceMetricsOverride(600, 1000, 50, true,
                Optional.empty(),Optional.empty(),Optional.empty(),Optional.empty(),
                Optional.empty(),Optional.empty(),Optional.empty(),Optional.empty(),
                Optional.empty()));

        driver.manage().window().maximize();
        driver.get("https://www.facebook.com");
        driver.findElement(By.xpath("//input[@type='text']")).sendKeys("9182203017");
        driver.findElement(By.xpath("//input[@type='password']")).sendKeys("9440183118");
        driver.findElement(By.xpath("//button[@name='login']")).click();

    }
}

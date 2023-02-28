package org.example.test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import java.util.List;

public class Youtube {

    public WebDriver driver;


    String searchText = "janani mei ram dhut hanuman song";

    @Test
    public void launchTest() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        driver.get("https://www.youtube.com");

        driver.manage().window().maximize();

        String pageTitle = driver.getTitle();
        System.out.println(pageTitle);

    }

    @Test
    public void youtubeHome() {
        driver.findElement(By.xpath("//input[@name='search_query']")).sendKeys(searchText);
        driver.findElement(By.xpath("//input[@name='search_query']")).sendKeys(Keys.ENTER);

        List<WebElement> listData = driver.findElements(By.xpath("//a[@id='video-title']/yt-formatted-string"));
        System.out.println(" ========================================== ");

        for (int i = 0; i < listData.size(); i++) {
            WebElement list = listData.get(i);
            String name = list.getAttribute("title");
            System.out.println(name);
            driver.findElements(By.xpath("//a[@id='video-title']/yt-formatted-string")).get(0).click();
        }
    }
}

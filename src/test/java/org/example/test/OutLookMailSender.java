package org.example.test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class OutLookMailSender {
    public WebDriver driver;
    String userName = "Harsha4119@outlook.com";
    String passWord = "Harsha@123";
    String toEmail = "Murali.k@piramal.com";
    String mailSubject = "Selenium Auto Generated Email";

    String mailBody = "Hi, This is Emanav, Iam an Auto Generated Email, written and programmed by Harsha Vardhan K.";

    @Test
    public void LaunchTest() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://outlook.live.com/owa/");
        String title = driver.getTitle();
        System.out.println(title);
    }

    @Test
    public void LoginTest() throws Exception {
        driver.findElement(By.xpath("//a[@data-task='signin']")).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(6));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@type='email']")));

        driver.findElement(By.xpath("//input[@type='email']")).sendKeys(userName);
        driver.findElement(By.xpath("//input[@type='submit']")).click();

        driver.findElement(By.xpath("//input[@type='password']")).sendKeys(passWord);
        Thread.sleep(3000);
        driver.findElement(By.xpath("//input[@type='submit']")).click();
        driver.findElement(By.xpath("//input[@id='KmsiCheckboxField']")).click();
        driver.findElement(By.xpath("//input[@type='submit']")).click();

    }

    @Test
    public void mailWriteTest() throws Exception {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//span[@class='flexContainer-164'])[1]")));

        driver.findElement(By.xpath("(//span[@class='flexContainer-164'])[1]")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,'EditorClass')]")));
        driver.findElement(By.xpath("//div[contains(@class,'EditorClass')]")).sendKeys(toEmail);
        driver.findElement(By.xpath("//div[contains(@class,'EditorClass')]")).sendKeys(Keys.ENTER);
        driver.findElement(By.xpath("//input[@placeholder='Add a subject']")).sendKeys(mailSubject);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,'dFCbN')]")));
        driver.findElement(By.xpath("//div[contains(@class,'dFCbN')]")).sendKeys(mailBody);
        driver.findElement(By.xpath("//button[@title='Send (Ctrl+Enter)']")).click();
    }

    @Test
    public void validationMailTest() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@title='Sent Items'])[1]")));
        driver.findElement(By.xpath("(//div[@title='Sent Items'])[1]")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,'W3BHj')][1]")));

        List<WebElement> elements = driver.findElements(By.xpath("//div[contains(@class,'W3BHj')][1]"));

        for (int i = 0; i < elements.size(); i++) {
            String element = elements.get(i).getText();
            if (element.contains(toEmail)) {
                driver.findElements(By.xpath("//div[contains(@class,'W3BHj')][1]")).get(0).click();
            }
        }

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='IIvzX']")));

        String mailReceiver = driver.findElement(By.xpath("//div[@class='IIvzX']")).getText();
        String mailReceiverDateAndTime = driver.findElement(By.xpath("//div[@class='srQCs']")).getText();

        System.out.println("Mail Sent To: " + mailReceiver);
        System.out.println("Mail Sent On: " + mailReceiverDateAndTime);
    }
}

package org.example.test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GuruBankLogin {
    public WebDriver driver;


    @Test
    public void launch() {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.get("https://www.demo.guru99.com/V4/");
    }

    @Test
    public void login() {
        driver.findElement(By.xpath("//input[@name='uid']")).sendKeys("mngr479237");
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("hAtezAj");
        driver.findElement(By.xpath("//input[@name='btnLogin']")).click();
        System.out.println("Login Successful!!! ");
    }
}

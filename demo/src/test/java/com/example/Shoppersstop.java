package com.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Shoppersstop 
{
    WebDriver driver;
    String URL;
    @BeforeTest
    public void driverSetUp(){
        driver = new ChromeDriver();
        driver.get("https://www.shoppersstop.com");
        URL = driver.getCurrentUrl();
    }
    @Test
    public void testShoppersstop() throws InterruptedException{
        driver.findElement(By.xpath("//*[@id='profileImage']/a")).click();
        driver.manage().window().maximize();
        String title = driver.getTitle();
        System.out.println(title);

        String page = driver.getPageSource();
        System.out.println(page);

        int length = driver.getPageSource().length();
        System.out.println(length);

        driver.navigate().to("https://www.google.com");
        Thread.sleep(5000);
        driver.navigate().back();
        String url = driver.getCurrentUrl();
        if(url.equals(URL)){
            System.out.println("URL is match");
        }
        else{
            System.out.println("URL doesn't match");
        }
    }
    @AfterTest
    public void wrapUp() throws InterruptedException{
        Thread.sleep(5000);
        driver.quit();
    }
}

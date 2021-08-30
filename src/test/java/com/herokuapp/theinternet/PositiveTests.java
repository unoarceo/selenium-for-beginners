package com.herokuapp.theinternet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;


public class PositiveTests {

    @Test
    public void loginTest() throws InterruptedException {
        System.out.println("Starting loginTest");

        //Create driver
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        //maximize browser window
        driver.manage().window().maximize();

        //open test page
        String url = "https://the-internet.herokuapp.com/login";
        driver.get(url);
        System.out.println("Page is open");

        //enter user name
        String strUsername = "tomsmith";
        WebElement username = driver.findElement(new By.ById("username"));
        System.out.println("Username: ".concat(strUsername));
        username.sendKeys(strUsername);

        //enter password
        String strPassword = "SuperSecretPassword!";
        WebElement password = driver.findElement(new By.ById("password"));
        System.out.println("Password: ".concat(strPassword));
        password.sendKeys(strPassword);

        //click login button
        //driver.findElement(new By.ByClassName("radius")).click();
        driver.findElement(new By.ByXPath("//button[@class='radius']")).click();

        //verifications
        //- new url
        //- logout button is visible
        //- successful login message


        //Close the browser
        Thread.sleep(3000);
        driver.quit();
    }
}

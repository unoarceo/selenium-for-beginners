package com.herokuapp.theinternet;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
    Common config = new Common();
    String browser = "chrome";
    @Test
    public void Successful_Login() throws InterruptedException{
        WebDriver driver = config.openBrowser(browser);
        driver.get(config.baseURL.concat("/login"));
        System.out.println("Opening URL ".concat(config.baseURL.concat("/login")));
        System.out.println();

        // Enter user name
        WebElement username = driver.findElement(new By.ById("username"));
        System.out.println("Username: ".concat(config.UserName));
        username.sendKeys(config.UserName);

        // Enter password
        WebElement password = driver.findElement(new By.ById("password"));
        System.out.println("Password: ".concat(config.Password));
        password.sendKeys(config.Password);
        System.out.println();

        // Click login button
        driver.findElement(new By.ByXPath("//button[@class='radius']")).click();

        Thread.sleep(config.WaitMS);

        System.out.println("Verify URL");
        String strExpectedURL = config.baseURL.concat("/secure");
        String strActualURL = driver.getCurrentUrl().trim().toLowerCase();
        System.out.println("Expected: ".concat(strExpectedURL));
        System.out.println("Actual: ".concat(strActualURL));
        if(!strExpectedURL.equals(strActualURL))
            Assertions.fail("URL is not as expected!");
        System.out.println();

        System.out.println("Verify Success Message");
        String strExpectedMsg = "You logged into a secure area!";
        WebElement successMsg = driver.findElement(By.xpath("//div[@id='flash'][@class='flash success']"));
        String[] strActualMsg = successMsg.getText().trim().split("\n");
        System.out.println("Expected: ".concat(strExpectedMsg));
        System.out.println("Actual: ".concat(strActualMsg[0]));
        if (!strExpectedMsg.equals(strActualMsg[0]))
            Assertions.fail("Message is not as expected!");
        System.out.println();

        // Logout
        driver.findElement(By.xpath("//a/i[@class='icon-2x icon-signout']")).click();

        driver.quit();
    }
}

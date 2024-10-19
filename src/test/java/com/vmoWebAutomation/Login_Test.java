package com.vmoWebAutomation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class Login_Test {


    @Test
    public void loginWithValidCredential() {
        WebDriver driver=new EdgeDriver();
        driver.get("https://app.vwo.com");

        WebElement UserName=driver.findElement(By.id("login-username"));
        UserName.sendKeys("shilpa@gmail.com");

        WebElement passWord=driver.findElement(By.id("login-password"));
        passWord.sendKeys("Test@12345");

       WebElement signInButton=driver.findElement(By.id("js-login-btn"));
        signInButton.click();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        WebElement dashboradVarification=driver.findElement(By.xpath("//*[@class='navbar-btn-label']"));
         String actualResult=dashboradVarification.getText();
         if (actualResult.equals("Dashboard"))
         {
             Assert.assertTrue(true);
         }

          driver.quit();
    }
}

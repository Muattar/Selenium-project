package com.cydeo.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CRM_Utilities {

    /*
    This class will LogIn using below credentials
    username: helpdesk1@cydeo.com
    password: UserUser
     */

    public static void login_crm(WebDriver driver){

        //Enter valid userName
        WebElement userNameButton = driver.findElement(By.xpath("//input[@class='login-inp']"));
        userNameButton.sendKeys("helpdesk1@cydeo.com");

        BrowserUtils.sleep(3);

        // Enter valid password
        WebElement passwordButton = driver.findElement(By.xpath("//input[@type='password']"));
        passwordButton.sendKeys("UserUser");

        BrowserUtils.sleep(3);

        // Click to `Log In` button
        WebElement logInButton = driver.findElement(By.xpath("//input[@value='Log In']"));
        logInButton.click();
    }

    public static void login_crm(WebDriver driver, String userName, String passWord){

        //Enter valid userName
        WebElement userNameButton = driver.findElement(By.xpath("//input[@class='login-inp']"));
        userNameButton.sendKeys(userName);

        BrowserUtils.sleep(3);

        // Enter valid password
        WebElement passwordButton = driver.findElement(By.xpath("//input[@type='password']"));
        passwordButton.sendKeys(passWord);

        BrowserUtils.sleep(3);

        // Click to `Log In` button
        WebElement logInButton = driver.findElement(By.xpath("//input[@value='Log In']"));
        logInButton.click();
    }


}

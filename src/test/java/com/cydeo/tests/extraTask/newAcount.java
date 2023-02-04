package com.cydeo.tests.extraTask;

import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class newAcount {

    //1. Launch browser
    //2. Navigate to url 'http://automationexercise.com'
    //3. Verify that home page is visible successfully
    //4. Click on 'Signup / Login' button
    //5. Verify 'New User Signup!' is visible
    //6. Enter name and email address
    //7. Click 'Signup' button
    //8. Verify that 'ENTER ACCOUNT INFORMATION' is visible
    //9. Fill details: Title, Name, Email, Password, Date of birth
    //10. Select checkbox 'Sign up for our newsletter!'
    //11. Select checkbox 'Receive special offers from our partners!'
    //12. Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number
    //13. Click 'Create Account button'
    //14. Verify that 'ACCOUNT CREATED!' is visible
    //15. Click 'Continue' button
    //16. Verify that 'Logged in as username' is visible
WebDriver driver;

    @BeforeMethod
     public void setUpMethod(){
        //1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'
        driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("http://automationexercise.com");
    }

    @Test
    public void signUpTest1(){
        //3. Verify that home page is visible successfully
        String expectedResult = "Automation Exercise";
        String actualResult = driver.getTitle();

        Assert.assertEquals(actualResult, expectedResult);

        BrowserUtils.sleep(2);

        //4. Click on 'Signup / Login' button
        WebElement signUpButton = driver.findElement(By.xpath("//a[@href='/login']"));
        signUpButton.click();

        //5. Verify 'New User Signup!' is visible
        String expectedSignResult = "Automation Exercise - Signup / Login";
        String actualSignResult = driver.getTitle();
        Assert.assertEquals(actualSignResult, expectedSignResult);

        BrowserUtils.sleep(2);

        //6. Enter name and email address
        WebElement nameButton = driver.findElement(By.xpath("//input[@name='name']"));
        nameButton.sendKeys("Cala");
        WebElement emailButton = driver.findElement(By.xpath("//input[@data-qa='signup-email']"));
        emailButton.sendKeys("muattarbegmatova671@gmail.com");

        BrowserUtils.sleep(2);


        //7. Click 'Signup' button
        WebElement signButton = driver.findElement(By.xpath("//button[@data-qa='signup-button']"));
        signButton.click();

        BrowserUtils.sleep(2);

        //8. Verify that 'ENTER ACCOUNT INFORMATION' is visible
        String expectedText = "ENTER ACCOUNT INFORMATION";
        String actualText = expectedText.toString();


        //9. Fill details: Title, Name, Email, Password, Date of birth
        BrowserUtils.sleep(2);



    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

}

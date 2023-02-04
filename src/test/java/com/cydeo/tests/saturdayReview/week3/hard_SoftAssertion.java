package com.cydeo.tests.saturdayReview.week3;

import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class hard_SoftAssertion {

    // TC#1: Registration Form Page Testing
    // 1. Open Chrome browser
    // 2. Go to https://practice.cydeo.com/registration_form
    // 3. Verify title is as expected:
    // Expected: "Registration Form"
    // 4. Select "SDET" from Job title dropdown
    // 5. Verify "SDET" is selected

    WebDriver driver;

    @BeforeMethod
    public void setUpMethod(){
        // 1. Open Chrome browser
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        // 2. Go to https://practice.cydeo.com/registration_form
        driver.get("https://practice.cydeo.com/registration_form");
    }

    @Test
    public void registrationFormPage_hardAssert_test(){

        // 3. Verify title is as expected:
        // Expected: "Registration Form"
        String actualTitle = driver.getTitle();
        String expectedTitle = "Registration Form";

        Assert.assertTrue(actualTitle.equals(expectedTitle), "Title verification is FAIL");
        Assert.assertEquals(actualTitle, expectedTitle, "Title verification is FAIL!!!");

        //System.out.println("After hard assertion Failed");

        // 4. Select "SDET" from Job title dropdown
        Select jobTitle = new Select(driver.findElement(By.xpath("//select[@name='job_title']")));
       // jobTitle.selectByVisibleText("SDET");
        jobTitle.selectByIndex(4);//index number for drop down starts from 0

        BrowserUtils.sleep(2);

        // 5. Verify "SDET" is selected
        String actualSelect = jobTitle.getFirstSelectedOption().getText();
        String expectedSelect = "SDET";
        Assert.assertEquals(actualSelect, expectedSelect, "Title verification is FAIL!!!");

       // Assert.assertTrue(jobTitle.getFirstSelectedOption().getText().equals("SDET"));

    }

    @Test
    public void registrationFormPage_softAssert_test(){

        // 3. Verify title is as expected:
        // Expected: "Registration Form"
        String actualTitle = driver.getTitle();
        String expectedTitle = "Registration Form";

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(actualTitle, expectedTitle);

        System.out.println("After soft assertion Failed");


        // 4. Select "SDET" from Job title dropdown
        Select jobTitle = new Select(driver.findElement(By.xpath("//select[@name='job_title']")));
        // jobTitle.selectByVisibleText("SDET");
        jobTitle.selectByIndex(4);//index number for drop down starts from 0

        BrowserUtils.sleep(2);

        // 5. Verify "SDET" is selected
        String actualSelect = jobTitle.getFirstSelectedOption().getText();
        String expectedSelect = "SDET";

       softAssert.assertEquals(actualSelect, expectedSelect);

       //If we don't use assertAll(), softAssert will not work and assert checks will not be happining
       softAssert.assertAll();

    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
     }




}

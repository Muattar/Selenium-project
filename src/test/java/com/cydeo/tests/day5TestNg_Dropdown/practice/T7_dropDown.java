package com.cydeo.tests.day5TestNg_Dropdown.practice;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class T7_dropDown {

    //TC #7: Selecting state from State dropdown and verifying result
    //1. Open Chrome browser
    //2. Go to http://practice.cybertekschool.com/dropdown
    //3. Select Illinois
    //4. Select Virginia
    //5. Select California
    //6. Verify final selected option is California.
    //Use all Select options. (visible text, value, index)

    WebDriver driver;

    @BeforeMethod
    public void setUpMethod(){
       // 1. Open Chrome browser
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        //2. Go to http://practice.cybertekschool.com/dropdown
        driver.get("http://practice.cybertekschool.com/dropdown");

    }

    @Test
    public void T7Test() throws InterruptedException {

        //locate the dropdown and create select object
        Select stateDropDown = new Select(driver.findElement(By.xpath("//select[@id='state']")));

        //Use all Select options. (visible text, value, index)
        //3. Select Illinois
        Thread.sleep(2000);
        stateDropDown.selectByVisibleText("Illinois");

        //4. Select Virginia
        Thread.sleep(2000);
        stateDropDown.selectByValue("VA");

        //5. Select California
        Thread.sleep(2000);
        stateDropDown.selectByIndex(5);


        //6. Verify final selected option is California.
        String expectedOptionText = "California";
        String actualOptionText = stateDropDown.getFirstSelectedOption().getText();

        //Assertion

        Assert.assertEquals(actualOptionText, expectedOptionText, "State DropDown value is not as Expected!!!");

    }

   @AfterMethod
   public void  tearDownMethod(){
    driver.close();
        }







}

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

public class T6DropDown {

    //TC #6: Selecting date on dropdown and verifying
    //1. Open Chrome browser
    //2. Go to https://practice.cydeo.com/dropdown
    //3. Select “December 1st, 1933” and verify it is selected.
    //Select year using : visible text
    //Select month using : value attribute
    //Select day using : index number

    WebDriver driver;

    @BeforeMethod
    public void setUpMethod(){
    driver = WebDriverFactory.getDriver("chrome");
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    driver.get("https://practice.cydeo.com/dropdown");
}

    @Test
    public void dropDownTask6() throws InterruptedException {
    //3. Select “December 1st, 1933” and verify it is selected.
    Select yearDropDown = new Select(driver.findElement(By.xpath("//select[@id='year']")));
    Select monthDropDown = new Select(driver.findElement(By.xpath("//select[@id='month']")));
    Select dayDropDown = new Select(driver.findElement(By.xpath("//select[@id='day']")));

    //Select year using : visible text
        Thread.sleep(2000);
        yearDropDown.selectByVisibleText("1933");

    //Select month using : value attribute
        Thread.sleep(2000);

        monthDropDown.selectByValue("11");

    //Select day using : index number
        Thread.sleep(2000);

        dayDropDown.selectByIndex(0);
        Thread.sleep(2000);

        // create expected values
        String expectedYear = "1933";
        String expectedMonth = "December";
        String expectedDay = "1";

        //getting actual values from browser
        String actualYear = yearDropDown.getFirstSelectedOption().getText();
        String actualMonth = monthDropDown.getFirstSelectedOption().getText();
        String actualDay = dayDropDown.getFirstSelectedOption().getText();

        //Assert

        Assert.assertEquals(actualYear, expectedYear);
        Assert.assertEquals(actualMonth, expectedMonth);
        Assert.assertEquals(actualDay, expectedDay);


    }


@AfterMethod
    public void tearDownMethod(){
        driver.close();
}







}

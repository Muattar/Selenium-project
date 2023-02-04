package com.cydeo.tests.saturdayReview.week3;

import com.cydeo.tests.base.TestBase;
import com.cydeo.utilities.BrowserUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class alertPractice extends TestBase {

    // 1. Open browser
    // 2. Go to website: https://practice.cydeo.com/javascript_alerts
    // 3. Click to “Click for JS Prompt” button
    // 4. Send “hello” text to alert
    // 5. Click to OK button from the alert
    // 6. Verify “You entered: hello” text is displayed.


   /* WebDriver driver;

    @BeforeMethod
    public void setUpMethod(){
        // 1. Open Chrome browser
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        // 2. Go to https://practice.cydeo.com/javascript_alerts
        driver.get("https://practice.cydeo.com/javascript_alerts");
    }*/

    @Test
    public void prompt_alert_test1(){
        // 2. Go to https://practice.cydeo.com/javascript_alerts
        driver.get("https://practice.cydeo.com/javascript_alerts");

        // 3. Click to “Click for JS Prompt” button
        WebElement jsPromptAlert = driver.findElement(By.xpath("//button[@onclick='jsPrompt()']"));
        jsPromptAlert.click();

        //4. Send “hello” text to alert
        Alert alert = driver.switchTo().alert();
        System.out.println("alert.getText() = " + alert.getText());

        alert.sendKeys("hello");


        BrowserUtils.sleep(3);

        //5. Click to OK button from the alert
        alert.accept();


        //6. Verify “You entered: hello” text is displayed.
        WebElement resultText = driver.findElement(By.id("result"));
        String expectedText = "You entered: hello";
        String actualText = resultText.getText();

        Assert.assertEquals(actualText, expectedText, "Text verification is FAIL!!!");
        BrowserUtils.sleep(3);

    }


  /*  @AfterMethod
    public void tearDown(){
        driver.quit();
    }*/


}

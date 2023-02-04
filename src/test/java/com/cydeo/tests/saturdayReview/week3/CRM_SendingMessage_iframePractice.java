package com.cydeo.tests.saturdayReview.week3;

import com.cydeo.tests.base.TestBase;
import com.cydeo.utilities.CRM_Utilities;
import com.cydeo.utilities.ConfigurationReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CRM_SendingMessage_iframePractice extends TestBase {

    //  1. Users are already login and on the homepage
    //  2. Users click the MESSAGE tab
    //  3. Users write test message
    //  4. Users click the SEND button
    //  5. Verify the message is displayed on the feed


    @Test
    public void sending_message_test1(){

        //  1. Users are already login and on the homepage
        driver.get(ConfigurationReader.getProperty("env"));
        CRM_Utilities.login_crm(driver);


        //  2. Users click the MESSAGE tab
        WebElement messageTab = driver.findElement(By.xpath("//span[text()='Send message …']"));
        messageTab.click();


        //  3. Users write test message
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='bx-editor-iframe']")));
        WebElement messageFrame = driver.findElement(By.tagName("body"));
        messageFrame.sendKeys("Hello!!! Good Afternoon!!!!");


        // 4. Users click the SEND button
        //driver.switchTo().parentFrame();//if we have nested iframe, and you want to go from child iframe to parent iframe
        driver.switchTo().defaultContent();//if we want to go back to main HTM directly
        WebElement sendButton = driver.findElement(By.xpath("//button[@class='ui-btn ui-btn-lg ui-btn-primary']"));
        sendButton.click();


        //  5. Verify the message is displayed on the feed

       // WebElement feed = driver.findElement(By.xpath("//div[starts-with(@id,'blog_post_body')]"));
        String actualText = driver.findElement(By.xpath("//div[starts-with(@id,'blog_post_body')]")).toString();
        String expectedText = "Hello!!! Good Afternoon!!!!";

        Assert.assertEquals(actualText, expectedText, "Text verification is FAIL!!!");








    }





}

package com.cydeo.tests.day7_webtables_utilities_javafaker;

import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.CRM_Utilities;
import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class T2_CRM_LogInScenario {
    //TC #4: Login scenario
    //1. Create new test and make set/ups
    //2. Go to: http://login1.nextbasecrm.com/
    //3. Enter valid username
    //4. Enter valid password
    //5. Click to `Log In` button
    //6. Verify title is as expected:
    //Expected: Portal

    WebDriver driver;

    @BeforeMethod
    public void setUpMethod(){

        //1. Create new test and make set/ups
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //2. Go to: http://login1.nextbasecrm.com/
        driver.get("http://login1.nextbasecrm.com/");

    }
    @Test
    public void test1_CRm_LogIn(){
        //3. Enter valid username
        WebElement userNameButton = driver.findElement(By.xpath("//input[@class='login-inp']"));
        userNameButton.sendKeys("helpdesk1@cydeo.com");

        BrowserUtils.sleep(3);

        //4. Enter valid password
        WebElement passwordButton = driver.findElement(By.xpath("//input[@type='password']"));
        passwordButton.sendKeys("UserUser");

        BrowserUtils.sleep(3);

        //5. Click to `Log In` button
        WebElement logInButton = driver.findElement(By.xpath("//input[@value='Log In']"));
        logInButton.click();


        //6. Verify title is as expected:
        //Expected: Portal

        BrowserUtils.verifyTitleContains(driver, "Portal");


    }

    public void test2_CRm_LogIn(){

        //LogIn using the utility method we create in CRM_Utility class
        CRM_Utilities.login_crm(driver);

        //6. Verify title is as expected:
        //Expected: Portal
        BrowserUtils.sleep(3);
        BrowserUtils.verifyTitleContains(driver, "Portal");


    }

    public void test3_CRm_LogIn() {

        //LogIn using the utility method we create in CRM_Utility class
        CRM_Utilities.login_crm(driver, "helpdesk1@cydeo.com", "UserUser");

        //6. Verify title is as expected:
        //Expected: Portal
        BrowserUtils.sleep(3);
        BrowserUtils.verifyTitleContains(driver, "Portal");

    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

}

package com.cydeo.tests.day4;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;

public class T1_xPath_cssSelector_practices {

    public static void main(String[] args)  {

        //TC#1:XPATH and cssSelector Practices
        //1. Open Chrome browser
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        //2.Go to https://practice.cydeo.com/forgot_password
        driver.get("https://practice.cydeo.com/forgot_password");



        //3.Locate all the WebElements on the page using XPATH and/or CSS locator only(total of 6)

        //a."Home" link
        //Locate "Home" link using cssSelector, syntax #1 class attribute value
        //          tagName[attribute='value']
        WebElement homeLink_ex1 = driver.findElement(By.cssSelector("a[class='nav-link']"));

        //Locate "Home" link using cssSelector, syntax #2 class attribute value
        //          tagName.classValue
        WebElement homeLink_ex2 = driver.findElement(By.cssSelector("a.nav-link"));

        //Locate "Home" link using cssSelector, syntax #1 href attribute value
        WebElement homeLink_ex3 = driver.findElement(By.cssSelector("a[href='/']"));

        //---------------------------------------------------------------------------------------


        //b. "Forgot password" header
        //Locate header using xpath using text of h2
        WebElement header1 = driver.findElement(By.xpath("//h2[text()='Forgot Password']"));

        //Locate header using cssSelector, syntax #1, locate parent element and move down to h2
                   //                 tagName[attribute='value']       parent > child
        WebElement header2 = driver.findElement(By.cssSelector("div[class='example']>h2"));
        //Locate header using cssSelector, syntax #2, locate parent element and move down to h2
                                                      //tagName.classValue(parent) > child
        WebElement header3 = driver.findElement(By.cssSelector("div.example>h2"));


        //---------------------------------------------------------------------------------------


        //c. "E-mail" text
        //locate the 'email' label using xpath          (//tagName[@attribute='value'])
        WebElement emailLabel1 = driver.findElement(By.xpath("//label[@for='email']"));

        //                                                    //tagName[text()='text']
        WebElement emailLabel2 = driver.findElement(By.xpath("//label[text()='E-mail']"));

        //                                                    //*[@attribute='value']
        WebElement emailLabel3 = driver.findElement(By.xpath("//*[@for='email']"));

        //                                        //tagName[contains(@attribute, 'value')]
        WebElement emailLabel4 = driver.findElement(By.xpath("//label[contains(@for,'email')]"));

        //---------------------------------------------------------------------------------------


        //d. E-mail input box
        //locate the 'E-mail' label using xpath          (//tagName[@attribute='value'])
        WebElement emailBox1 = driver.findElement(By.xpath("//input[@name='email']"));

        //                                        //tagName[contains(@attribute, 'value')]
        WebElement emailBox2 = driver.findElement(By.xpath("//input[contains(@type,'text')]"));

        //---------------------------------------------------------------------------------------

        //e. "Retrieve password" button
        // locate the 'Retrieve password' label using xpath    (//tagName[@attribute='value'])
        WebElement retPassButton1 = driver.findElement(By.xpath("//button[@id='form_submit']"));

        //                                                    //*[@attribute='value']
        WebElement retPassButton2 = driver.findElement(By.xpath("//*[@class='radius']"));


        //---------------------------------------------------------------------------------------

        //f. "Powered by Cydeo" text
        // locate the 'Powered by Cydeo' text label using xpath   //tagName[text()='text']
        WebElement cydeoText1 = driver.findElement(By.xpath("//div[text()='Powered by ']"));

       //                                                    (//tagName[@attribute='value'])
        WebElement cydeoText2 = driver.findElement(By.xpath("//div[@style='text-align: center;']"));


        //---------------------------------------------------------------------------------------

        //4 Verify all web elements are displayed
        System.out.println("homeLink_ex1.isDisplayed() = " + homeLink_ex1.isDisplayed());
        System.out.println("header1.isDisplayed() = " + header1.isDisplayed());
        System.out.println("emailLabel1.isDisplayed() = " + emailLabel1.isDisplayed());
        System.out.println("emailBox1.isDisplayed() = " + emailBox1.isDisplayed());
        System.out.println("retPassButton1.isDisplayed() = " + retPassButton1.isDisplayed());
        System.out.println("cydeoText1.isDisplayed() = " + cydeoText1.isDisplayed());


        driver.close();


    }

}

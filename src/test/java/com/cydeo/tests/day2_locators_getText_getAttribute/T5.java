package com.cydeo.tests.day2_locators_getText_getAttribute;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class T5 {
    public static void main(String[] args) throws InterruptedException {

       // TC #5: getText() and getAttribute() method practice
        //1- Open a chrome browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        // 2- Go to: https://practice.cydeo.com/registration_form
        driver.get("https://practice.cydeo.com/registration_form");
       Thread.sleep(2000);

        // 3- Verify header text is as expected:
       // Expected: Registration form
        WebElement header  = driver.findElement(By.tagName("h2"));
        String expectedHeader = "Registration form";
        String actualHeader = header.getText();//-> this will be return me the text of the header

        if (actualHeader.equals(expectedHeader)){
            System.out.println("Passed!!!");
        }else {
            System.out.println("Fail!!!");
        }

        Thread.sleep(2000);

        //4- Locate “First name” input box
        WebElement firstNameInput = driver.findElement(By.className("form-control"));

        // 5- Verify placeholder attribute’s value is as expected:
       // Expected: first name
        String expectedPlaceHolder = "first name";
        String actualPlaceHolder = firstNameInput.getAttribute("placeholder");

        System.out.println("actualPlaceHolder = " + actualPlaceHolder);

        if (actualPlaceHolder.equals(expectedPlaceHolder)){
            System.out.println("Passed!!!");
        }else {
            System.out.println("Fail!!!");
        }

        Thread.sleep(2000);


        driver.close();
    }

}

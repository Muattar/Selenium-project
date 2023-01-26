package com.cydeo.tests.day3;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class T4_Xpath {

    public static void main(String[] args) throws InterruptedException {

// TC #4: NextBaseCRM, locators, getText(), getAttribute() practice
        //1- Open a chrome browser
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

        //2- Go to: https://login1.nextbasecrm.com/
        driver.get("https://login1.nextbasecrm.com/");

        //3- Verify “Log in” button text is as expected:
        //Expected: Log In
        String expectedLogInText = "Log in";

        //tagName[@attribute='value']

        //Locating logInButton using xpath using type attribute value
        //WebElement logInButton = driver.findElement(By.xpath("//input[@type='submit']"));
       // WebElement logInButton = driver.findElement(By.xpath("//input[@value='Log In']"));
        WebElement logInButton = driver.findElement(By.xpath("//input[@class='login-btn']"));



        String actualLogInText = logInButton.getAttribute("value");

        if (actualLogInText.equals(expectedLogInText)) {
            System.out.println("Log in button text verification PASS!!!");
        }else {
            System.out.println("Log in button text verification FAIL!!!");
        }

        //PS: Inspect and decide which locator you should be using to locate web
        // elements.
        // PS2: Pay attention to where to get the text of this button from

        driver.close();

    }
}

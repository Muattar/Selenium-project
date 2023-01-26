package com.cydeo.tests.day3;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class T1_getText_Practice {
    public static void main(String[] args) throws InterruptedException {


        //TC #1: NextBaseCRM, locators and getText() practice
        //1- Open a chrome browser
       // WebDriverManager.chromedriver().setup();
        //WebDriver driver = new ChromeDriver();

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

        //2- Go to: https://login1.nextbasecrm.com
        driver.get("https://login1.nextbasecrm.com");

        Thread.sleep(2000);


        //3- Enter incorrect username: “incorrect”
        WebElement usernameInput = driver.findElement(By.className("login-inp"));
        usernameInput.sendKeys("incorrect");

        Thread.sleep(2000);


        //4- Enter incorrect password: “incorrect”
        WebElement passwordInput = driver.findElement(By.name("USER_PASSWORD"));
        passwordInput.sendKeys("incorrect");

        Thread.sleep(2000);


        //5- Click to login button.
        WebElement logInButton = driver.findElement(By.className("login-btn"));
        logInButton.click();

        Thread.sleep(2000);

        //6- Verify error message text is as expected:
        //Expected: Incorrect login or password
        String expectedErrorText = "Incorrect login or password";
        String actualErrorText = driver.findElement(By.className("errortext")).getText();

        if (actualErrorText.equals(expectedErrorText)){
            System.out.println("Error Text verification PASSED!!!");
        }else{
            System.out.println("Error Text verification FAIL!!!");
        }

        //PS: Inspect and decide which locator you should


        driver.close();

    }


}

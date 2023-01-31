package com.cydeo.tests.saturdayReview.week2;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class RegistrationForm {


    // TC#1: Registration Form Page Testing
    // 1. Open Chrome browser
    // 2. Go to https://practice.cydeo.com/registration_form
    // 3. Verify title is as expected:
    // Expected: "Registration Form"

    // TC#2: Registration Form Page Filling Form Test
    // 1. Open Chrome browser
    // 2. Go to https://practice.cydeo.com/registration_form
    // 3. Enter First name: "John"
    // 4. Enter Last name: "Smith"
    // 5. Enter Username: "johnsmith123"
    // 6. Enter Email address: "john.smith@email.com"
    // 7. Enter password: "John1234"
    // 8. Enter Phone number: "123-456-7890"
    // 9. Click to "Male" from Gender
    // 10. Enter Date of birth "01/28/1990"
    // 11. Select "Department of Engineering" from Department/Office dropdown
    // 12. Select "SDET" from Job title dropdown
    // 13. Click to "Java" from languages
    // 14. Click to "Sign up" button
    // 15. Verify text displayed on page
    // Expected: "Well done!"
    WebDriver driver;

    @BeforeMethod
    public void setUpMethod(){

        // TC#1: Registration Form Page Testing
        // 1. Open Chrome browser
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // 2. Go to https://practice.cydeo.com/registration_form
        driver.get("https://practice.cydeo.com/registration_form");

    }

    @Test(priority = 1) //with "@Test" it helps us for make test runnable
    public void registration_form_page_test() throws InterruptedException {

        // 3. Verify title is as expected:
        // Expected: "Registration Form"

        Thread.sleep(2000);

        String expectedTitle = "Registration Form";
        String actualTitle = driver.getTitle();

        Assert.assertEquals(actualTitle,expectedTitle, "Title verification is Failed!");

    }

    @Test (priority = 2)
    public void registration_form_page_filling_test(){

        // TC#2: Registration Form Page Filling Form Test
        // 1. Open Chrome browser
        // 2. Go to https://practice.cydeo.com/registration_form

        // 3. Enter First name: "John"
        WebElement firstNameBox = driver.findElement(By.name("firstname"));
        firstNameBox.sendKeys("John");

        // 4. Enter Last name: "Smith"
        WebElement secondNameBox = driver.findElement(By.xpath("//input[@name='lastname']"));
        secondNameBox.sendKeys("Smith");

        // 5. Enter Username: "johnsmith123"
        WebElement userBox = driver.findElement(By.name("username"));
        userBox.sendKeys("johnsmith123");

        // 6. Enter Email address: "john.smith@email.com"
        WebElement emailBox = driver.findElement(By.name("email"));
        emailBox.sendKeys("john.smith@email.com");

        // 7. Enter password: "John1234"
        WebElement passwordBox = driver.findElement(By.name("password"));
        passwordBox.sendKeys("John1234");

        // 8. Enter Phone number: "123-456-7890"
        WebElement phoneBox = driver.findElement(By.xpath("//input[@name='phone']"));
        phoneBox.sendKeys("123-456-7890");

        // 9. Click to "Male" from Gender
        WebElement maleRadioButton = driver.findElement(By.cssSelector("input[value='male']"));
        maleRadioButton.click();

        //Assert.assertTrue(maleRadioButton.isSelected());

        List<WebElement> genders = driver.findElements(By.xpath("//input[@type='radio']"));
        for (WebElement eachGender : genders) {

            if (eachGender.getAttribute("value").equals("male")){
                eachGender.click();
                break;
            }
        }

        // 10. Enter Date of birth "01/28/1990"
        WebElement dateBirthBox = driver.findElement(By.name("birthday"));
        dateBirthBox.sendKeys("01/28/1990");


        // 11. Select "Department of Engineering" from Department/Office dropdown
        Select selectDepartment = new Select(driver.findElement(By.name("department")));
       //selectDepartment.selectByVisibleText("Department of Engineering");
       //selectDepartment.selectByValue("DE");
       selectDepartment.selectByIndex(1);

        // WebElement departmentBox = driver.findElement(By.name("department"));
       // departmentBox.click();


        // 12. Select "SDET" from Job title dropdown
        Select selectJobTitle = new Select(driver.findElement(By.name("job_title")));
        selectJobTitle.selectByVisibleText("SDET");
       // selectJob.selectByIndex(4);


        // 13. Click to "Java" from languages
        driver.findElement(By.id("inlineCheckbox2")).click();


        // 14. Click to "Sign up" button
        driver.findElement(By.xpath("//button[@class='btn btn-primary']")).click();


        // 15. Verify text displayed on page
        //  Expected: "Well done!"
        WebElement textResult = driver.findElement(By.xpath("//h4[@class='alert-heading']"));
        String expectedResult = "Well done!";
        String actualResult = textResult.getText();

        Assert.assertEquals(actualResult,expectedResult, "Text is FAIL!!!");

        driver.findElement(By.id("username"));
        driver.findElement(By.id("username")).getAttribute("class");

    }
         @AfterMethod
        public void tearDown(){
        driver.quit();

    }

 }

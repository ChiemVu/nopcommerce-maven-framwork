package com.nopcommerce;

import com.aventstack.extentreports.Status;
import commons.BaseTest;
import commons.PageGeneratorManager;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObject.HomePageObject;
import pageObject.RegisterPageObject;
import reportConfig.ExtentTestManager;

import java.lang.reflect.Method;

public class Nopcommerce_001_Register extends BaseTest {
    private WebDriver driver;
    private String firstName, lastName, emailAddress, password, gender, day, month, year;

    @Parameters({"browser", "url"})
    @BeforeClass
    public void beforeClass(String browserName, String appUrl) {
        driver = getBrowserDriver(browserName, appUrl);
        homePage = PageGeneratorManager.getHomePage(driver);

        gender = "Male";
        firstName = "Vu";
        lastName = "Chiem";
        day = "10";
        month = "June";
        year = "1989";
        emailAddress = "vtc" + generateFakeNumber() + "@gmail.com";
        password = "123456";
    }

    @Test
    public void Register_01_Empty_Data(Method method) {
        ExtentTestManager.startTest(method.getName(), "Register_01_Empty_Data"); //start TC
        ExtentTestManager.getTest().log(Status.INFO, "Register - Step 01: Navigate to 'Register' page"); //add log
        registerPage = homePage.openRegisterPage();

        ExtentTestManager.getTest().log(Status.INFO, "Register - Step 02: Click to 'Login' button");
        registerPage.clickToLoginButton();

        ExtentTestManager.getTest().log(Status.INFO, "Register - Step 03: Verify FirstName error message deplayed");
        Assert.assertEquals(registerPage.getFirstNameErrorMessage(), "First name is required.");

        ExtentTestManager.getTest().log(Status.INFO, "Register - Step 03: Verify LastName error message deplayed");
        Assert.assertEquals(registerPage.getLastNameErrorMessage(), "Last name is required.");

        ExtentTestManager.getTest().log(Status.INFO, "Register - Step 03: Verify Email Address error message deplayed");
        Assert.assertEquals(registerPage.getEmailErrorMessage(), "Email is required.");

        ExtentTestManager.getTest().log(Status.INFO, "Register - Step 03: Verify Password error message deplayed");
        Assert.assertEquals(registerPage.getPasswordErrorMessage(), "Password is required.");

        ExtentTestManager.getTest().log(Status.INFO, "Register - Step 03: Verify Confirm Password error message deplayed");
        Assert.assertEquals(registerPage.getConfirmPasswordErrorMessage(), "Password is required.");
    }

    @Test
    public void Register_02_Invalid_Email() {

    }

    @Test
    public void Register_03_Password_Less_Than_6_Chars() {

    }

    @Test
    public void Register_04_Invalid_Confirm_Password() {

    }

    @Test
    public void Register_05_Success() {

    }

    @Test
    public void Register_06_Existing_Email() {

    }

    @AfterClass(alwaysRun = true)
    public void afterClass() {
        closeBrowserDriver();
    }

    private HomePageObject homePage;
    private RegisterPageObject registerPage;

}

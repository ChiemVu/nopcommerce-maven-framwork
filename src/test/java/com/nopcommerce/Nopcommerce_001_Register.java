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
    private String firstName, lastName, password, gender, day, month, year;
    String registerPageUrl;

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
        //emailAddress = "vtc" + generateFakeNumber() + "@gmail.com";
        password = "123456";
    }

    @Test
    public void Register_01_Empty_Data(Method method) {
        ExtentTestManager.startTest(method.getName(), "Register_01_Empty_Data"); //start TC
        ExtentTestManager.getTest().log(Status.INFO, "Register - Step 01: Navigate to 'Register' page"); //add log
        registerPage = homePage.openRegisterPage();
        registerPageUrl = registerPage.getCurrentPageUrl(driver);

        ExtentTestManager.getTest().log(Status.INFO, "Register - Step 02: Click to 'Login' button");
        registerPage.clickToLoginButton();

        ExtentTestManager.getTest().log(Status.INFO, "Register - Step 03: Verify FirstName error message deplayed");
        Assert.assertEquals(registerPage.getFirstNameErrorMessage(), "First name is required.");

        ExtentTestManager.getTest().log(Status.INFO, "Register - Step 04: Verify LastName error message deplayed");
        Assert.assertEquals(registerPage.getLastNameErrorMessage(), "Last name is required.");

        ExtentTestManager.getTest().log(Status.INFO, "Register - Step 05: Verify Email Address error message deplayed");
        Assert.assertEquals(registerPage.getEmailErrorMessage(), "Email is required.");

        ExtentTestManager.getTest().log(Status.INFO, "Register - Step 06: Verify Password error message deplayed");
        Assert.assertEquals(registerPage.getPasswordErrorMessage(), "Password is required.");

        ExtentTestManager.getTest().log(Status.INFO, "Register - Step 07: Verify Confirm Password error message deplayed");
        Assert.assertEquals(registerPage.getConfirmPasswordErrorMessage(), "Password is required.");
    }

    @Test
    public void Register_02_Invalid_Email(Method method) {
        ExtentTestManager.startTest(method.getName(), "Register_02_Invalid_Email"); //start TC
        ExtentTestManager.getTest().log(Status.INFO, "Register - Step 01: Open to 'Register' page"); //add log
        registerPage = registerPage.openRegisterPageUrl(registerPageUrl);

        ExtentTestManager.getTest().log(Status.INFO, "Register - Step 2: Select Gender radio button with value is" + gender);
        registerPage.clickToGenderRadioBuntton(gender);

        ExtentTestManager.getTest().log(Status.INFO, "Register - Step 3: Input Firstname with value is" + firstName);
        registerPage.inputToFirstNameTextbox(firstName);

        ExtentTestManager.getTest().log(Status.INFO, "Register - Step 4: Input Lastname with value is" + lastName);
        registerPage.inputToLastNameTextbox(lastName);

        ExtentTestManager.getTest().log(Status.INFO, "Register - Step 5: Select to Date of Birth Day dropdown with value is" + day);
        registerPage.selectToDropdownByName(driver, "DateOfBirthDay", day);

        ExtentTestManager.getTest().log(Status.INFO, "Register - Step 6: Select to Date of Birth Month dropdown with value is" + month);
        registerPage.selectToDropdownByName(driver, "DateOfBirthMonth", month);

        ExtentTestManager.getTest().log(Status.INFO, "Register - Step 7: Select to Date of Birth Year dropdown with value is" + year);
        registerPage.selectToDropdownByName(driver, "DateOfBirthYear", year);

        ExtentTestManager.getTest().log(Status.INFO, "Register - Step 8: Input invalid email");
        registerPage.inputEmailTextbox("#143@gmail@");

        ExtentTestManager.getTest().log(Status.INFO, "Register - Step 9: Click To Newsletter checkbox");
        registerPage.clickToNewsletterCheckbox();

        ExtentTestManager.getTest().log(Status.INFO, "Register - Step 10: Input Password with value is" + password);
        registerPage.inputPasswordTextbox(password);

        ExtentTestManager.getTest().log(Status.INFO, "Register - Step 11: Input Confirm Password with value is" + password);
        registerPage.inputConfirmPasswordTextbox(password);

        ExtentTestManager.getTest().log(Status.INFO, "Register - Step 12: Click to 'Login' button");
        registerPage.clickToLoginButton();

        ExtentTestManager.getTest().log(Status.INFO, "Register - Step 13: Verify Email error message deplayed");
        Assert.assertEquals(registerPage.getEmailErrorMessage(), "Wrong email");

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

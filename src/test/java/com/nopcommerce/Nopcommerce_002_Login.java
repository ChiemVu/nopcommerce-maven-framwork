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
import pageObject.LoginPageObject;
import pageObject.RegisterPageObject;
import reportConfig.ExtentTestManager;

import java.lang.reflect.Method;

public class Nopcommerce_002_Login extends BaseTest {
    private WebDriver driver;
    private String firstName, lastName, password, invalidPassword, emailAddress, gender, day, month, year;
    String loginPageUrl, invalidEmail, notFoundEmail;

    @Parameters({"browser", "url"})
    @BeforeClass
    public void beforeClass(String browserName, String appUrl) {
        driver = getBrowserDriver(browserName, appUrl);
        homePage = PageGeneratorManager.getHomePage(driver);
        registerPage = homePage.openRegisterPage();

        gender = "Male";
        firstName = "Vu";
        lastName = "Chiem";
        day = "10";
        month = "June";
        year = "1989";
        emailAddress = "vtc" + generateFakeNumber() + "@gmail.com";
        invalidEmail = "vtc@#gmail.com";
        notFoundEmail = "123@gmail.com";
        password = "123456";
        invalidPassword = "12sfgdsfgf3";

        registerPage.clickToGenderRadioBuntton(gender);
        registerPage.inputToFirstNameTextbox(firstName);
        registerPage.inputToLastNameTextbox(lastName);
        registerPage.selectToDropdownByName(driver, "DateOfBirthDay", day);
        registerPage.selectToDropdownByName(driver, "DateOfBirthMonth", month);
        registerPage.selectToDropdownByName(driver, "DateOfBirthYear", year);
        registerPage.inputEmailTextbox(emailAddress);
        registerPage.clickToNewsletterCheckbox();
        registerPage.inputPasswordTextbox(password);
        registerPage.inputConfirmPasswordTextbox(password);
        registerPage.clickToLoginButton();
        Assert.assertEquals(registerPage.getRegisterSuccessMesage(), "Your registration completed");
        loginPage = registerPage.openLoginPage();
        loginPageUrl = loginPage.getCurrentPageUrl(driver);

    }

    @Test
    public void Login_01_Empty_Data(Method method) {
        ExtentTestManager.startTest(method.getName(), "Login_01_Empty_Data"); //start TC
        ExtentTestManager.getTest().log(Status.INFO, "Login - Step 01: Click to 'Login' button");
        loginPage.clickToLoginButton();

        ExtentTestManager.getTest().log(Status.INFO, "Login - Step 02: Verify Email error message deplayed");
        Assert.assertEquals(loginPage.getEmailErrorMessage(), "Please enter your email");

    }

    @Test
    public void Login_02_Invalid_Email(Method method) {
        ExtentTestManager.startTest(method.getName(), "Login_02_Invalid_Email"); //start TC
        ExtentTestManager.getTest().log(Status.INFO, "Login - Step 01: Open 'Login' page");
        loginPage = loginPage.openLoginPageUrl(loginPageUrl);

        ExtentTestManager.getTest().log(Status.INFO, "Login - Step 02: Input to Email textbox with value is" + invalidEmail);
        loginPage.inputToEmailTextbox(invalidEmail);

        ExtentTestManager.getTest().log(Status.INFO, "Login - Step 03: Input to Password textbox with value is" + password);
        loginPage.inputToPasswordTextbox(password);

        ExtentTestManager.getTest().log(Status.INFO, "Login - Step 04: Click to 'Login' button");
        loginPage.clickToLoginButton();

        ExtentTestManager.getTest().log(Status.INFO, "Login - Step 05: Verify Email error message deplayed");
        Assert.assertEquals(loginPage.getEmailErrorMessage(), "Wrong email");

    }

    @Test
    public void Login_03_Not_Found_Email(Method method) {
        ExtentTestManager.startTest(method.getName(), "Login_03_Not_Found_Email"); //start TC
        ExtentTestManager.getTest().log(Status.INFO, "Login - Step 01: Open 'Login' page");
        loginPage = loginPage.openLoginPageUrl(loginPageUrl);

        ExtentTestManager.getTest().log(Status.INFO, "Login - Step 02: Input to Email textbox with value is" + notFoundEmail);
        loginPage.inputToEmailTextbox(notFoundEmail);

        ExtentTestManager.getTest().log(Status.INFO, "Login - Step 03: Input to Password textbox with value is" + password);
        loginPage.inputToPasswordTextbox(password);

        ExtentTestManager.getTest().log(Status.INFO, "Login - Step 04: Click to 'Login' button");
        loginPage.clickToLoginButton();

        ExtentTestManager.getTest().log(Status.INFO, "Login - Step 05: Verify error message deplayed");
        Assert.assertEquals(loginPage.getEmailUnsuccessfullMessage(), "Login was unsuccessful. Please correct the errors and try again.\nNo customer account found");
    }

    @Test
    public void Login_04_Existing_Email_And_Password_Blank(Method method) {
        ExtentTestManager.startTest(method.getName(), "Login_04_Existing_Email_And_Password_Blank"); //start TC
        ExtentTestManager.getTest().log(Status.INFO, "Login - Step 01: Open 'Login' page");
        loginPage = loginPage.openLoginPageUrl(loginPageUrl);

        ExtentTestManager.getTest().log(Status.INFO, "Login - Step 02: Input to Email textbox with value is" + emailAddress);
        loginPage.inputToEmailTextbox(emailAddress);

        ExtentTestManager.getTest().log(Status.INFO, "Login - Step 03: Click to 'Login' button");
        loginPage.clickToLoginButton();

        ExtentTestManager.getTest().log(Status.INFO, "Login - Step 04: Verify error message deplayed");
        Assert.assertEquals(loginPage.getEmailUnsuccessfullMessage(), "Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect");

    }

    @Test
    public void Login_05_Existing_Email_And_Password_Incorrect(Method method) {
        ExtentTestManager.startTest(method.getName(), "Login_05_Existing_Email_And_Password_Incorrect"); //start TC
        ExtentTestManager.getTest().log(Status.INFO, "Login - Step 01: Open 'Login' page");
        loginPage = loginPage.openLoginPageUrl(loginPageUrl);

        ExtentTestManager.getTest().log(Status.INFO, "Login - Step 02: Input to Email textbox with value is" + emailAddress);
        loginPage.inputToEmailTextbox(emailAddress);

        ExtentTestManager.getTest().log(Status.INFO, "Login - Step 03: Input to Password textbox with value is" + invalidPassword);
        loginPage.inputToPasswordTextbox(invalidPassword);

        ExtentTestManager.getTest().log(Status.INFO, "Login - Step 04: Click to 'Login' button");
        loginPage.clickToLoginButton();

        ExtentTestManager.getTest().log(Status.INFO, "Login - Step 05: Verify error message deplayed");
        Assert.assertEquals(loginPage.getEmailUnsuccessfullMessage(), "Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect");
    }

    @Test
    public void Login_06_Email_Password_valid(Method method) {
        ExtentTestManager.startTest(method.getName(), "Login_06_Email_Password_valid"); //start TC
        ExtentTestManager.getTest().log(Status.INFO, "Login - Step 01: Open 'Login' page");
        loginPage = loginPage.openLoginPageUrl(loginPageUrl);

        ExtentTestManager.getTest().log(Status.INFO, "Login - Step 02: Input to Email textbox with value is" + emailAddress);
        loginPage.inputToEmailTextbox(emailAddress);

        ExtentTestManager.getTest().log(Status.INFO, "Login - Step 03: Input to Password textbox with value is" + password);
        loginPage.inputToPasswordTextbox(password);

        ExtentTestManager.getTest().log(Status.INFO, "Login - Step 04: Click to 'Login' button");
        homePage = loginPage.clickToLoginButton();

        ExtentTestManager.getTest().log(Status.INFO, "Login - Step 05: Verify My Account link is displayed");
        Assert.assertTrue(homePage.isMyAccountLinkDisplayed());
    }

    @AfterClass(alwaysRun = true)
    public void afterClass() {
        closeBrowserDriver();
    }

    private HomePageObject homePage;
    private RegisterPageObject registerPage;
    private LoginPageObject loginPage;

}

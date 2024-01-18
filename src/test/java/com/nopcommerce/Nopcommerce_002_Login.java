package com.nopcommerce;

import com.aventstack.extentreports.Status;
import com.nopcommerce.data.UserData;
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
    private String password, emailAddress;
    String loginPageUrl;

    @Parameters({"browser", "url"})
    @BeforeClass
    public void beforeClass(String browserName, String appUrl) {
        driver = getBrowserDriver(browserName, appUrl);
        homePage = PageGeneratorManager.getHomePage(driver);
        registerPage = homePage.openRegisterPage();

        emailAddress = UserData.Register.EMAIL_ADDRESS + generateFakeNumber() + "@gmail.com";
        password = UserData.Register.PASSWORD;

        registerPage.clickToGenderRadioBuntton(UserData.Register.GENDER);
        registerPage.inputToFirstNameTextbox(UserData.Register.FIRSTNAME);
        registerPage.inputToLastNameTextbox(UserData.Register.LASTNAME);
        registerPage.selectToDropdownByName("DateOfBirthDay", UserData.Register.DAY);
        registerPage.selectToDropdownByName("DateOfBirthMonth", UserData.Register.MONTH);
        registerPage.selectToDropdownByName("DateOfBirthYear", UserData.Register.YEAR);
        registerPage.inputEmailTextbox(emailAddress);
        registerPage.clickToNewsletterCheckbox();
        registerPage.inputPasswordTextbox(password);
        registerPage.inputConfirmPasswordTextbox(password);
        registerPage.clickToRegisterButton();
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

        ExtentTestManager.getTest().log(Status.INFO, "Login - Step 02: Input to Email textbox with value is" + UserData.Login.LOGIN_INVALID_EMAIL);
        loginPage.inputToEmailTextbox(UserData.Login.LOGIN_INVALID_EMAIL);

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

        ExtentTestManager.getTest().log(Status.INFO, "Login - Step 02: Input to Email textbox with value is" + UserData.Login.LOGIN_NOT_FOUND_EMAIL);
        loginPage.inputToEmailTextbox(UserData.Login.LOGIN_NOT_FOUND_EMAIL);

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

        ExtentTestManager.getTest().log(Status.INFO, "Login - Step 03: Input to Password textbox with value is" + UserData.Login.LOGIN_INVALID_PASSWORD);
        loginPage.inputToPasswordTextbox(UserData.Login.LOGIN_INVALID_PASSWORD);

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

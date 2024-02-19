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
import pageObject.user.HomePageObject;
import pageObject.user.RegisterPageObject;
import reportConfig.ExtentTestManager;

import java.lang.reflect.Method;

public class Nopcommerce_001_Register extends BaseTest {
    private WebDriver driver;
    private String emailAddress;
    String registerPageUrl;

    @Parameters({"browser", "userUrl"})
    @BeforeClass
    public void beforeClass(String browserName, String userUrl) {
        driver = getBrowserDriver(browserName, userUrl);
        homePage = PageGeneratorManager.getHomePage(driver);
        registerPage = homePage.openRegisterPage();
        registerPageUrl = registerPage.getCurrentPageUrl(driver);

        emailAddress = "vtc" + generateFakeNumber() + "@gmail.com";
    }

    @Test
    public void Register_01_Empty_Data(Method method) {
        ExtentTestManager.startTest(method.getName(), "Register_01_Empty_Data"); //start TC

        ExtentTestManager.getTest().log(Status.INFO, "Register - Step 01: Click to 'Login' button");
        registerPage.clickToRegisterButton();

        ExtentTestManager.getTest().log(Status.INFO, "Register - Step 02: Verify FirstName error message deplayed");
        Assert.assertEquals(registerPage.getFirstNameErrorMessage(), "First name is required.");

        ExtentTestManager.getTest().log(Status.INFO, "Register - Step 03: Verify LastName error message deplayed");
        Assert.assertEquals(registerPage.getLastNameErrorMessage(), "Last name is required.");

        ExtentTestManager.getTest().log(Status.INFO, "Register - Step 04: Verify Email Address error message deplayed");
        Assert.assertEquals(registerPage.getEmailErrorMessage(), "Email is required.");

        ExtentTestManager.getTest().log(Status.INFO, "Register - Step 05: Verify Password error message deplayed");
        Assert.assertEquals(registerPage.getPasswordErrorMessage(), "Password is required.");

        ExtentTestManager.getTest().log(Status.INFO, "Register - Step 06: Verify Confirm Password error message deplayed");
        Assert.assertEquals(registerPage.getConfirmPasswordErrorMessage(), "Password is required.");
    }

    @Test
    public void Register_02_Invalid_Email(Method method) {
        ExtentTestManager.startTest(method.getName(), "Register_02_Invalid_Email"); //start TC
        ExtentTestManager.getTest().log(Status.INFO, "Register - Step 01: Open to 'Register' page"); //add log
        registerPage = registerPage.openRegisterPageUrl(registerPageUrl);

        ExtentTestManager.getTest().log(Status.INFO, "Register - Step 2: Select Gender radio button with value is" + UserData.Register.GENDER);
        registerPage.clickToGenderRadioBuntton(UserData.Register.GENDER);

        ExtentTestManager.getTest().log(Status.INFO, "Register - Step 3: Input Firstname with value is" + UserData.Register.FIRSTNAME);
        registerPage.inputToFirstNameTextbox(UserData.Register.FIRSTNAME);

        ExtentTestManager.getTest().log(Status.INFO, "Register - Step 4: Input Lastname with value is" + UserData.Register.LASTNAME);
        registerPage.inputToLastNameTextbox(UserData.Register.LASTNAME);

        ExtentTestManager.getTest().log(Status.INFO, "Register - Step 5: Select to Date of Birth Day dropdown with value is" + UserData.Register.DAY);
        registerPage.selectToDropdownByName("DateOfBirthDay", UserData.Register.DAY);

        ExtentTestManager.getTest().log(Status.INFO, "Register - Step 6: Select to Date of Birth Month dropdown with value is" + UserData.Register.MONTH);
        registerPage.selectToDropdownByName("DateOfBirthMonth", UserData.Register.MONTH);

        ExtentTestManager.getTest().log(Status.INFO, "Register - Step 7: Select to Date of Birth Year dropdown with value is" + UserData.Register.YEAR);
        registerPage.selectToDropdownByName("DateOfBirthYear", UserData.Register.YEAR);

        ExtentTestManager.getTest().log(Status.INFO, "Register - Step 8: Input invalid email with value is" + UserData.Register.REGISTER_INVALID_EMAIL);
        registerPage.inputEmailTextbox(UserData.Register.REGISTER_INVALID_EMAIL);

        ExtentTestManager.getTest().log(Status.INFO, "Register - Step 9: Click To Newsletter checkbox");
        registerPage.clickToNewsletterCheckbox();

        ExtentTestManager.getTest().log(Status.INFO, "Register - Step 10: Input Password with value is" + UserData.Register.PASSWORD);
        registerPage.inputPasswordTextbox(UserData.Register.PASSWORD);

        ExtentTestManager.getTest().log(Status.INFO, "Register - Step 11: Input Confirm Password with value is" + UserData.Register.PASSWORD);
        registerPage.inputConfirmPasswordTextbox(UserData.Register.PASSWORD);

        ExtentTestManager.getTest().log(Status.INFO, "Register - Step 12: Click to 'Login' button");
        registerPage.clickToRegisterButton();

        ExtentTestManager.getTest().log(Status.INFO, "Register - Step 13: Verify Email error message deplayed");
        Assert.assertEquals(registerPage.getEmailErrorMessage(), "Wrong email");

    }

    @Test
    public void Register_03_Password_Less_Than_6_Chars(Method method) {
        ExtentTestManager.startTest(method.getName(), "Register_03_Password_Less_Than_6_Chars"); //start TC
        ExtentTestManager.getTest().log(Status.INFO, "Register - Step 01: Open to 'Register' page"); //add log
        registerPage = registerPage.openRegisterPageUrl(registerPageUrl);

        ExtentTestManager.getTest().log(Status.INFO, "Register - Step 2: Select Gender radio button with value is" + UserData.Register.GENDER);
        registerPage.clickToGenderRadioBuntton(UserData.Register.GENDER);

        ExtentTestManager.getTest().log(Status.INFO, "Register - Step 3: Input Firstname with value is" + UserData.Register.FIRSTNAME);
        registerPage.inputToFirstNameTextbox(UserData.Register.FIRSTNAME);

        ExtentTestManager.getTest().log(Status.INFO, "Register - Step 4: Input Lastname with value is" + UserData.Register.LASTNAME);
        registerPage.inputToLastNameTextbox(UserData.Register.LASTNAME);

        ExtentTestManager.getTest().log(Status.INFO, "Register - Step 5: Select to Date of Birth Day dropdown with value is" + UserData.Register.DAY);
        registerPage.selectToDropdownByName("DateOfBirthDay", UserData.Register.DAY);

        ExtentTestManager.getTest().log(Status.INFO, "Register - Step 6: Select to Date of Birth Month dropdown with value is" + UserData.Register.MONTH);
        registerPage.selectToDropdownByName("DateOfBirthMonth", UserData.Register.MONTH);

        ExtentTestManager.getTest().log(Status.INFO, "Register - Step 7: Select to Date of Birth Year dropdown with value is" + UserData.Register.YEAR);
        registerPage.selectToDropdownByName("DateOfBirthYear", UserData.Register.YEAR);

        ExtentTestManager.getTest().log(Status.INFO, "Register - Step 8: Input invalid email" + emailAddress);
        registerPage.inputEmailTextbox(emailAddress);

        ExtentTestManager.getTest().log(Status.INFO, "Register - Step 9: Click To Newsletter checkbox");
        registerPage.clickToNewsletterCheckbox();

        ExtentTestManager.getTest().log(Status.INFO, "Register - Step 10: Input Invalid Password with value is 123");
        registerPage.inputPasswordTextbox("123");

        ExtentTestManager.getTest().log(Status.INFO, "Register - Step 11: Input Confirm Password with value is 123");
        registerPage.inputConfirmPasswordTextbox("123");

        ExtentTestManager.getTest().log(Status.INFO, "Register - Step 12: Click to 'Login' button");
        registerPage.clickToRegisterButton();

        ExtentTestManager.getTest().log(Status.INFO, "Register - Step 13: Verify password error message deplayed");
        Assert.assertEquals(registerPage.getPasswordErrorMessage(), "Password must meet the following rules:\nmust have at least 6 characters");
    }

    @Test
    public void Register_04_Invalid_Confirm_Password(Method method) {
        ExtentTestManager.startTest(method.getName(), "Register_04_Invalid_Confirm_Password"); //start TC
        ExtentTestManager.getTest().log(Status.INFO, "Register - Step 01: Open to 'Register' page"); //add log
        registerPage = registerPage.openRegisterPageUrl(registerPageUrl);

        ExtentTestManager.getTest().log(Status.INFO, "Register - Step 2: Select Gender radio button with value is" + UserData.Register.GENDER);
        registerPage.clickToGenderRadioBuntton(UserData.Register.GENDER);

        ExtentTestManager.getTest().log(Status.INFO, "Register - Step 3: Input Firstname with value is" + UserData.Register.FIRSTNAME);
        registerPage.inputToFirstNameTextbox(UserData.Register.FIRSTNAME);

        ExtentTestManager.getTest().log(Status.INFO, "Register - Step 4: Input Lastname with value is" + UserData.Register.LASTNAME);
        registerPage.inputToLastNameTextbox(UserData.Register.LASTNAME);

        ExtentTestManager.getTest().log(Status.INFO, "Register - Step 5: Select to Date of Birth Day dropdown with value is" + UserData.Register.DAY);
        registerPage.selectToDropdownByName("DateOfBirthDay", UserData.Register.DAY);

        ExtentTestManager.getTest().log(Status.INFO, "Register - Step 6: Select to Date of Birth Month dropdown with value is" + UserData.Register.MONTH);
        registerPage.selectToDropdownByName("DateOfBirthMonth", UserData.Register.MONTH);

        ExtentTestManager.getTest().log(Status.INFO, "Register - Step 7: Select to Date of Birth Year dropdown with value is" + UserData.Register.YEAR);
        registerPage.selectToDropdownByName("DateOfBirthYear", UserData.Register.YEAR);

        ExtentTestManager.getTest().log(Status.INFO, "Register - Step 8: Input invalid email" + emailAddress);
        registerPage.inputEmailTextbox(emailAddress);

        ExtentTestManager.getTest().log(Status.INFO, "Register - Step 9: Click To Newsletter checkbox");
        registerPage.clickToNewsletterCheckbox();

        ExtentTestManager.getTest().log(Status.INFO, "Register - Step 10: Input Password with value is" + UserData.Register.PASSWORD);
        registerPage.inputPasswordTextbox(UserData.Register.PASSWORD);

        ExtentTestManager.getTest().log(Status.INFO, "Register - Step 11: Input Confirm Password with value is" + UserData.Register.REGISTER_INVALID_PASSWORD);
        registerPage.inputConfirmPasswordTextbox(UserData.Register.REGISTER_INVALID_PASSWORD);

        ExtentTestManager.getTest().log(Status.INFO, "Register - Step 12: Click to 'Login' button");
        registerPage.clickToRegisterButton();

        ExtentTestManager.getTest().log(Status.INFO, "Register - Step 13: Verify confirm password error message deplayed");
        Assert.assertEquals(registerPage.getConfirmPasswordErrorMessage(), "The password and confirmation password do not match.");
    }

    @Test
    public void Register_05_Success(Method method) {
        ExtentTestManager.startTest(method.getName(), "Register_05_Success"); //start TC
        ExtentTestManager.getTest().log(Status.INFO, "Register - Step 01: Open to 'Register' page"); //add log
        registerPage = registerPage.openRegisterPageUrl(registerPageUrl);

        ExtentTestManager.getTest().log(Status.INFO, "Register - Step 2: Select Gender radio button with value is" + UserData.Register.GENDER);
        registerPage.clickToGenderRadioBuntton(UserData.Register.GENDER);

        ExtentTestManager.getTest().log(Status.INFO, "Register - Step 3: Input Firstname with value is" + UserData.Register.FIRSTNAME);
        registerPage.inputToFirstNameTextbox(UserData.Register.FIRSTNAME);

        ExtentTestManager.getTest().log(Status.INFO, "Register - Step 4: Input Lastname with value is" + UserData.Register.LASTNAME);
        registerPage.inputToLastNameTextbox(UserData.Register.LASTNAME);

        ExtentTestManager.getTest().log(Status.INFO, "Register - Step 5: Select to Date of Birth Day dropdown with value is" + UserData.Register.DAY);
        registerPage.selectToDropdownByName("DateOfBirthDay", UserData.Register.DAY);

        ExtentTestManager.getTest().log(Status.INFO, "Register - Step 6: Select to Date of Birth Month dropdown with value is" + UserData.Register.MONTH);
        registerPage.selectToDropdownByName("DateOfBirthMonth", UserData.Register.MONTH);

        ExtentTestManager.getTest().log(Status.INFO, "Register - Step 7: Select to Date of Birth Year dropdown with value is" + UserData.Register.YEAR);
        registerPage.selectToDropdownByName("DateOfBirthYear", UserData.Register.YEAR);

        ExtentTestManager.getTest().log(Status.INFO, "Register - Step 8: Input invalid email" + emailAddress);
        registerPage.inputEmailTextbox(emailAddress);

        ExtentTestManager.getTest().log(Status.INFO, "Register - Step 9: Click To Newsletter checkbox");
        registerPage.clickToNewsletterCheckbox();

        ExtentTestManager.getTest().log(Status.INFO, "Register - Step 10: Input Password with value is" + UserData.Register.PASSWORD);
        registerPage.inputPasswordTextbox(UserData.Register.PASSWORD);

        ExtentTestManager.getTest().log(Status.INFO, "Register - Step 11: Input Confirm Password with value is" + UserData.Register.PASSWORD);
        registerPage.inputConfirmPasswordTextbox(UserData.Register.PASSWORD);

        ExtentTestManager.getTest().log(Status.INFO, "Register - Step 12: Click to 'Login' button");
        registerPage.clickToRegisterButton();

        ExtentTestManager.getTest().log(Status.INFO, "Register - Step 13: Verify Register success message deplayed");
        Assert.assertEquals(registerPage.getRegisterSuccessMesage(), "Your registration completed");

    }

    @Test
    public void Register_06_Existing_Email(Method method) {
        ExtentTestManager.startTest(method.getName(), "Register_06_Existing_Email"); //start TC
        ExtentTestManager.getTest().log(Status.INFO, "Register - Step 01: Open to 'Register' page"); //add log
        registerPage = registerPage.openRegisterPageUrl(registerPageUrl);

        ExtentTestManager.getTest().log(Status.INFO, "Register - Step 2: Select Gender radio button with value is" + UserData.Register.GENDER);
        registerPage.clickToGenderRadioBuntton(UserData.Register.GENDER);

        ExtentTestManager.getTest().log(Status.INFO, "Register - Step 3: Input Firstname with value is" + UserData.Register.FIRSTNAME);
        registerPage.inputToFirstNameTextbox(UserData.Register.FIRSTNAME);

        ExtentTestManager.getTest().log(Status.INFO, "Register - Step 4: Input Lastname with value is" + UserData.Register.LASTNAME);
        registerPage.inputToLastNameTextbox(UserData.Register.LASTNAME);

        ExtentTestManager.getTest().log(Status.INFO, "Register - Step 5: Select to Date of Birth Day dropdown with value is" + UserData.Register.DAY);
        registerPage.selectToDropdownByName("DateOfBirthDay", UserData.Register.DAY);

        ExtentTestManager.getTest().log(Status.INFO, "Register - Step 6: Select to Date of Birth Month dropdown with value is" + UserData.Register.MONTH);
        registerPage.selectToDropdownByName("DateOfBirthMonth", UserData.Register.MONTH);

        ExtentTestManager.getTest().log(Status.INFO, "Register - Step 7: Select to Date of Birth Year dropdown with value is" + UserData.Register.YEAR);
        registerPage.selectToDropdownByName("DateOfBirthYear", UserData.Register.YEAR);

        ExtentTestManager.getTest().log(Status.INFO, "Register - Step 8: Input invalid email" + emailAddress);
        registerPage.inputEmailTextbox(emailAddress);

        ExtentTestManager.getTest().log(Status.INFO, "Register - Step 9: Click To Newsletter checkbox");
        registerPage.clickToNewsletterCheckbox();

        ExtentTestManager.getTest().log(Status.INFO, "Register - Step 10: Input Password with value is" + UserData.Register.PASSWORD);
        registerPage.inputPasswordTextbox(UserData.Register.PASSWORD);

        ExtentTestManager.getTest().log(Status.INFO, "Register - Step 11: Input Confirm Password with value is" + UserData.Register.PASSWORD);
        registerPage.inputConfirmPasswordTextbox(UserData.Register.PASSWORD);

        ExtentTestManager.getTest().log(Status.INFO, "Register - Step 12: Click to 'Login' button");
        registerPage.clickToRegisterButton();

        ExtentTestManager.getTest().log(Status.INFO, "Register - Step 13: Verify Existing email message deplayed");
        Assert.assertEquals(registerPage.getExistingEmailErrorMessage(), "The specified email already exists");
    }

    @AfterClass(alwaysRun = true)
    public void afterClass() {
        closeBrowserDriver();
    }

    private HomePageObject homePage;
    private RegisterPageObject registerPage;

}

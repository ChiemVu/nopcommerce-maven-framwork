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
import pageObject.CustomerInfoPageObject;
import pageObject.HomePageObject;
import pageObject.LoginPageObject;
import pageObject.RegisterPageObject;
import reportConfig.ExtentTestManager;

import java.lang.reflect.Method;

public class Nopcommerce_003_My_Account extends BaseTest {
    private WebDriver driver;
    private String emailAddress;


    @Parameters({"browser", "url"})
    @BeforeClass
    public void beforeClass(String browserName, String appUrl) {
        driver = getBrowserDriver(browserName, appUrl);
        homePage = PageGeneratorManager.getHomePage(driver);
        registerPage = homePage.openRegisterPage();

        emailAddress = UserData.Register.EMAIL_ADDRESS + generateFakeNumber() + "@gmail.com";

        registerPage.clickToGenderRadioBuntton(UserData.Register.GENDER);
        registerPage.inputToFirstNameTextbox(UserData.Register.FIRSTNAME);
        registerPage.inputToLastNameTextbox(UserData.Register.LASTNAME);
        registerPage.selectToDropdownByName("DateOfBirthDay", UserData.Register.DAY);
        registerPage.selectToDropdownByName("DateOfBirthMonth", UserData.Register.MONTH);
        registerPage.selectToDropdownByName("DateOfBirthYear", UserData.Register.YEAR);
        registerPage.inputEmailTextbox(emailAddress);
        registerPage.clickToNewsletterCheckbox();
        registerPage.inputPasswordTextbox(UserData.Register.PASSWORD);
        registerPage.inputConfirmPasswordTextbox(UserData.Register.PASSWORD);
        registerPage.clickToRegisterButton();
        Assert.assertEquals(registerPage.getRegisterSuccessMesage(), "Your registration completed");
        loginPage = registerPage.openLoginPage();
        loginPage.inputToEmailTextbox(emailAddress);
        loginPage.inputToPasswordTextbox(UserData.Register.PASSWORD);
        homePage = loginPage.clickToLoginButton();
        Assert.assertTrue(homePage.isMyAccountLinkDisplayed());

    }

    @Test
    public void My_Account_01_Customer_Info(Method method) {
        ExtentTestManager.startTest(method.getName(), "My_Account_01_Customer_Info"); //start TC
        ExtentTestManager.getTest().log(Status.INFO, "Customer Info - Step 01: Click to 'My Account' link");
        customerInfoPage = homePage.clickToMyAccountLink();

        ExtentTestManager.getTest().log(Status.INFO, "Customer Info - Step 02: Update Gender value is" + UserData.CustomerInfo.GENDER);
        customerInfoPage.selectToGenderRadioButton(UserData.CustomerInfo.GENDER);

        ExtentTestManager.getTest().log(Status.INFO, "Customer Info - Step 03: Update First Name value is" + UserData.CustomerInfo.FIRSTNAME);
        customerInfoPage.inputToFirtnameTextbox(UserData.CustomerInfo.FIRSTNAME);

        ExtentTestManager.getTest().log(Status.INFO, "Customer Info - Step 04: Update Last Name value is" + UserData.CustomerInfo.LASTNAME);
        customerInfoPage.inputToLastnameTextbox(UserData.CustomerInfo.LASTNAME);

        ExtentTestManager.getTest().log(Status.INFO, "Customer Info - Step 05: Update Day of birth value is" + UserData.CustomerInfo.DAY);
        customerInfoPage.selectDropdownByAttributeName("DateOfBirthDay", UserData.CustomerInfo.DAY);

        ExtentTestManager.getTest().log(Status.INFO, "Customer Info - Step 06: Update Month of birth value is" + UserData.CustomerInfo.MONTH);
        customerInfoPage.selectDropdownByAttributeName("DateOfBirthMonth", UserData.CustomerInfo.MONTH);

        ExtentTestManager.getTest().log(Status.INFO, "Customer Info - Step 07: Update Year of birth value is" + UserData.CustomerInfo.YEAR);
        customerInfoPage.selectDropdownByAttributeName("DateOfBirthYear", UserData.CustomerInfo.YEAR);

        ExtentTestManager.getTest().log(Status.INFO, "Customer Info - Step 08: Update Email value is" + UserData.CustomerInfo.EMAIL_ADDRESS);
        customerInfoPage.inputToEnailTextbox(UserData.CustomerInfo.EMAIL_ADDRESS);

        ExtentTestManager.getTest().log(Status.INFO, "Customer Info - Step 09: Update Company Name value is" + UserData.CustomerInfo.COMPANY_NAME);
        customerInfoPage.inputToCompanyNameTextbox(UserData.CustomerInfo.COMPANY_NAME);

        ExtentTestManager.getTest().log(Status.INFO, "Customer Info - Step 10: Click to Save Button");
        customerInfoPage.clickToSaveButton();

        ExtentTestManager.getTest().log(Status.INFO, "Customer Info - Step 11: Verify update info success message deplayed");
        Assert.assertEquals(customerInfoPage.getCustomerInfoUpdateSuccessMessage(), "The customer info has been updated successfully.");

        ExtentTestManager.getTest().log(Status.INFO, "Customer Info - Step 12: Verify Gender updated is value " + UserData.CustomerInfo.GENDER);
        Assert.assertTrue(customerInfoPage.isGenderRadioButtonIschecked());

        ExtentTestManager.getTest().log(Status.INFO, "Customer Info - Step 13: Verify Firstname updated is value " + UserData.CustomerInfo.FIRSTNAME);
        Assert.assertEquals(customerInfoPage.getFirstNameValue(), UserData.CustomerInfo.FIRSTNAME);

        ExtentTestManager.getTest().log(Status.INFO, "Customer Info - Step 14: Verify Lastname updated is value " + UserData.CustomerInfo.LASTNAME);
        Assert.assertEquals(customerInfoPage.getLastNameValue(), UserData.CustomerInfo.LASTNAME);

        ExtentTestManager.getTest().log(Status.INFO, "Customer Info - Step 15: Verify Date of Birthday updated is value " + UserData.CustomerInfo.DAY);
        Assert.assertEquals(customerInfoPage.getSelectedTextAtDropdownAttributeName("DateOfBirthDay"), UserData.CustomerInfo.DAY);

        ExtentTestManager.getTest().log(Status.INFO, "Customer Info - Step 16: Verify Month of Birthday updated is value " + UserData.CustomerInfo.MONTH);
        Assert.assertEquals(customerInfoPage.getSelectedTextAtDropdownAttributeName("DateOfBirthMonth"), UserData.CustomerInfo.MONTH);

        ExtentTestManager.getTest().log(Status.INFO, "Customer Info - Step 17: Verify Year of Birthday updated is value " + UserData.CustomerInfo.YEAR);
        Assert.assertEquals(customerInfoPage.getSelectedTextAtDropdownAttributeName("DateOfBirthYear"), UserData.CustomerInfo.YEAR);

        ExtentTestManager.getTest().log(Status.INFO, "Customer Info - Step 18: Verify Email updated is value " + UserData.CustomerInfo.EMAIL_ADDRESS);
        Assert.assertEquals(customerInfoPage.getEmailText(), UserData.CustomerInfo.EMAIL_ADDRESS);

        ExtentTestManager.getTest().log(Status.INFO, "Customer Info - Step 19: Verify Company name updated is value " + UserData.CustomerInfo.COMPANY_NAME);
        Assert.assertEquals(customerInfoPage.getCompanyNameText(), UserData.CustomerInfo.COMPANY_NAME);
    }


    @Test
    public void My_Account_02_Addresses(Method method) {


    }

    @Test
    public void My_Account_03_Change_Password(Method method) {

    }

    @Test
    public void My_Account_04_My_Product_Views(Method method) {

    }

    @AfterClass(alwaysRun = true)
    public void afterClass() {
        closeBrowserDriver();
    }

    private HomePageObject homePage;
    private RegisterPageObject registerPage;
    private LoginPageObject loginPage;

    private CustomerInfoPageObject customerInfoPage;
}

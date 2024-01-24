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
import pageObject.*;
import reportConfig.ExtentTestManager;

import java.lang.reflect.Method;

public class Nopcommerce_003_My_Account extends BaseTest {
    private WebDriver driver;
    private String emailAddress, reviewTitle, reviewText, currentDay, productName;


    @Parameters({"browser", "url"})
    @BeforeClass
    public void beforeClass(String browserName, String appUrl) {
        driver = getBrowserDriver(browserName, appUrl);
        homePage = PageGeneratorManager.getHomePage(driver);
        registerPage = homePage.openRegisterPage();

        emailAddress = UserData.Register.EMAIL_ADDRESS + generateFakeNumber() + "@gmail.com";
        reviewTitle = UserData.ProductReview.REVIEW_TITLE + generateFakeNumber();
        reviewText = UserData.ProductReview.REVIEW_TEXT + generateFakeNumber();
        currentDay = getToday();

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
        loginPage = registerPage.clickLoginLink();
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
        Assert.assertEquals(customerInfoPage.getEmailValue(), UserData.CustomerInfo.EMAIL_ADDRESS);

        ExtentTestManager.getTest().log(Status.INFO, "Customer Info - Step 19: Verify Company name updated is value " + UserData.CustomerInfo.COMPANY_NAME);
        Assert.assertEquals(customerInfoPage.getCompanyNameValue(), UserData.CustomerInfo.COMPANY_NAME);
    }


    @Test
    public void My_Account_02_Addresses(Method method) {
        ExtentTestManager.startTest(method.getName(), "My_Account_02_Addresses"); //start TC
        ExtentTestManager.getTest().log(Status.INFO, "Addresses - Step 01: Open 'Address' link");
        addressPage = customerInfoPage.openAddressPage(driver);

        ExtentTestManager.getTest().log(Status.INFO, "Addresses - Step 2: Verify My Account Address page title deplayed");
        Assert.assertTrue(addressPage.isMyAccountAddressPageTitle());

        ExtentTestManager.getTest().log(Status.INFO, "Addresses - Step 3: Click to 'Add New' button");
        addNewAddressPage = addressPage.clickToAddNewButton();

        ExtentTestManager.getTest().log(Status.INFO, "Addresses - Step 4: Verify My Account Add New Address page title deplayed");
        Assert.assertTrue(addNewAddressPage.isMyAccountAddNewAddressPageTitle());

        ExtentTestManager.getTest().log(Status.INFO, "Addresses - Step 5: Input To Firstname Textbox with value is: " + UserData.AddNewAddress.FIRSTNAME);
        addNewAddressPage.inputToFirstNameTextbox(UserData.AddNewAddress.FIRSTNAME);

        ExtentTestManager.getTest().log(Status.INFO, "Addresses - Step 6: Input To Lastname Textbox with value is: " + UserData.AddNewAddress.LASTNAME);
        addNewAddressPage.inputToLastNameTextbox(UserData.AddNewAddress.LASTNAME);

        ExtentTestManager.getTest().log(Status.INFO, "Addresses - Step 7: Input To Email Textbox with value is: " + UserData.AddNewAddress.EMAIL);
        addNewAddressPage.inputToEmailTextbox(UserData.AddNewAddress.EMAIL);

        ExtentTestManager.getTest().log(Status.INFO, "Addresses - Step 8: Input To Company Textbox with value is: " + UserData.AddNewAddress.COMPANY);
        addNewAddressPage.inputToCompanyTextbox(UserData.AddNewAddress.COMPANY);

        ExtentTestManager.getTest().log(Status.INFO, "Addresses - Step 9: Input To Country Dropdown with value is: " + UserData.AddNewAddress.COUNTRY);
        addNewAddressPage.inputToContryDropdown(UserData.AddNewAddress.COUNTRY);

        ExtentTestManager.getTest().log(Status.INFO, "Addresses - Step 10: Input To State Province Dropdown with value is: " + UserData.AddNewAddress.STATE_PROVINCE);
        addNewAddressPage.inputToStateProvinceDropdown(UserData.AddNewAddress.STATE_PROVINCE);

        ExtentTestManager.getTest().log(Status.INFO, "Addresses - Step 11: Input To City textbox with value is: " + UserData.AddNewAddress.CITY);
        addNewAddressPage.inputToCityTextbox(UserData.AddNewAddress.CITY);

        ExtentTestManager.getTest().log(Status.INFO, "Addresses - Step 12: Input To Address 1 Textbox with value is: " + UserData.AddNewAddress.ADDRESS_1);
        addNewAddressPage.inputToAddress1Textbox(UserData.AddNewAddress.ADDRESS_1);

        ExtentTestManager.getTest().log(Status.INFO, "Addresses - Step 13: Input To Address 2 Textbox with value is: " + UserData.AddNewAddress.ADDRESS_2);
        addNewAddressPage.inputToAddress2Textbox(UserData.AddNewAddress.ADDRESS_2);

        ExtentTestManager.getTest().log(Status.INFO, "Addresses - Step 14: Input To Zip Postal Code Textbox with value is: " + UserData.AddNewAddress.ZIP_POSTAL_CODE);
        addNewAddressPage.inputToZipPostalCodeTextbox(UserData.AddNewAddress.ZIP_POSTAL_CODE);

        ExtentTestManager.getTest().log(Status.INFO, "Addresses - Step 15: Input To Phone number Textbox with value is: " + UserData.AddNewAddress.PHONE_NUMBER);
        addNewAddressPage.inputToPhoneNumberTextbox(UserData.AddNewAddress.PHONE_NUMBER);

        ExtentTestManager.getTest().log(Status.INFO, "Addresses - Step 16: Input To Fax Textbox with value is: " + UserData.AddNewAddress.FAX_NUMBER);
        addNewAddressPage.inputToFaxNumberTextbox(UserData.AddNewAddress.FAX_NUMBER);

        ExtentTestManager.getTest().log(Status.INFO, "Addresses - Step 17: Click to Save button");
        addressPage = addNewAddressPage.clickToSaveButton();

        ExtentTestManager.getTest().log(Status.INFO, "Addresses - Step 18: Verify Add New Address success message displayed");
        Assert.assertEquals(addressPage.getAddNewAddressSuccessMessage(), "The new address has been added successfully.");

        ExtentTestManager.getTest().log(Status.INFO, "Addresses - Step 19: Verify Title Name displayed with value is: " + UserData.AddNewAddress.FIRSTNAME + " " + UserData.AddNewAddress.LASTNAME);
        Assert.assertEquals(addressPage.getTitleNameDisplayed(), UserData.AddNewAddress.FIRSTNAME + " " + UserData.AddNewAddress.LASTNAME);

        ExtentTestManager.getTest().log(Status.INFO, "Addresses - Step 20: Verify Name displayed with value is: " + UserData.AddNewAddress.FIRSTNAME + " " + UserData.AddNewAddress.LASTNAME);
        Assert.assertEquals(addressPage.getNameDisplayed(), UserData.AddNewAddress.FIRSTNAME + " " + UserData.AddNewAddress.LASTNAME);

        ExtentTestManager.getTest().log(Status.INFO, "Addresses - Step 21: Verify Email displayed with value is: " + UserData.AddNewAddress.EMAIL);
        Assert.assertTrue(addressPage.getEmailDisplayed().contains(UserData.AddNewAddress.EMAIL));

        ExtentTestManager.getTest().log(Status.INFO, "Addresses - Step 22: Verify Phone Number displayed with value is: " + UserData.AddNewAddress.PHONE_NUMBER);
        Assert.assertTrue(addressPage.getPhoneNumberDisplayed().contains(UserData.AddNewAddress.PHONE_NUMBER));


        ExtentTestManager.getTest().log(Status.INFO, "Addresses - Step 23: Verify Fax Number displayed with value is: " + UserData.AddNewAddress.FAX_NUMBER);
        Assert.assertTrue(addressPage.getFaxNumberDisplayed().contains(UserData.AddNewAddress.FAX_NUMBER));

        ExtentTestManager.getTest().log(Status.INFO, "Addresses - Step 24: Verify Company displayed with value is: " + UserData.AddNewAddress.COMPANY);
        Assert.assertEquals(addressPage.getCompanyDisplayed(), UserData.AddNewAddress.COMPANY);

        ExtentTestManager.getTest().log(Status.INFO, "Addresses - Step 25: Verify Address 1 displayed with value is: " + UserData.AddNewAddress.ADDRESS_1);
        Assert.assertEquals(addressPage.getAddress1Displayed(), UserData.AddNewAddress.ADDRESS_1);

        ExtentTestManager.getTest().log(Status.INFO, "Addresses - Step 26: Verify Address 2 displayed with value is: " + UserData.AddNewAddress.ADDRESS_2);
        Assert.assertEquals(addressPage.getAddress2Displayed(), UserData.AddNewAddress.ADDRESS_2);

        ExtentTestManager.getTest().log(Status.INFO, "Addresses - Step 27: Verify City State Zip displayed with value is: " + UserData.AddNewAddress.CITY + ", " + UserData.AddNewAddress.ZIP_POSTAL_CODE);
        Assert.assertEquals(addressPage.getCityStateZipDisplayed(), UserData.AddNewAddress.CITY + ", " + UserData.AddNewAddress.ZIP_POSTAL_CODE);

        ExtentTestManager.getTest().log(Status.INFO, "Addresses - Step 28: Verify Country displayed with value is: " + UserData.AddNewAddress.COUNTRY);
        Assert.assertEquals(addressPage.getCountryDisplayed(), UserData.AddNewAddress.COUNTRY);

    }

    @Test
    public void My_Account_03_Change_Password(Method method) {
        ExtentTestManager.startTest(method.getName(), "My_Account_03_Change_Password"); //start TC
        ExtentTestManager.getTest().log(Status.INFO, "Change Password - Step 01: Open 'Change Password' link");
        changePasswordPage = addressPage.openChangePasswordPage(driver);

        ExtentTestManager.getTest().log(Status.INFO, "Change Password - Step 01: Input old password with value is: " + UserData.Register.PASSWORD);
        changePasswordPage.inputToOldPasswordTextbox(UserData.Register.PASSWORD);

        ExtentTestManager.getTest().log(Status.INFO, "Change Password - Step 02: Input new password with value is: " + UserData.ChangePassword.NEW_PASSWORD);
        changePasswordPage.inputToNewPasswordTextbox(UserData.ChangePassword.NEW_PASSWORD);

        ExtentTestManager.getTest().log(Status.INFO, "Change Password - Step 03: Input confrim password with value is: " + UserData.ChangePassword.NEW_PASSWORD);
        changePasswordPage.inputToConfirmPasswordTextbox(UserData.ChangePassword.NEW_PASSWORD);

        ExtentTestManager.getTest().log(Status.INFO, "Change Password - Step 04: Click To Change Password button");
        changePasswordPage.clickToChangePasswordButton();

        ExtentTestManager.getTest().log(Status.INFO, "Change Password - Step 05: Verify Change Password success message displayed");
        Assert.assertEquals(changePasswordPage.getChangePasswordSuccessMessage(), "Password was changed");

        ExtentTestManager.getTest().log(Status.INFO, "Change Password - Step 06: Click To Close Icon");
        changePasswordPage.clickToCloseIcon();

        ExtentTestManager.getTest().log(Status.INFO, "Change Password - Step 06: Click To Logout link");
        homePage = changePasswordPage.clickToLogoutLink();

        ExtentTestManager.getTest().log(Status.INFO, "Change Password - Step 07: Verify Register Link displayed");
        Assert.assertTrue(homePage.isRegisterLinkDisplayed());

        ExtentTestManager.getTest().log(Status.INFO, "Change Password - Step 08: Open Login link");
        loginPage = homePage.clickLoginLink();

        ExtentTestManager.getTest().log(Status.INFO, "Change Password - Step 09: Input to Email textbox with value is" + UserData.CustomerInfo.EMAIL_ADDRESS);
        loginPage.inputToEmailTextbox(UserData.CustomerInfo.EMAIL_ADDRESS);

        ExtentTestManager.getTest().log(Status.INFO, "Change Password - Step 10: Input to Password textbox with value is" + UserData.Register.PASSWORD);
        loginPage.inputToPasswordTextbox(UserData.Register.PASSWORD);

        ExtentTestManager.getTest().log(Status.INFO, "Change Password - Step 11: Click to 'Login' button");
        loginPage.clickToLoginButton();

        ExtentTestManager.getTest().log(Status.INFO, "Change Password - Step 12: Verify error message deplayed");
        Assert.assertEquals(loginPage.getEmailUnsuccessfullMessage(), "Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect");

        ExtentTestManager.getTest().log(Status.INFO, "Change Password - Step 13: Reopen Login link");
        loginPage.clickLoginLink();

        ExtentTestManager.getTest().log(Status.INFO, "Change Password - Step 14: Input to Email textbox with value is" + UserData.CustomerInfo.EMAIL_ADDRESS);
        loginPage.inputToEmailTextbox(UserData.CustomerInfo.EMAIL_ADDRESS);

        ExtentTestManager.getTest().log(Status.INFO, "Change Password - Step 15: Input to Password textbox with value is" + UserData.ChangePassword.NEW_PASSWORD);
        loginPage.inputToPasswordTextbox(UserData.ChangePassword.NEW_PASSWORD);

        ExtentTestManager.getTest().log(Status.INFO, "Change Password - Step 16: Click to 'Login' button");
        homePage = loginPage.clickToLoginButton();

        ExtentTestManager.getTest().log(Status.INFO, "Change Password - Step 17: Verify My Account link is displayed");
        Assert.assertTrue(homePage.isMyAccountLinkDisplayed());
    }

    @Test
    public void My_Account_04_My_Product_Views(Method method) {
        ExtentTestManager.startTest(method.getName(), "My_Account_04_My_Product_Views"); //start TC
        ExtentTestManager.getTest().log(Status.INFO, "Product Reviews - Step 01: Enter to Search textbox with value is: " + UserData.ProductReview.SEARCH_VALUE);
        homePage.inputToSearchTextbox(UserData.ProductReview.SEARCH_VALUE);

        ExtentTestManager.getTest().log(Status.INFO, "Product Reviews - Step 02: Click To Search button");
        searchPage = homePage.clickToSearchButton();

        ExtentTestManager.getTest().log(Status.INFO, "Product Reviews - Step 03: Get product name the of first in the list item");
        productName = searchPage.getFristProductNameOfListSearchProduct();

        ExtentTestManager.getTest().log(Status.INFO, "Product Reviews - Step 04: Click to first in list item");
        productDetailPage = searchPage.clickToFirstProductOfListSearchProduct();


        ExtentTestManager.getTest().log(Status.INFO, "Product Reviews - Step 05: Click To 'Add your review' link");
        productReviewPage = productDetailPage.clickToAddYourReviewLink();

        ExtentTestManager.getTest().log(Status.INFO, "Product Reviews - Step 06: Input To Review title with value is: " + reviewTitle);
        productReviewPage.inputToReviewTitleTextbox(reviewTitle);

        ExtentTestManager.getTest().log(Status.INFO, "Product Reviews - Step 07: Input To Review text with value is: " + reviewText);
        productReviewPage.inputToReviewTextTextbox(reviewText);

        ExtentTestManager.getTest().log(Status.INFO, "Product Reviews - Step 08: Select Rating radio button with value is: " + UserData.ProductReview.RATING);
        productReviewPage.selectToRatingRadioButton();

        ExtentTestManager.getTest().log(Status.INFO, "Product Reviews - Step 09: Click To 'SUBMIT REVIEW' button");
        productReviewPage.clickToSubmitReviewButton();

        ExtentTestManager.getTest().log(Status.INFO, "Product Reviews - Step 10: Verify Review title text displayed");
        Assert.assertEquals(productReviewPage.getReviewTitleValue(), reviewTitle);

        ExtentTestManager.getTest().log(Status.INFO, "Product Reviews - Step 11: Verify Review Content text displayed");
        Assert.assertEquals(productReviewPage.getReviewContentValue(), reviewText);

        ExtentTestManager.getTest().log(Status.INFO, "Product Reviews - Step 12: Verify Rating value displayed");
        Assert.assertTrue(productReviewPage.getProductRatingAttributeValue("style").contains("80%"));

        ExtentTestManager.getTest().log(Status.INFO, "Product Reviews - Step 13: Verify username display with value is: " + UserData.CustomerInfo.FIRSTNAME);
        Assert.assertEquals(productReviewPage.getNameValue(), UserData.CustomerInfo.FIRSTNAME);

        ExtentTestManager.getTest().log(Status.INFO, "Product Reviews - Step 14: Verify current day display with value is: " + currentDay);
        //Assert.assertTrue(productReviewPage.getCurrentDayValue().contains(currentDay));

        ExtentTestManager.getTest().log(Status.INFO, "Product Reviews - Step 15: Click 'My Account' link ");
        customerInfoPage = productReviewPage.clickToMyAccountLink();

        ExtentTestManager.getTest().log(Status.INFO, "Product Reviews - Step 16: Open 'My Product Review' page ");
        myProductReviewPage = customerInfoPage.openMyProductReviewPage(driver);

        ExtentTestManager.getTest().log(Status.INFO, "Product Reviews - Step 17: Verify Review title text displayed");
        Assert.assertEquals(myProductReviewPage.getReviewTitleValue(), reviewTitle);

        ExtentTestManager.getTest().log(Status.INFO, "Product Reviews - Step 18: Verify Review Content text displayed");
        Assert.assertEquals(myProductReviewPage.getReviewContentValue(), reviewText);

        ExtentTestManager.getTest().log(Status.INFO, "Product Reviews - Step 19: Verify Rating value displayed");
        Assert.assertTrue(productReviewPage.getProductRatingAttributeValue("style").contains("80%"));

        ExtentTestManager.getTest().log(Status.INFO, "Product Reviews - Step 20: Verify product name reviewed ");
        Assert.assertEquals(productReviewPage.getProductNameReviewed(), productName);

        ExtentTestManager.getTest().log(Status.INFO, "Product Reviews - Step 21: Verify current day display with value is: " + currentDay);
        ///Assert.assertTrue(myProductReviewPage.getCurrentDayValue().contains(currentDay));
    }

    @AfterClass(alwaysRun = true)
    public void afterClass() {
        closeBrowserDriver();
    }

    private HomePageObject homePage;
    private RegisterPageObject registerPage;
    private LoginPageObject loginPage;

    private CustomerInfoPageObject customerInfoPage;
    private AddressPageObject addressPage;
    private AddNewAddressPageObject addNewAddressPage;
    private ChangePasswordPageObject changePasswordPage;
    private SearchPageObject searchPage;
    private ProductDetailPageObject productDetailPage;
    private ProductReviewPageObject productReviewPage;
    private MyProductReviewPageObject myProductReviewPage;
}

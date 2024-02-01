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

public class Nopcommerce_007_Order extends BaseTest {
    private WebDriver driver;
    private String emailAddress, productName1, productPrice;


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
        System.out.println("email : " + emailAddress);
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

        homePage.inputToSearchTextbox(UserData.Order.SEARCH_VALUE);
        searchPage = homePage.clickToSearchButtonAtHeader();
        productName1 = searchPage.getProductNameDisplayedAtTheNumber("1");
        productDetailPage = searchPage.clickToFirstProductOfListSearchProduct();

    }


    @Test
    public void Nopcommerce_007_TC_01_Add_Product_To_Cart(Method method) {
        ExtentTestManager.startTest(method.getName(), "Nopcommerce_007_TC_01_Add_Product_To_Cart");
        ExtentTestManager.getTest().log(Status.INFO, "Step 01: Select to 'Processor' dropdown ");
        productDetailPage.selectDropdownByLabelName("Processor", UserData.Order.PRODUCT_PROCESSOR);

        ExtentTestManager.getTest().log(Status.INFO, "Step 02: Select to 'RAM' dropdown ");
        productDetailPage.selectDropdownByLabelName("RAM", UserData.Order.PRODUCT_RAM);

        ExtentTestManager.getTest().log(Status.INFO, "Step 03: Select to 'HDD' radio button ");
        productDetailPage.checkToCheckboxAndRadioButtonByLabelName("HDD", UserData.Order.PRODUCT_HDD);

        ExtentTestManager.getTest().log(Status.INFO, "Step 04: Select to 'OS' radio button ");
        productDetailPage.checkToCheckboxAndRadioButtonByLabelName("OS", UserData.Order.PRODUCT_OS);

        ExtentTestManager.getTest().log(Status.INFO, "Step 05: Select to 'Software' checkbox");
        productDetailPage.checkToCheckboxAndRadioButtonByLabelName("Software", UserData.Order.PRODUCT_SOFTWARE_MICROSOFT_OFFICE);
        productDetailPage.checkToCheckboxAndRadioButtonByLabelName("Software", UserData.Order.PRODUCT_SOFTWARE_ACROBAT_READER);
        productDetailPage.checkToCheckboxAndRadioButtonByLabelName("Software", UserData.Order.PRODUCT_SOFTWARE_TOTAL_COMMANDER);


        productPrice = productDetailPage.getProductPrice();

        ExtentTestManager.getTest().log(Status.INFO, "Step 06: Click 'ADD TO CART' button");
        productDetailPage.clickToAddToCartButton();

        ExtentTestManager.getTest().log(Status.INFO, "Step 07: Vefiry product undisplay at Wishlist page");
        Assert.assertEquals(productDetailPage.getMessageDisplayed(), "The product has been added to your shopping cart");

        ExtentTestManager.getTest().log(Status.INFO, "Step 08: Click to Close icon");
        productDetailPage.clickToCloseIcon();
        productDetailPage.sleepInSecond(1);

        ExtentTestManager.getTest().log(Status.INFO, "Step 09: Scroll to Shopping cart header menu link ");
        productDetailPage.scrollToElementShoppingCartMenuLink();

        ExtentTestManager.getTest().log(Status.INFO, "Step 10: Hover to 'Shopping cart' header uppder Link");
        productDetailPage.hoverMouserToShoppingCartHeaderUpperLink();

        ExtentTestManager.getTest().log(Status.INFO, "Step 10: Verify 1 item in your cart message displayed");
        Assert.assertEquals(productDetailPage.getMessageDisplay(), "There are 1 item(s) in your cart.");

        ExtentTestManager.getTest().log(Status.INFO, "Step 11: Verify product information selected displayed");
        Assert.assertTrue(productDetailPage.getProductInformation().contains(productName1));
        Assert.assertTrue(productDetailPage.getProductInformation().contains(UserData.Order.PRODUCT_PROCESSOR));
        Assert.assertTrue(productDetailPage.getProductInformation().contains(UserData.Order.PRODUCT_RAM));
        Assert.assertTrue(productDetailPage.getProductInformation().contains(UserData.Order.PRODUCT_OS));
        Assert.assertTrue(productDetailPage.getProductInformation().contains(UserData.Order.PRODUCT_HDD));
        Assert.assertTrue(productDetailPage.getProductInformation().contains(UserData.Order.PRODUCT_SOFTWARE_ACROBAT_READER));
        Assert.assertTrue(productDetailPage.getProductInformation().contains(UserData.Order.PRODUCT_SOFTWARE_MICROSOFT_OFFICE));
        Assert.assertTrue(productDetailPage.getProductInformation().contains(UserData.Order.PRODUCT_SOFTWARE_TOTAL_COMMANDER));
        Assert.assertTrue(productDetailPage.getProductInformation().contains(productPrice));
    }

    @Test
    public void Nopcommerce_007_TC_02_Edit_Product_In_Shopping_Cart(Method method) {
        ExtentTestManager.startTest(method.getName(), "Nopcommerce_007_TC_02_Edit_Product_In_Shopping_Cart");
        ExtentTestManager.getTest().log(Status.INFO, "Step 01: Open shopping cart page ");
        shoppingCartPage = productDetailPage.clickToShoppingCartLink();

        ExtentTestManager.getTest().log(Status.INFO, "Step 02: Click to edit link ");
        productDetailPage = shoppingCartPage.clickToEditLink();
    }


    @AfterClass(alwaysRun = true)
    public void afterClass() {
        closeBrowserDriver();
    }

    private HomePageObject homePage;
    private RegisterPageObject registerPage;
    private LoginPageObject loginPage;
    private SearchPageObject searchPage;
    private ProductDetailPageObject productDetailPage;

    private ShoppingCartPageObject shoppingCartPage;

}

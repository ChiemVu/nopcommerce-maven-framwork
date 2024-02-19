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
import pageObject.user.*;
import reportConfig.ExtentTestManager;

import java.lang.reflect.Method;

public class Nopcommerce_007_Order extends BaseTest {
    private WebDriver driver;
    private String emailAddress, productName1, unitProductPrict;
    Float productPrice;


    @Parameters({"browser", "userUrl"})
    @BeforeClass
    public void beforeClass(String browserName, String userUrl) {
        driver = getBrowserDriver(browserName, userUrl);
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
        productDetailPage.checkToCheckboxOrRadionButtonByLabelName(UserData.Order.PRODUCT_HDD);

        ExtentTestManager.getTest().log(Status.INFO, "Step 04: Select to 'OS' radio button ");
        productDetailPage.checkToCheckboxOrRadionButtonByLabelName(UserData.Order.PRODUCT_OS);

        ExtentTestManager.getTest().log(Status.INFO, "Step 05: Select to 'Software' checkbox");
        productDetailPage.checkToCheckboxOrRadionButtonByLabelName(UserData.Order.PRODUCT_SOFTWARE_MICROSOFT_OFFICE);
        productDetailPage.sleepInSecond(1);
        productDetailPage.checkToCheckboxOrRadionButtonByLabelName(UserData.Order.PRODUCT_SOFTWARE_ACROBAT_READER);
        productDetailPage.sleepInSecond(1);
        productDetailPage.checkToCheckboxOrRadionButtonByLabelName(UserData.Order.PRODUCT_SOFTWARE_TOTAL_COMMANDER);
        productDetailPage.sleepInSecond(1);

        ExtentTestManager.getTest().log(Status.INFO, "Step 05: Get Unit Product price");
        unitProductPrict = productDetailPage.getUnitProductPrice();

        ExtentTestManager.getTest().log(Status.INFO, "Step 05: Get Product price");
        productPrice = productDetailPage.getProductPrice(Float.valueOf(UserData.Order.PRODUCT_QUANTITY));

        ExtentTestManager.getTest().log(Status.INFO, "Step 08: Input Quantity with value is: " + UserData.Order.PRODUCT_QUANTITY);
        productDetailPage.inputToQuantityTextbox(UserData.Order.PRODUCT_QUANTITY);

        ExtentTestManager.getTest().log(Status.INFO, "Step 06: Click 'ADD TO CART' button");
        productDetailPage.clickToAddToCartButton();

        ExtentTestManager.getTest().log(Status.INFO, "Step 07: Vefiry product undisplay at Wishlist page");
        Assert.assertEquals(productDetailPage.getMessageDisplayed(), "The product has been added to your shopping cart");

        ExtentTestManager.getTest().log(Status.INFO, "Step 08: Click to Close icon");
        productDetailPage.clickToCloseIcon();
        productDetailPage.sleepInSecond(1);

        ExtentTestManager.getTest().log(Status.INFO, "Step 09: Scroll to Shopping cart header menu link ");
        productDetailPage.scrollToHeaderUpperMenuLink("ico-cart");

        ExtentTestManager.getTest().log(Status.INFO, "Step 10: Hover to 'Shopping cart' header uppder Link");
        productDetailPage.hoverMouserToShoppingCartHeaderUpperLink();

        ExtentTestManager.getTest().log(Status.INFO, "Step 10: Verify 1 item in your cart message displayed");
        Assert.assertEquals(productDetailPage.getMessageDisplay(), "There are " + UserData.Order.PRODUCT_QUANTITY + " item(s) in your cart.");

        ExtentTestManager.getTest().log(Status.INFO, "Step 11: Verify product information selected displayed");
        Assert.assertTrue(productDetailPage.isProductInformationDisplayed("name", productName1));
        ExtentTestManager.getTest().log(Status.INFO, "Step 12:");
        Assert.assertTrue(productDetailPage.isProductInformationDisplayed("attributes", UserData.Order.PRODUCT_PROCESSOR));
        ExtentTestManager.getTest().log(Status.INFO, "Step 13:");
        Assert.assertTrue(productDetailPage.isProductInformationDisplayed("attributes", UserData.Order.PRODUCT_RAM));
        ExtentTestManager.getTest().log(Status.INFO, "Step 14:");
        Assert.assertTrue(productDetailPage.isProductInformationDisplayed("attributes", UserData.Order.PRODUCT_OS));

        Assert.assertTrue(productDetailPage.isProductInformationDisplayed("attributes", UserData.Order.PRODUCT_HDD));
        ExtentTestManager.getTest().log(Status.INFO, "Step 15:");

        Assert.assertTrue(productDetailPage.isProductInformationDisplayed("attributes", UserData.Order.PRODUCT_SOFTWARE_ACROBAT_READER));
        ExtentTestManager.getTest().log(Status.INFO, "Step 17:");
        Assert.assertTrue(productDetailPage.isProductInformationDisplayed("attributes", UserData.Order.PRODUCT_SOFTWARE_MICROSOFT_OFFICE));
        ExtentTestManager.getTest().log(Status.INFO, "Step 18:");
        Assert.assertTrue(productDetailPage.isProductInformationDisplayed("attributes", UserData.Order.PRODUCT_SOFTWARE_TOTAL_COMMANDER));
        ExtentTestManager.getTest().log(Status.INFO, "Step 19:");
        Assert.assertTrue(productDetailPage.isProductInformationDisplayed("price", unitProductPrict));
        ExtentTestManager.getTest().log(Status.INFO, "Step 20:");
        Assert.assertTrue(productDetailPage.isProductInformationDisplayed("quantity", UserData.Order.PRODUCT_QUANTITY));
        ExtentTestManager.getTest().log(Status.INFO, "Step 21:");
        Assert.assertEquals(productDetailPage.getProductSubTotal(), productPrice);
    }

    @Test
    public void Nopcommerce_007_TC_02_Edit_Product_In_Shopping_Cart(Method method) {
        ExtentTestManager.startTest(method.getName(), "Nopcommerce_007_TC_02_Edit_Product_In_Shopping_Cart");
        ExtentTestManager.getTest().log(Status.INFO, "Step 01: Open shopping cart page ");
        shoppingCartPage = productDetailPage.clickToShoppingCartLink();

        ExtentTestManager.getTest().log(Status.INFO, "Step 02: Click to edit link ");
        productDetailPage = shoppingCartPage.clickToEditLink("Product(s)");

        ExtentTestManager.getTest().log(Status.INFO, "Step 03: Select to 'Processor' dropdown ");
        productDetailPage.selectDropdownByLabelName("Processor", UserData.Order.PRODUCT_PROCESSOR_UPDATE);

        ExtentTestManager.getTest().log(Status.INFO, "Step 04: Select to 'RAM' dropdown ");
        productDetailPage.selectDropdownByLabelName("RAM", UserData.Order.PRODUCT_RAM_UPDATE);

        ExtentTestManager.getTest().log(Status.INFO, "Step 05: Select to 'HDD' radio button ");
        productDetailPage.checkToCheckboxOrRadionButtonByLabelName(UserData.Order.PRODUCT_HDD_UPDATE);

        ExtentTestManager.getTest().log(Status.INFO, "Step 06: Select to 'OS' radio button ");
        productDetailPage.checkToCheckboxOrRadionButtonByLabelName(UserData.Order.PRODUCT_OS_UPDATE);

        ExtentTestManager.getTest().log(Status.INFO, "Step 07: Select to 'Software' checkbox");
        productDetailPage.checkToCheckboxOrRadionButtonByLabelName(UserData.Order.PRODUCT_SOFTWARE_MICROSOFT_OFFICE);
        productDetailPage.uncheckToCheckboxByLabelName(UserData.Order.PRODUCT_SOFTWARE_ACROBAT_READER);
        productDetailPage.uncheckToCheckboxByLabelName(UserData.Order.PRODUCT_SOFTWARE_TOTAL_COMMANDER);

        ExtentTestManager.getTest().log(Status.INFO, "Step 05: Get Unit Product price");
        unitProductPrict = productDetailPage.getUnitProductPrice();

        ExtentTestManager.getTest().log(Status.INFO, "Step 08: Input Quantity with value is: " + UserData.Order.PRODUCT_QUANTITY_UPDATE);
        productDetailPage.inputToQuantityTextbox(UserData.Order.PRODUCT_QUANTITY_UPDATE);


        ExtentTestManager.getTest().log(Status.INFO, "Step 05: Verify Unit Product price Is $1,320.00 ");
        Assert.assertEquals(unitProductPrict, "$1,320.00");

        ExtentTestManager.getTest().log(Status.INFO, "Step 09: Get Product price");
        productPrice = productDetailPage.getProductPrice(Float.valueOf(UserData.Order.PRODUCT_QUANTITY_UPDATE));

        ExtentTestManager.getTest().log(Status.INFO, "Step 10: Click to 'UPDATE' button");
        productDetailPage.clickToUpdateButton();

        ExtentTestManager.getTest().log(Status.INFO, "Step 10: Vefiry message display");
        Assert.assertEquals(productDetailPage.getMessageDisplayed(), "The product has been added to your shopping cart");

        ExtentTestManager.getTest().log(Status.INFO, "Step 11: Click to Close icon");
        productDetailPage.clickToCloseIcon();
        productDetailPage.sleepInSecond(1);

        ExtentTestManager.getTest().log(Status.INFO, "Step 12: Scroll to Shopping cart header menu link ");
        productDetailPage.scrollToHeaderUpperMenuLink("ico-cart");

        ExtentTestManager.getTest().log(Status.INFO, "Step 10: Hover to 'Shopping cart' header uppder Link");
        productDetailPage.hoverMouserToShoppingCartHeaderUpperLink();

        ExtentTestManager.getTest().log(Status.INFO, "Step 10: Verify item in your cart message displayed");
        Assert.assertEquals(productDetailPage.getMessageDisplay(), "There are " + UserData.Order.PRODUCT_QUANTITY_UPDATE + " item(s) in your cart.");

        ExtentTestManager.getTest().log(Status.INFO, "Step 11: Verify product information selected displayed");
        Assert.assertTrue(productDetailPage.isProductInformationDisplayed("name", productName1));
        ExtentTestManager.getTest().log(Status.INFO, "Step 12:");
        Assert.assertTrue(productDetailPage.isProductInformationDisplayed("attributes", UserData.Order.PRODUCT_PROCESSOR_UPDATE));
        ExtentTestManager.getTest().log(Status.INFO, "Step 13:");
        Assert.assertTrue(productDetailPage.isProductInformationDisplayed("attributes", UserData.Order.PRODUCT_RAM_UPDATE));
        ExtentTestManager.getTest().log(Status.INFO, "Step 14:");
        Assert.assertTrue(productDetailPage.isProductInformationDisplayed("attributes", UserData.Order.PRODUCT_OS_UPDATE));

        Assert.assertTrue(productDetailPage.isProductInformationDisplayed("attributes", UserData.Order.PRODUCT_HDD_UPDATE));
        ExtentTestManager.getTest().log(Status.INFO, "Step 15:");
        Assert.assertTrue(productDetailPage.isProductInformationDisplayed("attributes", UserData.Order.PRODUCT_SOFTWARE_MICROSOFT_OFFICE));
        ExtentTestManager.getTest().log(Status.INFO, "Step 17:");
        Assert.assertTrue(productDetailPage.isProductSoftwarreUndisplayed("attributes", UserData.Order.PRODUCT_SOFTWARE_ACROBAT_READER));
        ExtentTestManager.getTest().log(Status.INFO, "Step 18:");
        Assert.assertTrue(productDetailPage.isProductSoftwarreUndisplayed("attributes", UserData.Order.PRODUCT_SOFTWARE_TOTAL_COMMANDER));
        ExtentTestManager.getTest().log(Status.INFO, "Step 19:");
        Assert.assertTrue(productDetailPage.isProductInformationDisplayed("price", unitProductPrict));
        ExtentTestManager.getTest().log(Status.INFO, "Step 20:");
        Assert.assertTrue(productDetailPage.isProductInformationDisplayed("quantity", UserData.Order.PRODUCT_QUANTITY_UPDATE));
        ExtentTestManager.getTest().log(Status.INFO, "Step 21:");
        Assert.assertEquals(productDetailPage.getProductSubTotal(), productPrice);
    }

    @Test
    public void Nopcommerce_007_TC_03_Remove_Product_From_Cart(Method method) {
        ExtentTestManager.startTest(method.getName(), "Nopcommerce_007_TC_03_Remove_Product_From_Cart");
        ExtentTestManager.getTest().log(Status.INFO, "Step 01: Open shopping cart page ");
        shoppingCartPage = productDetailPage.clickToShoppingCartLink();

        ExtentTestManager.getTest().log(Status.INFO, "Step 02: Click remove icon");
        shoppingCartPage.clickToRemoveIcon("Remove");

        ExtentTestManager.getTest().log(Status.INFO, "Step 03: Verify no data message display");
        Assert.assertEquals(shoppingCartPage.getNoDataMessageDisplay(), "Your Shopping Cart is empty!");

        ExtentTestManager.getTest().log(Status.INFO, "Step 04: Verify product undisplay in shopping cart");
        Assert.assertTrue(shoppingCartPage.isRowValueUndisplayAtCart("Product(s)", productName1));
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

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

public class Nopcommerce_006_Wishlist_Compare_Recent_View extends BaseTest {
    private WebDriver driver;
    private String emailAddress, wishlistPageUrl, productName1, priceProductName1, productName2, priceProductName2, notebooksPageUrl;


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

        homePage.inputToSearchTextbox(UserData.ProductReview.SEARCH_VALUE);
        searchPage = homePage.clickToSearchButtonAtHeader();
        productName1 = searchPage.getProductNameDisplayedAtTheNumber("1");
        productDetailPage = searchPage.clickToFirstProductOfListSearchProduct();

    }


    @Test
    public void Nopcommerce_006_TC_01_Wishlist(Method method) {
        ExtentTestManager.startTest(method.getName(), "TC_01_Wishlist");

        ExtentTestManager.getTest().log(Status.INFO, "Step 01: Scroll to 'Add to wishlist' button");
        productDetailPage.scrollToButton("Add to wishlist");

        ExtentTestManager.getTest().log(Status.INFO, "Step 02: Click to 'Add to wishlist' button");
        productDetailPage.clickToAddButton("Add to wishlist");

        ExtentTestManager.getTest().log(Status.INFO, "Step 03: Verify product has been added to your wishlish");
        Assert.assertEquals(productDetailPage.getMessageDisplayed(), "The product has been added to your wishlist");

        ExtentTestManager.getTest().log(Status.INFO, "Step 04: Click to close icon");
        productDetailPage.clickToCloseIcon();

        ExtentTestManager.getTest().log(Status.INFO, "Step 05: Scroll to Wishlish header menu link ");
        productDetailPage.scrollToHeaderUpperMenuLink("ico-wishlist");
        productDetailPage.sleepInSecond(2);

        ExtentTestManager.getTest().log(Status.INFO, "Step 06: Click to header upper 'Wishlish' link");
        wishlishPage = productDetailPage.clickToWishlistLink();
        wishlishPage.sleepInSecond(2);

        ExtentTestManager.getTest().log(Status.INFO, "Step 07: Get Wishlist page Url");
        wishlistPageUrl = wishlishPage.getCurrentPageUrl(driver);

        ExtentTestManager.getTest().log(Status.INFO, "Step 08: Verify product is display at wishlist page");
        Assert.assertTrue(wishlishPage.isRowValueDisplayedAtCart("Product(s)", productName1));

        ExtentTestManager.getTest().log(Status.INFO, "Step 09: Click to 'Your wishlish URL for sharing' link");
        yourWishlistSharingPage = wishlishPage.clickToYourWishlistUrlSharingLink();
        yourWishlistSharingPage.sleepInSecond(1);

        ExtentTestManager.getTest().log(Status.INFO, "Step 10: Verify product is display at wishlist page");
        Assert.assertTrue(yourWishlistSharingPage.isRowValueDisplayedAtCart("Product(s)", productName1));
    }

    @Test
    public void Nopcommerce_006_TC_02_Add_Product_To_Cart(Method method) {
        ExtentTestManager.startTest(method.getName(), "TC_02_Add_Product_To_Cart");
        ExtentTestManager.getTest().log(Status.INFO, "Step 01: Select checkbox Add to cart");
        yourWishlistSharingPage.clickToAddToCartCheckbox();

        ExtentTestManager.getTest().log(Status.INFO, "Step 02: Click to 'ADD TO CART' button");
        shoppingCartPage = yourWishlistSharingPage.clickToAddToCartButton();

        ExtentTestManager.getTest().log(Status.INFO, "Step 03: Verify product display at Shopping cart page");
        Assert.assertTrue(shoppingCartPage.isRowValueDisplayedAtCart("Product(s)", productName1));

    }

    @Test
    public void Nopcommerce_006_TC_03_Remove_Product_In_Wishlist_Page(Method method) {
        ExtentTestManager.startTest(method.getName(), "TC_03_Remove_Product_In_Wishlist_Page");
        ExtentTestManager.getTest().log(Status.INFO, "Step 01: Open Wishlist Page");
        wishlishPage = shoppingCartPage.openWishlistPageUrl(wishlistPageUrl);

        wishlishPage.sleepInSecond(1);

        ExtentTestManager.getTest().log(Status.INFO, "Step 02: Click to 'Remove' icon");
        wishlishPage.clickToRemoveIcon();
        wishlishPage.sleepInSecond(1);

        ExtentTestManager.getTest().log(Status.INFO, "Step 03: Vefiry product undisplay at Wishlist page");
        Assert.assertEquals(wishlishPage.getEmptyDataMessageDisplay(), "The wishlist is empty!");

        ExtentTestManager.getTest().log(Status.INFO, "Step 04: Vefiry product name undisplay at Wishlist page");
        Assert.assertTrue(wishlishPage.isRowValueUndisplayAtCart("Product(s)", productName1));
    }

    @Test
    public void Nopcommerce_006_TC_04_Add_Product_To_Compare(Method method) {
        ExtentTestManager.startTest(method.getName(), "TC_04_Add_Product_To_Compare");
        ExtentTestManager.getTest().log(Status.INFO, "Step 01: Open computerPage");
        computersPage = wishlishPage.clickToComputerHeaderMenu();

        ExtentTestManager.getTest().log(Status.INFO, "Step 02: Open Notebooks Page");
        notebooksPage = computersPage.clickToNotebooksNavigationSubmenu();

        notebooksPageUrl = notebooksPage.getCurrentPageUrl(driver);

        ExtentTestManager.getTest().log(Status.INFO, "Step 03: Get productName 1");
        productName1 = notebooksPage.getProductNameDisplayedAtTheNumber("1");

        ExtentTestManager.getTest().log(Status.INFO, "Step 04: Get price of the productName 1");
        priceProductName1 = notebooksPage.getPriceProductNameDisplayedAtTheNumber(productName1);

        ExtentTestManager.getTest().log(Status.INFO, "Step 05: Get productName 2");
        productName2 = notebooksPage.getProductNameDisplayedAtTheNumber("2");

        ExtentTestManager.getTest().log(Status.INFO, "Step 06: Get price of the productName 2");
        priceProductName2 = notebooksPage.getPriceProductNameDisplayedAtTheNumber(productName2);

        ExtentTestManager.getTest().log(Status.INFO, "Step 07: Click 'Add To Compare List' icon at the 1st product");
        notebooksPage.clickAddToCompareListIconByProductName(productName1);

        ExtentTestManager.getTest().log(Status.INFO, "Step 08: Verify message added displayed");
        Assert.assertEquals(notebooksPage.getMessageDisplayed(), "The product has been added to your product comparison");

        ExtentTestManager.getTest().log(Status.INFO, "Step 09: Click to Close icon");
        notebooksPage.clickToCloseIcon();

        ExtentTestManager.getTest().log(Status.INFO, "Step 10: Click 'Add To Compare List' icon at the 2nd product");
        notebooksPage.clickAddToCompareListIconByProductName(productName2);

        ExtentTestManager.getTest().log(Status.INFO, "Step 11: Verify message added displayed");
        Assert.assertEquals(notebooksPage.getMessageDisplayed(), "The product has been added to your product comparison");

        ExtentTestManager.getTest().log(Status.INFO, "Step 12: Click to 'product comparison' link ");
        compareProductsPage = notebooksPage.clickToProductComparisonLink();
        compareProductsPage.sleepInSecond(1);

        ExtentTestManager.getTest().log(Status.INFO, "Step 13: Verify Product information displayed ");
        Assert.assertTrue(compareProductsPage.getProductInformationDisplayed().contains(productName1));
        Assert.assertTrue(compareProductsPage.getProductInformationDisplayed().contains(priceProductName1));
        Assert.assertTrue(compareProductsPage.getProductInformationDisplayed().contains(productName2));
        Assert.assertTrue(compareProductsPage.getProductInformationDisplayed().contains(priceProductName2));

        ExtentTestManager.getTest().log(Status.INFO, "Step 14: Click to 'Clear list' button ");
        compareProductsPage.clickToClearListButton();

        ExtentTestManager.getTest().log(Status.INFO, "Step 15: verify no item displayed ");
        Assert.assertEquals(compareProductsPage.getNoItemMessageDisplayed(), "You have no items to compare.");

        ExtentTestManager.getTest().log(Status.INFO, "Step 16: verify product information undisplayed ");
        Assert.assertTrue(compareProductsPage.isProductInformationUndisplay(productName1));
        Assert.assertTrue(compareProductsPage.isProductInformationUndisplay(productName2));
    }

    @Test
    public void Nopcommerce_006_TC_05_View_5_Detail_Product(Method method) {
        ExtentTestManager.startTest(method.getName(), "TC_05_View_5_Detail_Product");
        ExtentTestManager.getTest().log(Status.INFO, "Step 01: Open computerPage");
        computersPage = compareProductsPage.clickToComputerHeaderMenu();

        ExtentTestManager.getTest().log(Status.INFO, "Step 02: Open Notebooks Page");
        notebooksPage = computersPage.openNotebooksPageUrl(notebooksPageUrl);
        notebooksPageUrl = notebooksPage.getCurrentPageUrl(driver);

        ExtentTestManager.getTest().log(Status.INFO, "Step 03: Open product detail page ");
        productDetailPage = notebooksPage.openProductDetailPageAtPosition("1");
        productDetailPage.sleepInSecond(3);

        ExtentTestManager.getTest().log(Status.INFO, "Step 04: Get Product Name at Product detail page ");
        productName1 = productDetailPage.getProductNameText();

        ExtentTestManager.getTest().log(Status.INFO, "Step 05: Open recently view product page ");
        recentlyViewProductsPage = productDetailPage.openRecentlyViewProductPage();
        recentlyViewProductsPage.sleepInSecond(3);

        ExtentTestManager.getTest().log(Status.INFO, "Step 06: Verify product name view lastest display at recently view product page ");
        Assert.assertEquals(recentlyViewProductsPage.getProductNameDisplayed(), productName1);

        ExtentTestManager.getTest().log(Status.INFO, "Step 07: Verify <=3 product name view lastest display at recently view product page ");
        Assert.assertTrue(recentlyViewProductsPage.checkNumberProductDisplayAtRecentlyViewProductPage());

        ExtentTestManager.getTest().log(Status.INFO, "Step 08: Open Notebooks Page");
        notebooksPage = recentlyViewProductsPage.openNotebooksPageUrl(notebooksPageUrl);

        ExtentTestManager.getTest().log(Status.INFO, "Step 09: Open product detail page ");
        productDetailPage = notebooksPage.openProductDetailPageAtPosition("2");
        productDetailPage.sleepInSecond(1);

        ExtentTestManager.getTest().log(Status.INFO, "Step 10: Get Product Name at Product detail page ");
        productName1 = productDetailPage.getProductNameText();

        ExtentTestManager.getTest().log(Status.INFO, "Step 11: Open recently view product page ");
        recentlyViewProductsPage = productDetailPage.openRecentlyViewProductPage();
        recentlyViewProductsPage.sleepInSecond(3);

        ExtentTestManager.getTest().log(Status.INFO, "Step 12: Verify product name view lastest display at recently view product page ");
        Assert.assertEquals(recentlyViewProductsPage.getProductNameDisplayed(), productName1);

        ExtentTestManager.getTest().log(Status.INFO, "Step 13: Verify <=3 product name view lastest display at recently view product page ");
        Assert.assertTrue(recentlyViewProductsPage.checkNumberProductDisplayAtRecentlyViewProductPage());

        ExtentTestManager.getTest().log(Status.INFO, "Step 14: Open Notebooks Page");
        notebooksPage = recentlyViewProductsPage.openNotebooksPageUrl(notebooksPageUrl);

        ExtentTestManager.getTest().log(Status.INFO, "Step 15: Open product detail page ");
        productDetailPage = notebooksPage.openProductDetailPageAtPosition("6");
        productDetailPage.sleepInSecond(1);

        ExtentTestManager.getTest().log(Status.INFO, "Step 16: Get Product Name at Product detail page ");
        productName1 = productDetailPage.getProductNameText();

        ExtentTestManager.getTest().log(Status.INFO, "Step 17: Open recently view product page ");
        recentlyViewProductsPage = productDetailPage.openRecentlyViewProductPage();
        recentlyViewProductsPage.sleepInSecond(3);

        ExtentTestManager.getTest().log(Status.INFO, "Step 18: Verify product name view lastest display at recently view product page ");
        Assert.assertTrue(recentlyViewProductsPage.getProductNameDisplayed().contains(productName1));

        ExtentTestManager.getTest().log(Status.INFO, "Step 19: Verify <=3 product name view lastest display at recently view product page ");
        Assert.assertTrue(recentlyViewProductsPage.checkNumberProductDisplayAtRecentlyViewProductPage());

        ExtentTestManager.getTest().log(Status.INFO, "Step 20: Open Notebooks Page");
        notebooksPage = recentlyViewProductsPage.openNotebooksPageUrl(notebooksPageUrl);

        ExtentTestManager.getTest().log(Status.INFO, "Step 21: Open product detail page ");
        productDetailPage = notebooksPage.openProductDetailPageAtPosition("4");
        productDetailPage.sleepInSecond(1);

        ExtentTestManager.getTest().log(Status.INFO, "Step 22: Get Product Name at Product detail page ");
        productName1 = productDetailPage.getProductNameText();

        ExtentTestManager.getTest().log(Status.INFO, "Step 23: Open recently view product page ");
        recentlyViewProductsPage = productDetailPage.openRecentlyViewProductPage();
        recentlyViewProductsPage.sleepInSecond(3);

        ExtentTestManager.getTest().log(Status.INFO, "Step 24: Verify product name view lastest display at recently view product page ");
        Assert.assertTrue(recentlyViewProductsPage.getProductNameDisplayed().contains(productName1));

        ExtentTestManager.getTest().log(Status.INFO, "Step 25: Verify <=3 product name view lastest display at recently view product page ");
        Assert.assertTrue(recentlyViewProductsPage.checkNumberProductDisplayAtRecentlyViewProductPage());

        ExtentTestManager.getTest().log(Status.INFO, "Step 26: Open Notebooks Page");
        notebooksPage = recentlyViewProductsPage.openNotebooksPageUrl(notebooksPageUrl);

        ExtentTestManager.getTest().log(Status.INFO, "Step 27: Open product detail page ");
        productDetailPage = notebooksPage.openProductDetailPageAtPosition("5");
        productDetailPage.sleepInSecond(1);

        ExtentTestManager.getTest().log(Status.INFO, "Step 28: Get Product Name at Product detail page ");
        productName1 = productDetailPage.getProductNameText();

        ExtentTestManager.getTest().log(Status.INFO, "Step 29: Open recently view product page ");
        recentlyViewProductsPage = productDetailPage.openRecentlyViewProductPage();
        recentlyViewProductsPage.sleepInSecond(3);

        ExtentTestManager.getTest().log(Status.INFO, "Step 24: Verify product name view lastest display at recently view product page ");
        Assert.assertTrue(recentlyViewProductsPage.getProductNameDisplayed().contains(productName1));

        ExtentTestManager.getTest().log(Status.INFO, "Step 31: Verify <=3 product name view lastest display at recently view product page ");
        Assert.assertTrue(recentlyViewProductsPage.checkNumberProductDisplayAtRecentlyViewProductPage());

        ExtentTestManager.getTest().log(Status.INFO, "Step 32: Open Notebooks Page");
        notebooksPage = recentlyViewProductsPage.openNotebooksPageUrl(notebooksPageUrl);
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
    private WishlishPageObject wishlishPage;
    private ShoppingCartPageObject shoppingCartPage;
    private YourWishlistSharingPageObject yourWishlistSharingPage;
    private ComputersPageObject computersPage;
    private NotebooksPageObject notebooksPage;
    private CompareProductsPageObject compareProductsPage;
    private RecentlyViewProductsPageObject recentlyViewProductsPage;
}

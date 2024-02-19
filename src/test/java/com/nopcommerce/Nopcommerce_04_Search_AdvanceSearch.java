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
import pageObject.user.LoginPageObject;
import pageObject.user.RegisterPageObject;
import pageObject.user.SearchPageObject;
import reportConfig.ExtentTestManager;

import java.lang.reflect.Method;

public class Nopcommerce_04_Search_AdvanceSearch extends BaseTest {
    private WebDriver driver;
    private String emailAddress, searchKeyword, category;


    @Parameters({"browser", "userUrl"})
    @BeforeClass
    public void beforeClass(String browserName, String userUrl) {
        driver = getBrowserDriver(browserName, userUrl);
        homePage = PageGeneratorManager.getHomePage(driver);
        registerPage = homePage.openRegisterPage();

        emailAddress = UserData.Register.EMAIL_ADDRESS + generateFakeNumber() + "@gmail.com";
        searchKeyword = "Apple MacBook Pro";
        category = "Computers";

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
        homePage.scrollToSearchLinkInFooter();
        searchPage = homePage.clickToSearchLinkAtFooter();
    }

    @Test
    public void Search_01_Empty_Data(Method method) {
        ExtentTestManager.startTest(method.getName(), "Search_01_Empty_Data");
        ExtentTestManager.getTest().log(Status.INFO, "Search - Step 01: Click to Search button");
        searchPage.clickToSearchButtonAtSearchPage();

        ExtentTestManager.getTest().log(Status.INFO, "Search - Step 02: Verify error message displayed");
        Assert.assertEquals(searchPage.getSearchErrorMessage(), "Search term minimum length is 3 characters");
    }

    @Test
    public void Search_02_Data_Not_Exist(Method method) {
        ExtentTestManager.startTest(method.getName(), "Search_02_Data_Not_Exist");
        ExtentTestManager.getTest().log(Status.INFO, "Search - Step 01: Input to Search Keyword with value is: " + "Macbook Pro 2050");
        searchPage.inputToSearchKeyword("Macbook Pro 2050");

        ExtentTestManager.getTest().log(Status.INFO, "Search - Step 02: Click to Search button");
        searchPage.clickToSearchButtonAtSearchPage();

        ExtentTestManager.getTest().log(Status.INFO, "Search - Step 03: Verify error message displayed");
        Assert.assertEquals(searchPage.getSearchErrorMessage(), "No products were found that matched your criteria.");

    }

    @Test
    public void Search_03_Product_Name_Partial_Mapping(Method method) {
        ExtentTestManager.startTest(method.getName(), "Search_03_Comparative_Product_Name");
        ExtentTestManager.getTest().log(Status.INFO, "Search - Step 01: Input to Search Keyword with value is: " + "Lenovo");
        searchPage.inputToSearchKeyword("Lenovo");

        ExtentTestManager.getTest().log(Status.INFO, "Search - Step 02: Click to Search button");
        searchPage.clickToSearchButtonAtSearchPage();

        ExtentTestManager.getTest().log(Status.INFO, "Search - Step 03: Verify the number of product");
        Assert.assertEquals(searchPage.getNumberOfProduct(), 2);

        ExtentTestManager.getTest().log(Status.INFO, "Search - Step 04: Verify the first of product name  is display");
        Assert.assertEquals(searchPage.getProductNameDisplayedAtTheNumber("1"), "Lenovo IdeaCentre 600 All-in-One PC");

        ExtentTestManager.getTest().log(Status.INFO, "Search - Step 05: Verify the second of product name  is display");
        Assert.assertEquals(searchPage.getProductNameDisplayedAtTheNumber("2"), "Lenovo Thinkpad X1 Carbon Laptop");

    }

    @Test
    public void Search_04_Product_Name_Full_Mapping(Method method) {
        ExtentTestManager.startTest(method.getName(), "Search_04_Product_Name_Full_Mapping");
        ExtentTestManager.getTest().log(Status.INFO, "Search - Step 01: Input to Search Keyword with value is: " + "Thinkpad X1 Carbon");
        searchPage.inputToSearchKeyword("Thinkpad X1 Carbon");

        ExtentTestManager.getTest().log(Status.INFO, "Search - Step 02: Click to Search button");
        searchPage.clickToSearchButtonAtSearchPage();

        ExtentTestManager.getTest().log(Status.INFO, "Search - Step 03: Verify search keyword attribute value displayed");
        Assert.assertEquals(searchPage.getSearchKeywordAttributeValue("value"), "Thinkpad X1 Carbon");

        ExtentTestManager.getTest().log(Status.INFO, "Search - Step 04: Verify the number of product");
        Assert.assertEquals(searchPage.getNumberOfProduct(), 1);

        ExtentTestManager.getTest().log(Status.INFO, "Search - Step 05: Verify the first of product name  is display");
        Assert.assertTrue(searchPage.getProductNameDisplayedAtTheNumber("1").contains("Thinkpad X1 Carbon"));
    }

    @Test
    public void Search_Advanced_05_Parent_Categories(Method method) {
        ExtentTestManager.startTest(method.getName(), "Advanced_Search_05_Parent_Categories");
        ExtentTestManager.getTest().log(Status.INFO, "Advanced_Search- Step 01: Input to Search Keyword with value is: " + searchKeyword);
        searchPage.inputToSearchKeyword(searchKeyword);

        ExtentTestManager.getTest().log(Status.INFO, "Advanced_Search- Step 02: Check to 'Advanced Search' checkbox");
        searchPage.checkToCheckboxOrRadionButtonByLabelName("Advanced search");

        ExtentTestManager.getTest().log(Status.INFO, "Advanced_Search- Step 03: Select to Category dropdown with value is: " + category);
        searchPage.selectToCategoryDropdown(category);

        ExtentTestManager.getTest().log(Status.INFO, "Advanced_Search- Step 04: Uncheck to Automation Search Sub Categories Checkbox");
        searchPage.uncheckToCheckboxByLabelName("Automatically search sub categories");

        ExtentTestManager.getTest().log(Status.INFO, "Advanced_Search - Step 05: Click to Search button");
        searchPage.clickToSearchButtonAtSearchPage();

        ExtentTestManager.getTest().log(Status.INFO, "Advanced_Search - Step 06: Verify search message displayed");
        Assert.assertEquals(searchPage.getSearchErrorMessage(), "No products were found that matched your criteria.");
    }

    @Test
    public void Search_Advanced_06_Sub_Categories(Method method) {
        ExtentTestManager.startTest(method.getName(), "Advanced_Search_06_Sub_Categories");
        ExtentTestManager.getTest().log(Status.INFO, "Advanced_Search- Step 01: Input to Search Keyword with value is: " + searchKeyword);
        searchPage.inputToSearchKeyword(searchKeyword);

        ExtentTestManager.getTest().log(Status.INFO, "Advanced_Search- Step 02: Check to 'Advanced Search' checkbox");
        searchPage.checkToCheckboxOrRadionButtonByLabelName("Advanced search");

        ExtentTestManager.getTest().log(Status.INFO, "Advanced_Search- Step 03: Select to Category dropdown with value is: " + category);
        searchPage.selectToCategoryDropdown(category);

        ExtentTestManager.getTest().log(Status.INFO, "Advanced_Search- Step 04: Check to Automation Search Sub Categories Checkbox");
        searchPage.checkToCheckboxOrRadionButtonByLabelName("Automatically search sub categories");

        ExtentTestManager.getTest().log(Status.INFO, "Advanced_Search - Step 05: Click to Search button");
        searchPage.clickToSearchButtonAtSearchPage();

        ExtentTestManager.getTest().log(Status.INFO, "Advanced_Search - Step 06: Verify the number of product");
        Assert.assertEquals(searchPage.getNumberOfProduct(), 1);

        ExtentTestManager.getTest().log(Status.INFO, "Advanced_Search - Step 07: Verify the first of product name  is display");
        Assert.assertTrue(searchPage.getProductNameDisplayedAtTheNumber("1").contains("Apple MacBook Pro 13-inch"));
    }

    @Test
    public void Search_Advanced_07_Incorrect_Manufacturer(Method method) {
        ExtentTestManager.startTest(method.getName(), "Advanced_Search_06_Sub_Categories");
        ExtentTestManager.getTest().log(Status.INFO, "Advanced_Search- Step 01: Input to Search Keyword with value is: " + searchKeyword);
        searchPage.inputToSearchKeyword(searchKeyword);

        ExtentTestManager.getTest().log(Status.INFO, "Advanced_Search- Step 02: Check to 'Advanced Search' checkbox");
        searchPage.checkToCheckboxOrRadionButtonByLabelName("Advanced search");

        ExtentTestManager.getTest().log(Status.INFO, "Advanced_Search- Step 03: Select to Category dropdown with value is: " + category);
        searchPage.selectToCategoryDropdown(category);

        ExtentTestManager.getTest().log(Status.INFO, "Advanced_Search- Step 04: Check to Automation Search Sub Categories Checkbox");
        searchPage.checkToCheckboxOrRadionButtonByLabelName("Automatically search sub categories");

        ExtentTestManager.getTest().log(Status.INFO, "Advanced_Search- Step 05: Select to Manufacturer dropdown with value is: " + "HP");
        searchPage.selectToManufacturerDropdown("HP");

        ExtentTestManager.getTest().log(Status.INFO, "Advanced_Search - Step 06: Click to Search button");
        searchPage.clickToSearchButtonAtSearchPage();

        ExtentTestManager.getTest().log(Status.INFO, "Advanced_Search - Step 07: Verify search message displayed");
        Assert.assertEquals(searchPage.getSearchErrorMessage(), "No products were found that matched your criteria.");
    }

    @Test
    public void Search_Advanced_08_Correct_Manufacturer(Method method) {
        ExtentTestManager.startTest(method.getName(), "Advanced_Search_06_Sub_Categories");
        ExtentTestManager.getTest().log(Status.INFO, "Advanced_Search- Step 01: Input to Search Keyword with value is: " + searchKeyword);
        searchPage.inputToSearchKeyword(searchKeyword);

        ExtentTestManager.getTest().log(Status.INFO, "Advanced_Search- Step 02: Check to 'Advanced Search' checkbox");
        searchPage.checkToCheckboxOrRadionButtonByLabelName("Advanced search");

        ExtentTestManager.getTest().log(Status.INFO, "Advanced_Search- Step 03: Select to Category dropdown with value is: " + category);
        searchPage.selectToCategoryDropdown(category);

        ExtentTestManager.getTest().log(Status.INFO, "Advanced_Search- Step 04: Check to Automation Search Sub Categories Checkbox");
        searchPage.checkToCheckboxOrRadionButtonByLabelName("Automatically search sub categories");

        ExtentTestManager.getTest().log(Status.INFO, "Advanced_Search- Step 05: Select to Manufacturer dropdown with value is: " + "Apple");
        searchPage.selectToManufacturerDropdown("Apple");

        ExtentTestManager.getTest().log(Status.INFO, "Advanced_Search - Step 06: Click to Search button");
        searchPage.clickToSearchButtonAtSearchPage();

        ExtentTestManager.getTest().log(Status.INFO, "Advanced_Search - Step 07: Verify the number of product");
        Assert.assertEquals(searchPage.getNumberOfProduct(), 1);

        ExtentTestManager.getTest().log(Status.INFO, "Advanced_Search - Step 08: Verify the first of product name  is display");
        Assert.assertTrue(searchPage.getProductNameDisplayedAtTheNumber("1").contains("Apple MacBook Pro 13-inch"));
    }

    @AfterClass(alwaysRun = true)
    public void afterClass() {
        closeBrowserDriver();
    }

    private HomePageObject homePage;
    private RegisterPageObject registerPage;
    private LoginPageObject loginPage;
    private SearchPageObject searchPage;
}

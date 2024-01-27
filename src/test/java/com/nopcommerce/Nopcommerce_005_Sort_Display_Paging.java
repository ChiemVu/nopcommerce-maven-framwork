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
import pageObject.ComputersPageObject;
import pageObject.HomePageObject;
import pageObject.NotebooksPageObject;
import reportConfig.ExtentTestManager;

import java.lang.reflect.Method;

public class Nopcommerce_005_Sort_Display_Paging extends BaseTest {
    private WebDriver driver;

    @Parameters({"browser", "url"})
    @BeforeClass
    public void beforeClass(String browserName, String urlName) {
        driver = getBrowserDriver(browserName, urlName);
        homePage = PageGeneratorManager.getHomePage(driver);
        computersPage = homePage.clickToComputerHeaderMenu();
        notebooksPage = computersPage.clickToNotebooksNavigationSubmenu();
    }

    @Test
    public void TC_01_Sort_Name_Asc(Method method) {
        ExtentTestManager.startTest(method.getName(), "TC_01_Sort_Name_Asc");
        ExtentTestManager.getTest().log(Status.INFO, "Step 01: Ascending Name (A-Z)");
        notebooksPage.selectItemSortDropdown("Name: A to Z", "products-orderby");
        notebooksPage.sleepInSecond(3);

        ExtentTestManager.getTest().log(Status.INFO, "Step 02: Verify product name sort is Ascending (A-Z)");
        Assert.assertTrue(notebooksPage.isProductNameSortAscending());
    }

    @Test
    public void TC_02_Sort_Name_Desc(Method method) {
        ExtentTestManager.startTest(method.getName(), "TC_02_Sort_Name_Desc");
        ExtentTestManager.getTest().log(Status.INFO, "Step 01: Descending Name (Z-A)");
        notebooksPage.selectItemSortDropdown("Name: Z to A", "products-orderby");
        notebooksPage.sleepInSecond(3);

        ExtentTestManager.getTest().log(Status.INFO, "Step 02: Verify product name sort is Descending (Z-A)");
        Assert.assertTrue(notebooksPage.isProductNameSortDescending());
    }

    @Test
    public void TC_03_Sort_Price_Desc(Method method) {
        ExtentTestManager.startTest(method.getName(), "TC_03_Sort_Price_Desc");
        ExtentTestManager.getTest().log(Status.INFO, "Step 01: Descending Price (High to Low)");
        notebooksPage.selectItemSortDropdown("Price: High to Low", "products-orderby");
        notebooksPage.sleepInSecond(3);

        ExtentTestManager.getTest().log(Status.INFO, "Step 02: Verify product price sort is Descending");
        Assert.assertTrue(notebooksPage.isProductPriceSortDescending());
    }

    @Test
    public void TC_04_Sort_Price_Asc(Method method) {
        ExtentTestManager.startTest(method.getName(), "TC_04_Sort_Price_Asc");
        ExtentTestManager.getTest().log(Status.INFO, "Step 01: Ascending Price (Low to High)");
        notebooksPage.selectItemSortDropdown("Price: Low to High", "products-orderby");
        notebooksPage.sleepInSecond(3);

        ExtentTestManager.getTest().log(Status.INFO, "Step 02: Verify product price sort is Ascending");
        Assert.assertTrue(notebooksPage.isProductPriceSortAscending());
    }

    @Test
    public void TC_05_Display_3_Per_Page(Method method) {
        ExtentTestManager.startTest(method.getName(), "TC_05_Display_3_Per_Page");
        ExtentTestManager.getTest().log(Status.INFO, "Step 01: Select display 3 per page dropdown");
        notebooksPage.selectItemSortDropdown("3", "products-pagesize");
        notebooksPage.sleepInSecond(3);

        ExtentTestManager.getTest().log(Status.INFO, "Step 02: Verify the number of product displayed ");
        Assert.assertTrue(notebooksPage.checkNumberProductDisplayBySelectDisplayNumberPerPageDropdown("products-pagesize"));

        ExtentTestManager.getTest().log(Status.INFO, "Step 03: Verify next paging icon displayed ");
        Assert.assertTrue(notebooksPage.isNextPagingIconDisplayed());

        ExtentTestManager.getTest().log(Status.INFO, "Step 04: Click next paging icon ");
        notebooksPage.clickToNextPagingIcon();

        ExtentTestManager.getTest().log(Status.INFO, "Step 05: Verify previous paging icon displayed ");
        Assert.assertTrue(notebooksPage.isPreviousPagingIconDisplayed());
    }

    @Test
    public void TC_06_Display_6_Per_Page(Method method) {
        ExtentTestManager.startTest(method.getName(), "TC_06_Display_6_Per_Page");
        ExtentTestManager.getTest().log(Status.INFO, "Step 01: Select display 6 per page dropdown");
        notebooksPage.selectItemSortDropdown("6", "products-pagesize");
        notebooksPage.sleepInSecond(3);

        ExtentTestManager.getTest().log(Status.INFO, "Step 02: Verify the number of product displayed ");
        Assert.assertTrue(notebooksPage.checkNumberProductDisplayBySelectDisplayNumberPerPageDropdown("products-pagesize"));

        ExtentTestManager.getTest().log(Status.INFO, "Step 03: Verify next paging icon undisplayed ");
        Assert.assertTrue(notebooksPage.isNextPagingIconUndisplayed());
    }

    //@Test
    public void TC_07_Display_9_Per_Page(Method method) {
        ExtentTestManager.startTest(method.getName(), "TC_07_Display_9_Per_Page");
        ExtentTestManager.getTest().log(Status.INFO, "Step 01: Select display 9 per page dropdown");
        notebooksPage.selectItemSortDropdown("9", "products-pagesize");
        notebooksPage.sleepInSecond(3);

        ExtentTestManager.getTest().log(Status.INFO, "Step 02: Verify the number of product displayed ");
        Assert.assertTrue(notebooksPage.checkNumberProductDisplayBySelectDisplayNumberPerPageDropdown("products-pagesize"));

        ExtentTestManager.getTest().log(Status.INFO, "Step 03: Verify next paging icon undisplayed ");
        Assert.assertTrue(notebooksPage.isNextPagingIconUndisplayed());
    }


    @AfterClass(alwaysRun = true)
    public void afterClass() {
        closeBrowserDriver();
    }

    private HomePageObject homePage;
    private ComputersPageObject computersPage;
    private NotebooksPageObject notebooksPage;
}

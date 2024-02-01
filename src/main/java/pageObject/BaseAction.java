package pageObject;

import commons.BasePage;
import commons.PageGeneratorManager;
import org.openqa.selenium.WebDriver;
import pageUIs.BaseActionPageUI;
import pageUIs.HomePageUI;
import pageUIs.SearchPageUI;

public class BaseAction extends BasePage {
    WebDriver driver;

    public BaseAction(WebDriver driver) {
        this.driver = driver;
    }

    public AddressPageObject openAddressPage(WebDriver driver) {
        waitForElementClickable(driver, BaseActionPageUI.ADDRESS_LINK);
        clickToElement(driver, BaseActionPageUI.ADDRESS_LINK);
        return PageGeneratorManager.getAddressPage(driver);
    }

    public ChangePasswordPageObject openChangePasswordPage(WebDriver driver) {
        waitForElementClickable(driver, BaseActionPageUI.CHANGE_PASSWORD_LINK);
        clickToElement(driver, BaseActionPageUI.CHANGE_PASSWORD_LINK);
        return PageGeneratorManager.getChangePasswordPage(driver);
    }


    public MyProductReviewPageObject openMyProductReviewPage(WebDriver driver) {
        waitForElementClickable(driver, BaseActionPageUI.MY_PRODUCT_REVIEW_LINK);
        clickToElement(driver, BaseActionPageUI.MY_PRODUCT_REVIEW_LINK);
        return PageGeneratorManager.getMyProductReviewPage(driver);
    }


    public HomePageObject clickToLogoutLink() {
        waitForElementClickable(driver, BaseActionPageUI.LOGOUT_LINK);
        clickToElement(driver, BaseActionPageUI.LOGOUT_LINK);
        return PageGeneratorManager.getHomePage(driver);
    }

    public LoginPageObject clickLoginLink() {
        waitForElementClickable(driver, BaseActionPageUI.LOGIN_LINK);
        clickToElement(driver, BaseActionPageUI.LOGIN_LINK);
        return PageGeneratorManager.getLoginPage(driver);
    }

    public CustomerInfoPageObject clickToMyAccountLink() {
        waitForElementClickable(driver, HomePageUI.MY_ACCOUNT_LINK);
        clickToElement(driver, HomePageUI.MY_ACCOUNT_LINK);
        return PageGeneratorManager.getCustomerInfoPage(driver);
    }

    public void inputToSearchTextbox(String searchValue) {
        waitForElementVisible(driver, BaseActionPageUI.SEARCH_TEXTBOX);
        sendKeyToElement(driver, BaseActionPageUI.SEARCH_TEXTBOX, searchValue);
    }

    public SearchPageObject clickToSearchButtonAtHeader() {
        waitForElementClickable(driver, BaseActionPageUI.SEARCH_BUTTON_AT_HEADER);
        clickToElement(driver, BaseActionPageUI.SEARCH_BUTTON_AT_HEADER);
        return PageGeneratorManager.getSearchPage(driver);
    }

    public SearchPageObject clickToSearchLinkAtFooter() {
        waitForElementClickable(driver, BaseActionPageUI.SEARCH_LINK_AT_FOOTER);
        clickToElement(driver, BaseActionPageUI.SEARCH_LINK_AT_FOOTER);
        return PageGeneratorManager.getSearchPage(driver);
    }

    public void checkToCheckboxByLabelName(String checkboxLabelName) {
        if (!isElementSelected(driver, BaseActionPageUI.DYNAMIC_CHECKBOX_BY_LABEL_NAME, checkboxLabelName)) {
            clickToElement(driver, BaseActionPageUI.DYNAMIC_CHECKBOX_BY_LABEL_NAME, checkboxLabelName);
        }
    }

    public void uncheckToCheckboxByLabelName(String checkboxLabelName) {
        if (isElementSelected(driver, BaseActionPageUI.DYNAMIC_CHECKBOX_BY_LABEL_NAME, checkboxLabelName)) {
            clickToElement(driver, BaseActionPageUI.DYNAMIC_CHECKBOX_BY_LABEL_NAME, checkboxLabelName);
        }
    }

    public ComputersPageObject clickToComputerHeaderMenu() {
        waitForElementClickable(driver, BaseActionPageUI.COMPUTER_HEADER_MENU);
        clickToElement(driver, BaseActionPageUI.COMPUTER_HEADER_MENU);
        return PageGeneratorManager.getComputersPage(driver);
    }

    public NotebooksPageObject clickToNotebooksNavigationSubmenu() {
        waitForElementClickable(driver, BaseActionPageUI.NAVIGATION_NOTEBOOKS_SUBMENU);
        clickToElement(driver, BaseActionPageUI.NAVIGATION_NOTEBOOKS_SUBMENU);
        return PageGeneratorManager.getNotebooksPage(driver);
    }

    public long getNumberOfProduct() {
        return getElementSize(driver, BaseActionPageUI.NUMBER_PRODUCT);
    }

    public String getMessageDisplayed() {
        waitForElementVisible(driver, BaseActionPageUI.MESSAGE_DISPLAYED);
        return getElementText(driver, BaseActionPageUI.MESSAGE_DISPLAYED);

    }

    public void clickToCloseIcon() {
        waitForElementClickable(driver, BaseActionPageUI.CLOSE_ICON);
        clickToElement(driver, BaseActionPageUI.CLOSE_ICON);
    }

    public WishlishPageObject clickToWishlistLink() {
        waitForElementClickable(driver, BaseActionPageUI.WISHLIST_LINK);
        clickToElement(driver, BaseActionPageUI.WISHLIST_LINK);
        return PageGeneratorManager.getWishlishPage(driver);
    }

    public String getProductNameDisplayedAtTheNumber(String productNumber) {
        waitForElementVisible(driver, BaseActionPageUI.DYNAMIC_PRODUCT_NAME_AT_THE_NUMBER, productNumber);
        return getElementText(driver, BaseActionPageUI.DYNAMIC_PRODUCT_NAME_AT_THE_NUMBER, productNumber);
    }


    public String getPriceProductNameDisplayedAtTheNumber(String productName) {
        waitForElementVisible(driver, BaseActionPageUI.DYNAMIC_PRICE_AT_PRODUCT_NAME, productName);
        return getElementText(driver, BaseActionPageUI.DYNAMIC_PRICE_AT_PRODUCT_NAME, productName);
    }

    public void clickAddToCompareListIconByProductName(String productName) {
        waitForElementClickable(driver, BaseActionPageUI.DYNAMIC_ADD_TO_COMPARE_LIST_AT_PRODUCT_NAME, productName);
        clickToElement(driver, BaseActionPageUI.DYNAMIC_ADD_TO_COMPARE_LIST_AT_PRODUCT_NAME, productName);
    }

    public CompareProductsPageObject clickToProductComparisonLink() {
        waitForElementClickable(driver, BaseActionPageUI.PRODUCT_COMPARISON_LINK);
        clickToElement(driver, BaseActionPageUI.PRODUCT_COMPARISON_LINK);
        return PageGeneratorManager.getCompareProductsPage(driver);
    }

    public ProductDetailPageObject openProductDetailPageAtPosition(String productNumber) {
        waitForElementClickable(driver, BaseActionPageUI.DYNAMIC_PRODUCT_NAME_AT_THE_NUMBER, productNumber);
        clickToElement(driver, BaseActionPageUI.DYNAMIC_PRODUCT_NAME_AT_THE_NUMBER, productNumber);
        return PageGeneratorManager.getProductDetailPage(driver);
    }

    public NotebooksPageObject openNotebooksPageUrl(String notebooksPageUrl) {
        openPageUrl(driver, notebooksPageUrl);
        return PageGeneratorManager.getNotebooksPage(driver);
    }

    public RecentlyViewProductsPageObject openRecentlyViewProductPage() {
        waitForElementClickable(driver, BaseActionPageUI.RECENTLY_VIEWED_PRODUCT_FOOTER_MENU);
        clickToElement(driver, BaseActionPageUI.RECENTLY_VIEWED_PRODUCT_FOOTER_MENU);
        return PageGeneratorManager.getRecentlyViewProductsPage(driver);
    }
}

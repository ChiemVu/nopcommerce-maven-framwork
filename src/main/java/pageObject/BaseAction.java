package pageObject;

import commons.BasePage;
import commons.PageGeneratorManager;
import org.openqa.selenium.WebDriver;
import pageUIs.BaseActionPageUI;
import pageUIs.HomePageUI;

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

}

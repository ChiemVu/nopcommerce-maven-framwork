package pageObject.user;

import commons.PageGeneratorManager;
import org.openqa.selenium.WebDriver;
import pageUIs.user.AddressPageUI;

public class AddressPageObject extends BaseAction {
    WebDriver driver;

    public AddressPageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }


    public boolean isMyAccountAddressPageTitle() {
        waitForElementVisible(driver, AddressPageUI.MY_ACCOUNT_ADDRESS_PAGE_TITLE);
        return isElementDisplayed(driver, AddressPageUI.MY_ACCOUNT_ADDRESS_PAGE_TITLE);
    }

    public AddNewAddressPageObject clickToAddNewButton() {
        waitForElementClickable(driver, AddressPageUI.ADD_NEW_BUTTON);
        clickToElement(driver, AddressPageUI.ADD_NEW_BUTTON);
        return PageGeneratorManager.getAddNewAddressPage(driver);
    }

    public String getAddNewAddressSuccessMessage() {
        waitForElementVisible(driver, AddressPageUI.ADD_NEW_SUCCESS_MESSAGE);
        return getElementText(driver, AddressPageUI.ADD_NEW_SUCCESS_MESSAGE);
    }

    public String getTitleNameDisplayed() {
        waitForElementVisible(driver, AddressPageUI.TITLE_NAME);
        return getElementText(driver, AddressPageUI.TITLE_NAME);
    }

    public String getNameDisplayed() {
        waitForElementVisible(driver, AddressPageUI.NAME);
        return getElementText(driver, AddressPageUI.NAME);
    }

    public String getEmailDisplayed() {
        waitForElementVisible(driver, AddressPageUI.EMAIL);
        return getElementText(driver, AddressPageUI.EMAIL);
    }

    public String getPhoneNumberDisplayed() {
        waitForElementVisible(driver, AddressPageUI.PHONE_NUMBER);
        return getElementText(driver, AddressPageUI.PHONE_NUMBER);
    }

    public String getFaxNumberDisplayed() {
        waitForElementVisible(driver, AddressPageUI.FAX_NUMBER);
        return getElementText(driver, AddressPageUI.FAX_NUMBER);
    }

    public String getCompanyDisplayed() {
        waitForElementVisible(driver, AddressPageUI.COMPANY);
        return getElementText(driver, AddressPageUI.COMPANY);
    }

    public String getAddress1Displayed() {
        waitForElementVisible(driver, AddressPageUI.ADDRESS_1);
        return getElementText(driver, AddressPageUI.ADDRESS_1);
    }

    public String getAddress2Displayed() {
        waitForElementVisible(driver, AddressPageUI.ADDRESS_2);
        return getElementText(driver, AddressPageUI.ADDRESS_2);
    }

    public String getCityStateZipDisplayed() {
        waitForElementVisible(driver, AddressPageUI.CITY_STATE_ZIP);
        return getElementText(driver, AddressPageUI.CITY_STATE_ZIP);
    }

    public String getCountryDisplayed() {
        waitForElementVisible(driver, AddressPageUI.COUNTRY);
        return getElementText(driver, AddressPageUI.COUNTRY);
    }


}

package pageObject.user;

import commons.PageGeneratorManager;
import org.openqa.selenium.WebDriver;
import pageUIs.user.AddNewAddressPageUI;

public class AddNewAddressPageObject extends BaseAction {
    WebDriver driver;

    public AddNewAddressPageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public boolean isMyAccountAddNewAddressPageTitle() {
        waitForElementVisible(driver, AddNewAddressPageUI.MY_ACCOUNT_ADD_NEW_ADDRESS_PAGE_TITLE);
        return isElementDisplayed(driver, AddNewAddressPageUI.MY_ACCOUNT_ADD_NEW_ADDRESS_PAGE_TITLE);
    }

    public void inputToFirstNameTextbox(String firstname) {
        waitForElementVisible(driver, AddNewAddressPageUI.FIRSTNAME_TEXTBOX);
        sendKeyToElement(driver, AddNewAddressPageUI.FIRSTNAME_TEXTBOX, firstname);
    }

    public void inputToLastNameTextbox(String lastname) {
        waitForElementVisible(driver, AddNewAddressPageUI.LASTNAME_TEXTBOX);
        sendKeyToElement(driver, AddNewAddressPageUI.LASTNAME_TEXTBOX, lastname);
    }

    public void inputToEmailTextbox(String email) {
        waitForElementVisible(driver, AddNewAddressPageUI.EMAIL_TEXTBOX);
        sendKeyToElement(driver, AddNewAddressPageUI.EMAIL_TEXTBOX, email);
    }

    public void inputToCompanyTextbox(String company) {
        waitForElementVisible(driver, AddNewAddressPageUI.COMPANY_TEXTBOX);
        sendKeyToElement(driver, AddNewAddressPageUI.COMPANY_TEXTBOX, company);
    }

    public void inputToContryDropdown(String country) {
        waitForElementClickable(driver, AddNewAddressPageUI.COUNTRY_DROPDOWN);
        selectItemInDefaultDropdown(driver, AddNewAddressPageUI.COUNTRY_DROPDOWN, country);
    }

    public void inputToStateProvinceDropdown(String stateProvince) {
        waitForElementClickable(driver, AddNewAddressPageUI.STATE_PROVINCE_DROPDOWN);
        selectItemInDefaultDropdown(driver, AddNewAddressPageUI.STATE_PROVINCE_DROPDOWN, stateProvince);
    }

    public void inputToCityTextbox(String city) {
        waitForElementVisible(driver, AddNewAddressPageUI.CITY_TEXTBOX);
        sendKeyToElement(driver, AddNewAddressPageUI.CITY_TEXTBOX, city);
    }

    public void inputToAddress1Textbox(String address1) {
        waitForElementVisible(driver, AddNewAddressPageUI.ADDRESS_1_TEXTBOX);
        sendKeyToElement(driver, AddNewAddressPageUI.ADDRESS_1_TEXTBOX, address1);
    }

    public void inputToAddress2Textbox(String address2) {
        waitForElementVisible(driver, AddNewAddressPageUI.ADDRESS_2_TEXTBOX);
        sendKeyToElement(driver, AddNewAddressPageUI.ADDRESS_2_TEXTBOX, address2);
    }

    public void inputToZipPostalCodeTextbox(String zipPostalCode) {
        waitForElementVisible(driver, AddNewAddressPageUI.ZIP_POSTAL_CODE_TEXTBOX);
        sendKeyToElement(driver, AddNewAddressPageUI.ZIP_POSTAL_CODE_TEXTBOX, zipPostalCode);
    }

    public void inputToPhoneNumberTextbox(String phoneNumber) {
        waitForElementVisible(driver, AddNewAddressPageUI.PHONE_NUMBER_TEXTBOX);
        sendKeyToElement(driver, AddNewAddressPageUI.PHONE_NUMBER_TEXTBOX, phoneNumber);
    }

    public void inputToFaxNumberTextbox(String faxNumber) {
        waitForElementVisible(driver, AddNewAddressPageUI.FAX_NUMBER_TEXTBOX);
        sendKeyToElement(driver, AddNewAddressPageUI.FAX_NUMBER_TEXTBOX, faxNumber);
    }

    public AddressPageObject clickToSaveButton() {
        waitForElementClickable(driver, AddNewAddressPageUI.SAVE_BUTTON);
        clickToElement(driver, AddNewAddressPageUI.SAVE_BUTTON);
        return PageGeneratorManager.getAddressPage(driver);
    }
}

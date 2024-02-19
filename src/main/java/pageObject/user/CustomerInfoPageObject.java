package pageObject.user;

import org.openqa.selenium.WebDriver;
import pageUIs.user.CustomerInfoPageUI;

public class CustomerInfoPageObject extends BaseAction {
    WebDriver driver;

    public CustomerInfoPageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void selectToGenderRadioButton(String gender) {
        waitForElementVisible(driver, CustomerInfoPageUI.GENDER_RADIO_BUTTON);
        checkToDefaultCheckboxOrRadio(driver, CustomerInfoPageUI.GENDER_RADIO_BUTTON);
    }

    public void inputToFirtnameTextbox(String firstname) {
        waitForElementVisible(driver, CustomerInfoPageUI.FIRSTNAME_TEXTBOX);
        sendKeyToElement(driver, CustomerInfoPageUI.FIRSTNAME_TEXTBOX, firstname);
    }

    public void inputToLastnameTextbox(String lastname) {
        waitForElementVisible(driver, CustomerInfoPageUI.LASTNAME_TEXTBOX);
        sendKeyToElement(driver, CustomerInfoPageUI.LASTNAME_TEXTBOX, lastname);
    }

    public void selectDropdownByAttributeName(String dropdownAttributeName, String dropdownValue) {
        waitForElementClickable(driver, CustomerInfoPageUI.DYNAMIC_DROPDOWN_BY_ATTRIBUTE_NAME, dropdownAttributeName);
        selectItemInDefaultDropdown(driver, CustomerInfoPageUI.DYNAMIC_DROPDOWN_BY_ATTRIBUTE_NAME, dropdownValue, dropdownAttributeName);
    }

    public void inputToEnailTextbox(String emailAddress) {
        waitForElementVisible(driver, CustomerInfoPageUI.EMAIL_TEXTBOX);
        sendKeyToElement(driver, CustomerInfoPageUI.EMAIL_TEXTBOX, emailAddress);
    }

    public void inputToCompanyNameTextbox(String companyName) {
        waitForElementVisible(driver, CustomerInfoPageUI.COMPANY_NAME_TEXTBOX);
        sendKeyToElement(driver, CustomerInfoPageUI.COMPANY_NAME_TEXTBOX, companyName);
    }

    public void clickToSaveButton() {
        waitForElementClickable(driver, CustomerInfoPageUI.SAVE_BUTTON);
        clickToElement(driver, CustomerInfoPageUI.SAVE_BUTTON);
    }

    public String getCustomerInfoUpdateSuccessMessage() {
        waitForElementVisible(driver, CustomerInfoPageUI.CUSTOMER_INFO_UPDATE_SUCCESS_MESSAGE);
        return getElementText(driver, CustomerInfoPageUI.CUSTOMER_INFO_UPDATE_SUCCESS_MESSAGE);
    }


    public boolean isGenderRadioButtonIschecked() {
        return isElementSelected(driver, CustomerInfoPageUI.GENDER_RADIO_BUTTON);
    }

    public String getFirstNameValue() {
        waitForElementVisible(driver, CustomerInfoPageUI.FIRSTNAME_TEXTBOX);
        return getElementAttribute(driver, CustomerInfoPageUI.FIRSTNAME_TEXTBOX, "value");
    }

    public String getLastNameValue() {
        waitForElementVisible(driver, CustomerInfoPageUI.LASTNAME_TEXTBOX);
        return getElementAttribute(driver, CustomerInfoPageUI.LASTNAME_TEXTBOX, "value");
    }


    public String getSelectedTextAtDropdownAttributeName(String dropdownAttributeName) {
        return getElementText(driver, CustomerInfoPageUI.DYNAMIC_SELECTED_TEXT_DROPDOWN_BY_ATTRIBUTE_NAME, dropdownAttributeName);
    }

    public String getEmailValue() {
        waitForElementVisible(driver, CustomerInfoPageUI.EMAIL_TEXTBOX);
        return getElementAttribute(driver, CustomerInfoPageUI.EMAIL_TEXTBOX, "value");
    }

    public String getCompanyNameValue() {
        waitForElementVisible(driver, CustomerInfoPageUI.COMPANY_NAME_TEXTBOX);
        return getElementAttribute(driver, CustomerInfoPageUI.COMPANY_NAME_TEXTBOX, "value");
    }
}

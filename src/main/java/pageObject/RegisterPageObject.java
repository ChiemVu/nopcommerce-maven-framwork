package pageObject;

import commons.BasePage;
import commons.PageGeneratorManager;
import org.openqa.selenium.WebDriver;
import pageUIs.RegisterPageUI;

public class RegisterPageObject extends BaseAction {
    private WebDriver driver;

    public RegisterPageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public RegisterPageObject openRegisterPageUrl(String registerPageUrl) {
        openPageUrl(driver, registerPageUrl);
        return PageGeneratorManager.getRegisterPage(driver);
    }

    public void clickToRegisterButton() {
        waitForElementClickable(driver, RegisterPageUI.REGISTER_BUTTON);
        clickToElement(driver, RegisterPageUI.REGISTER_BUTTON);
    }

    public String getFirstNameErrorMessage() {
        waitForElementVisible(driver, RegisterPageUI.FIRSTNAME_ERROR_MESSAGE);
        return getElementText(driver, RegisterPageUI.FIRSTNAME_ERROR_MESSAGE);
    }

    public String getLastNameErrorMessage() {
        waitForElementVisible(driver, RegisterPageUI.LASTNAME_ERROR_MESSAGE);
        return getElementText(driver, RegisterPageUI.LASTNAME_ERROR_MESSAGE);
    }

    public String getEmailErrorMessage() {
        waitForElementVisible(driver, RegisterPageUI.EMAIL_ERROR_MESSAGE);
        return getElementText(driver, RegisterPageUI.EMAIL_ERROR_MESSAGE);
    }

    public String getPasswordErrorMessage() {
        waitForElementVisible(driver, RegisterPageUI.PASSWORD_ERROR_MESSAGE);
        return getElementText(driver, RegisterPageUI.PASSWORD_ERROR_MESSAGE);
    }

    public String getConfirmPasswordErrorMessage() {
        waitForElementVisible(driver, RegisterPageUI.CONFRIM_PASSWORD_ERROR_MESSAGE);
        return getElementText(driver, RegisterPageUI.CONFRIM_PASSWORD_ERROR_MESSAGE);
    }

    public String getRegisterSuccessMesage() {
        waitForElementVisible(driver, RegisterPageUI.REGISTER_SUCCESS_MESSAGE);
        return getElementText(driver, RegisterPageUI.REGISTER_SUCCESS_MESSAGE);
    }

    public String getExistingEmailErrorMessage() {
        waitForElementVisible(driver, RegisterPageUI.EXISTING_EMAIL_MESSAGE);
        return getElementText(driver, RegisterPageUI.EXISTING_EMAIL_MESSAGE);
    }

    public void clickToGenderRadioBuntton(String gender) {
        waitForElementClickable(driver, RegisterPageUI.GENDER_RADIO_BUTTON);
        checkToDefaultCheckboxOrRadio(driver, RegisterPageUI.GENDER_RADIO_BUTTON);
    }

    public void inputToFirstNameTextbox(String firstName) {
        waitForElementVisible(driver, RegisterPageUI.FIRSTNAME_TEXTBOX);
        sendKeyToElement(driver, RegisterPageUI.FIRSTNAME_TEXTBOX, firstName);
    }

    public void inputToLastNameTextbox(String lastName) {
        waitForElementVisible(driver, RegisterPageUI.LASTNAME_TEXTBOX);
        sendKeyToElement(driver, RegisterPageUI.LASTNAME_TEXTBOX, lastName);
    }

    public void selectToDropdownByName(String dropdownAttributeName, String dropdownValue) {
        waitForElementClickable(driver, RegisterPageUI.DYNAMIC_DROPDOWN_BY_NAME, dropdownAttributeName);
        selectItemInDefaultDropdown(driver, RegisterPageUI.DYNAMIC_DROPDOWN_BY_NAME, dropdownValue, dropdownAttributeName);
    }

    public void inputEmailTextbox(String email) {
        waitForElementVisible(driver, RegisterPageUI.EMAIL_TEXTBOX);
        sendKeyToElement(driver, RegisterPageUI.EMAIL_TEXTBOX, email);
    }

    public void clickToNewsletterCheckbox() {
        waitForElementClickable(driver, RegisterPageUI.NEWSLETTER_CHECKBOX);
        checkToDefaultCheckboxOrRadio(driver, RegisterPageUI.NEWSLETTER_CHECKBOX);
    }

    public void inputPasswordTextbox(String password) {
        waitForElementVisible(driver, RegisterPageUI.PASSWORD_TEXTBOX);
        sendKeyToElement(driver, RegisterPageUI.PASSWORD_TEXTBOX, password);
    }

    public void inputConfirmPasswordTextbox(String password) {
        waitForElementVisible(driver, RegisterPageUI.CONFIRM_PASSWORD_TEXTBOX);
        sendKeyToElement(driver, RegisterPageUI.CONFIRM_PASSWORD_TEXTBOX, password);
    }

    public LoginPageObject openLoginPage() {
        waitForElementClickable(driver, RegisterPageUI.LOGIN_LINK);
        clickToElement(driver, RegisterPageUI.LOGIN_LINK);
        return PageGeneratorManager.getLoginPage(driver);
    }
}

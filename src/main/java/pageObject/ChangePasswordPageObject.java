package pageObject;

import org.openqa.selenium.WebDriver;
import pageUIs.ChangePasswordPageUI;

public class ChangePasswordPageObject extends BaseAction {
    WebDriver driver;

    public ChangePasswordPageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void inputToOldPasswordTextbox(String password) {
        waitForElementVisible(driver, ChangePasswordPageUI.OLD_PASSWORD_TEXTBOX);
        sendKeyToElement(driver, ChangePasswordPageUI.OLD_PASSWORD_TEXTBOX, password);
    }

    public void inputToNewPasswordTextbox(String newPassword) {
        waitForElementVisible(driver, ChangePasswordPageUI.NEW_PASSWORD_TEXTBOX);
        sendKeyToElement(driver, ChangePasswordPageUI.NEW_PASSWORD_TEXTBOX, newPassword);
    }

    public void inputToConfirmPasswordTextbox(String newPassword) {
        waitForElementVisible(driver, ChangePasswordPageUI.CONFIRM_PASSWORD_TEXTBOX);
        sendKeyToElement(driver, ChangePasswordPageUI.CONFIRM_PASSWORD_TEXTBOX, newPassword);
    }

    public void clickToChangePasswordButton() {
        waitForElementClickable(driver, ChangePasswordPageUI.CHANGE_PASSWORD_BUTTON);
        clickToElement(driver, ChangePasswordPageUI.CHANGE_PASSWORD_BUTTON);
    }

    public String getChangePasswordSuccessMessage() {
        waitForElementVisible(driver, ChangePasswordPageUI.CHANGE_PASSWORD_SUCCESS_MESSAGE);
        return getElementText(driver, ChangePasswordPageUI.CHANGE_PASSWORD_SUCCESS_MESSAGE);

    }

    public void clickToCloseIcon() {
        waitForElementClickable(driver, ChangePasswordPageUI.CLOSE_ICON);
        clickToElement(driver, ChangePasswordPageUI.CLOSE_ICON);
    }
}

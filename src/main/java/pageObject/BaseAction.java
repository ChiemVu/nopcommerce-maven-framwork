package pageObject;

import commons.BasePage;
import commons.PageGeneratorManager;
import org.openqa.selenium.WebDriver;
import pageUIs.BaseActionPageUI;
import pageUIs.RegisterPageUI;

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

    public HomePageObject clickToLogoutLink() {
        waitForElementClickable(driver, BaseActionPageUI.LOGOUT_LINK);
        clickToElement(driver, BaseActionPageUI.LOGOUT_LINK);
        return PageGeneratorManager.getHomePage(driver);
    }

    public LoginPageObject openLoginPage() {
        waitForElementClickable(driver, BaseActionPageUI.LOGIN_LINK);
        clickToElement(driver, BaseActionPageUI.LOGIN_LINK);
        return PageGeneratorManager.getLoginPage(driver);
    }
}

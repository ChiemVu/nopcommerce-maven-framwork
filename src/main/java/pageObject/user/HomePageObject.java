package pageObject.user;

import commons.PageGeneratorManager;
import org.openqa.selenium.WebDriver;
import pageUIs.user.BaseActionPageUI;
import pageUIs.user.HomePageUI;

public class HomePageObject extends BaseAction {
    private WebDriver driver;

    public HomePageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public RegisterPageObject openRegisterPage() {
        waitForElementClickable(driver, HomePageUI.REGISTER_LINK);
        clickToElement(driver, HomePageUI.REGISTER_LINK);
        return PageGeneratorManager.getRegisterPage(driver);
    }


    public boolean isMyAccountLinkDisplayed() {
        waitForElementVisible(driver, HomePageUI.MY_ACCOUNT_LINK);
        return isElementDisplayed(driver, HomePageUI.MY_ACCOUNT_LINK);
    }

    public boolean isRegisterLinkDisplayed() {
        waitForElementVisible(driver, HomePageUI.REGISTER_LINK);
        return isElementDisplayed(driver, HomePageUI.REGISTER_LINK);
    }

    public void scrollToSearchLinkInFooter() {
        waitForElementVisible(driver, BaseActionPageUI.SEARCH_LINK_AT_FOOTER);
        scrollToElement(driver, BaseActionPageUI.SEARCH_LINK_AT_FOOTER);
    }
}

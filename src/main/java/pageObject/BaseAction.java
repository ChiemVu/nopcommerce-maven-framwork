package pageObject;

import commons.BasePage;
import commons.PageGeneratorManager;
import org.openqa.selenium.WebDriver;
import pageUIs.BaseActionPageUI;

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
}

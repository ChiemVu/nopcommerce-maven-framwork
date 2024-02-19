package pageObject.user;

import org.openqa.selenium.WebDriver;
import pageUIs.user.CompareProductsPageUI;

public class CompareProductsPageObject extends BaseAction {
    private WebDriver driver;

    public CompareProductsPageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public String getProductInformationDisplayed() {
        waitForElementVisible(driver, CompareProductsPageUI.PRODUCT_INFORMATION);
        return getElementText(driver, CompareProductsPageUI.PRODUCT_INFORMATION);
    }

    public void clickToClearListButton() {
        waitForElementClickable(driver, CompareProductsPageUI.CLEAR_LIST_BUTTON);
        clickToElement(driver, CompareProductsPageUI.CLEAR_LIST_BUTTON);
    }


    public String getNoItemMessageDisplayed() {
        waitForElementVisible(driver, CompareProductsPageUI.NO_ITEM_COMPARE_MESSAGE);
        return getElementText(driver, CompareProductsPageUI.NO_ITEM_COMPARE_MESSAGE);
    }

    public boolean isProductInformationUndisplay(String productName) {
        waitForElementUndisplayed(driver, CompareProductsPageUI.PRODUCT_NAME_INFORMATION, productName);
        return isElementUndisplayed(driver, CompareProductsPageUI.PRODUCT_NAME_INFORMATION, productName);
    }
}

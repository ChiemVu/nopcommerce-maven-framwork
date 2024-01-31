package pageObject;

import commons.PageGeneratorManager;
import org.openqa.selenium.WebDriver;
import pageUIs.YourWishlistSharingPageUI;

public class YourWishlistSharingPageObject extends BaseAction {
    private WebDriver driver;

    public YourWishlistSharingPageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public boolean isYourWishlistSharingTableDisplayed(String headerName, String rowValue) {
        int headerIndex = getElementSize(driver, YourWishlistSharingPageUI.TABLE_HEADER_INDEX_BY_HEADER_NAME, headerName) + 1;
        waitForElementVisible(driver, YourWishlistSharingPageUI.TABLE_ROW_VALUE_BY_HEADER_INDEX, String.valueOf(headerIndex), rowValue);
        return isElementDisplayed(driver, YourWishlistSharingPageUI.TABLE_ROW_VALUE_BY_HEADER_INDEX, String.valueOf(headerIndex), rowValue);
    }

    public void clickToAddToCartCheckbox() {
        waitForElementClickable(driver, YourWishlistSharingPageUI.ADD_TO_CART_CHECKBOX);
        checkToDefaultCheckboxOrRadio(driver, YourWishlistSharingPageUI.ADD_TO_CART_CHECKBOX);
    }

    public ShoppingCartPageObject clickToAddToCartButton() {
        waitForElementClickable(driver, YourWishlistSharingPageUI.ADD_TO_CART_BUTTON);
        clickToElement(driver, YourWishlistSharingPageUI.ADD_TO_CART_BUTTON);
        return PageGeneratorManager.getShoppingCartPage(driver);
    }
}

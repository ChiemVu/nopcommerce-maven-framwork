package pageObject;

import commons.PageGeneratorManager;
import org.openqa.selenium.WebDriver;
import pageUIs.ShoppingCartPageUI;

public class ShoppingCartPageObject extends BaseAction {
    private WebDriver driver;

    public ShoppingCartPageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public boolean isShoppingCartTableDisplayed(String headerName, String productName) {
        int headerIndex = getElementSize(driver, ShoppingCartPageUI.TABLE_HEADER_INDEX_BY_HEADER_NAME, headerName) + 1;
        waitForElementVisible(driver, ShoppingCartPageUI.TABLE_ROW_VALUE_BY_HEADER_INDEX, String.valueOf(headerIndex), productName);
        return isElementDisplayed(driver, ShoppingCartPageUI.TABLE_ROW_VALUE_BY_HEADER_INDEX, String.valueOf(headerIndex), productName);
    }

    public WishlishPageObject openWishlistPageUrl(String wishlistPageUrl) {
        openPageUrl(driver, wishlistPageUrl);
        return PageGeneratorManager.getWishlishPage(driver);
    }
}

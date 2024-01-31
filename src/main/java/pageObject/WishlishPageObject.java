package pageObject;

import commons.PageGeneratorManager;
import org.openqa.selenium.WebDriver;
import pageUIs.WishlishPageUI;
import pageUIs.YourWishlistSharingPageUI;

public class WishlishPageObject extends BaseAction {
    private WebDriver driver;

    public WishlishPageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public boolean isWishlistTableDisplayed(String headerName, String rowValue) {
        int headerIndex = getElementSize(driver, WishlishPageUI.TABLE_HEADER_INDEX_BY_HEADER_NAME, headerName) + 1;
        waitForElementVisible(driver, WishlishPageUI.TABLE_ROW_VALUE_BY_HEADER_INDEX, String.valueOf(headerIndex), rowValue);
        return isElementDisplayed(driver, WishlishPageUI.TABLE_ROW_VALUE_BY_HEADER_INDEX, String.valueOf(headerIndex), rowValue);
    }

    public YourWishlistSharingPageObject clickToYourWishlistUrlSharingLink() {
        waitForElementClickable(driver, WishlishPageUI.YOUR_WISHLIST_URL_FOR_SHARING_LINK);
        clickToElement(driver, WishlishPageUI.YOUR_WISHLIST_URL_FOR_SHARING_LINK);
        return PageGeneratorManager.getYourWishlistSharingPage(driver);
    }

    public String getEmptyDataMessageDisplay() {
        waitForElementVisible(driver, WishlishPageUI.EMPTY_DATA_MESSASGE);
        return getElementText(driver, WishlishPageUI.EMPTY_DATA_MESSASGE);
    }

    public void clickToRemoveIcon() {
        waitForElementClickable(driver, WishlishPageUI.REMOVE_ICON_BY_ROW_NUMBER);
        clickToElement(driver, WishlishPageUI.REMOVE_ICON_BY_ROW_NUMBER);
    }

    public boolean isProductNameUndisplay(String headerName) {
        int headerIndex = getElementSize(driver, WishlishPageUI.TABLE_HEADER_INDEX_BY_HEADER_NAME, headerName) + 1;
        waitForElementUndisplayed(driver, WishlishPageUI.TABLE_ROW_VALUE_BY_HEADER_INDEX, String.valueOf(headerIndex));
        return isElementUndisplayed(driver, WishlishPageUI.TABLE_ROW_VALUE_BY_HEADER_INDEX, String.valueOf(headerIndex));
    }
}

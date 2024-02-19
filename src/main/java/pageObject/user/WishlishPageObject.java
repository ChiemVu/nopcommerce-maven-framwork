package pageObject.user;

import commons.PageGeneratorManager;
import org.openqa.selenium.WebDriver;
import pageUIs.user.WishlishPageUI;

public class WishlishPageObject extends BaseAction {
    private WebDriver driver;

    public WishlishPageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
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
}

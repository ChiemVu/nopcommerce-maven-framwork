package pageObject.user;

import org.openqa.selenium.WebDriver;
import pageUIs.user.YourWishlistSharingPageUI;

public class YourWishlistSharingPageObject extends BaseAction {
    private WebDriver driver;

    public YourWishlistSharingPageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void clickToAddToCartCheckbox() {
        waitForElementClickable(driver, YourWishlistSharingPageUI.ADD_TO_CART_CHECKBOX);
        checkToDefaultCheckboxOrRadio(driver, YourWishlistSharingPageUI.ADD_TO_CART_CHECKBOX);
    }
}

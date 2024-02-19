package pageObject.user;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pageUIs.user.BaseActionPageUI;
import pageUIs.user.RecentlyViewProductsPageUI;

import java.util.List;

public class RecentlyViewProductsPageObject extends BaseAction {
    private WebDriver driver;

    public RecentlyViewProductsPageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public boolean checkNumberProductDisplayAtRecentlyViewProductPage() {
        List<WebElement> listProduct = getListWebElement(driver, BaseActionPageUI.NUMBER_PRODUCT);
        int numeberListProduct = listProduct.size();

        if (numeberListProduct <= 3) {
            return true;
        } else {
            return false;
        }
    }

    public String getProductNameDisplayed() {
        waitForElementVisible(driver, RecentlyViewProductsPageUI.PRODUCT_NAME);
        return getElementText(driver, RecentlyViewProductsPageUI.PRODUCT_NAME);
    }
}

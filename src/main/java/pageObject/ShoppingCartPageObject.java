package pageObject;

import commons.PageGeneratorManager;
import org.openqa.selenium.WebDriver;
import pageUIs.BaseActionPageUI;
import pageUIs.ShoppingCartPageUI;

public class ShoppingCartPageObject extends BaseAction {
    private WebDriver driver;

    public ShoppingCartPageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }


    public WishlishPageObject openWishlistPageUrl(String wishlistPageUrl) {
        openPageUrl(driver, wishlistPageUrl);
        return PageGeneratorManager.getWishlishPage(driver);
    }

    public ProductDetailPageObject clickToEditLink(String headerName) {
        int headerIndex = getElementSize(driver, ShoppingCartPageUI.DYNAMIC_TABLE_HEADER_INDEX_BY_HEADER_NAME, headerName) + 1;
        waitForElementClickable(driver, ShoppingCartPageUI.EDIT_LINK, String.valueOf(headerIndex));
        clickToElement(driver, ShoppingCartPageUI.EDIT_LINK, String.valueOf(headerIndex));
        return PageGeneratorManager.getProductDetailPage(driver);
    }

    public void clickToRemoveIcon(String headerName) {
        int headerIndex = getElementSize(driver, ShoppingCartPageUI.DYNAMIC_TABLE_HEADER_INDEX_BY_HEADER_NAME, headerName) + 1;
        waitForElementClickable(driver, ShoppingCartPageUI.REMOVE_ICON, String.valueOf(headerIndex));
        clickToElement(driver, ShoppingCartPageUI.REMOVE_ICON, String.valueOf(headerIndex));
    }

    public String getNoDataMessageDisplay() {
        waitForElementVisible(driver, ShoppingCartPageUI.NO_DATA_MESSAGE);
        return getElementText(driver, ShoppingCartPageUI.NO_DATA_MESSAGE);
    }


}

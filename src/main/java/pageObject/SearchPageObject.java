package pageObject;

import commons.PageGeneratorManager;
import org.openqa.selenium.WebDriver;
import pageUIs.SeachPageUI;

public class SearchPageObject extends BaseAction {
    WebDriver driver;

    public SearchPageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public String getFristProductNameOfListSearchProduct() {
        waitForElementVisible(driver, SeachPageUI.FIRST_PRODUCT_OF_LIST_SEARCH);
        return getElementText(driver, SeachPageUI.FIRST_PRODUCT_OF_LIST_SEARCH);
    }

    public ProductDetailPageObject clickToFirstProductOfListSearchProduct() {
        waitForElementClickable(driver, SeachPageUI.FIRST_PRODUCT_OF_LIST_SEARCH);
        clickToElement(driver, SeachPageUI.FIRST_PRODUCT_OF_LIST_SEARCH);
        return PageGeneratorManager.getProductDetailPage(driver);
    }


}

package pageObject;

import commons.PageGeneratorManager;
import org.openqa.selenium.WebDriver;
import pageUIs.SearchPageUI;

public class SearchPageObject extends BaseAction {
    WebDriver driver;

    public SearchPageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public ProductDetailPageObject clickToFirstProductOfListSearchProduct() {
        waitForElementClickable(driver, SearchPageUI.FIRST_PRODUCT_OF_LIST_SEARCH);
        clickToElement(driver, SearchPageUI.FIRST_PRODUCT_OF_LIST_SEARCH);
        return PageGeneratorManager.getProductDetailPage(driver);
    }


    public void clickToSearchButtonAtSearchPage() {
        waitForElementClickable(driver, SearchPageUI.SEARCH_BUTTON);
        clickToElement(driver, SearchPageUI.SEARCH_BUTTON);
    }

    public String getSearchErrorMessage() {
        waitForElementVisible(driver, SearchPageUI.SEARCH_ERROR_MESSAGE);
        return getElementText(driver, SearchPageUI.SEARCH_ERROR_MESSAGE);
    }

    public void inputToSearchKeyword(String searchKeyValue) {
        waitForElementVisible(driver, SearchPageUI.SEARCH_KEYWORD_TEXTBOX);
        sendKeyToElement(driver, SearchPageUI.SEARCH_KEYWORD_TEXTBOX, searchKeyValue);
    }

    public String getSearchKeywordAttributeValue(String attributeValueName) {
        waitForElementVisible(driver, SearchPageUI.SEARCH_KEYWORD_TEXTBOX);
        return getElementAttribute(driver, SearchPageUI.SEARCH_KEYWORD_TEXTBOX, attributeValueName);
    }

    public void selectToCategoryDropdown(String category) {
        waitForElementClickable(driver, SearchPageUI.CATEGORY_DROPDOWN);
        selectItemInDefaultDropdown(driver, SearchPageUI.CATEGORY_DROPDOWN, category);
    }

    public void selectToManufacturerDropdown(String manufacturer) {
        waitForElementClickable(driver, SearchPageUI.MANUFACTURER_DROPDOWN);
        selectItemInDefaultDropdown(driver, SearchPageUI.MANUFACTURER_DROPDOWN, manufacturer);
    }
}

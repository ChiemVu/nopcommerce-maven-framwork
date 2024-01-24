package pageObject;

import commons.PageGeneratorManager;
import net.bytebuddy.asm.Advice;
import org.openqa.selenium.WebDriver;
import pageUIs.BaseActionPageUI;
import pageUIs.SearchPageUI;

public class SearchPageObject extends BaseAction {
    WebDriver driver;

    public SearchPageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public String getFristProductNameOfListSearchProduct() {
        waitForElementVisible(driver, SearchPageUI.FIRST_PRODUCT_OF_LIST_SEARCH);
        return getElementText(driver, SearchPageUI.FIRST_PRODUCT_OF_LIST_SEARCH);
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

    public long getNumberOfProduct() {
        return getElementSize(driver, SearchPageUI.NUMBER_PRODUCT);
    }

    public String getTheFirstOfProductNameDisplay() {
        waitForElementVisible(driver, SearchPageUI.THE_FIRST_OF_PRODUCT_NAME);
        return getElementText(driver, SearchPageUI.THE_FIRST_OF_PRODUCT_NAME);
    }

    public String getTheSecondOfProductNameDisplay() {
        waitForElementVisible(driver, SearchPageUI.THE_SECOND_OF_PRODUCT_NAME);
        return getElementText(driver, SearchPageUI.THE_SECOND_OF_PRODUCT_NAME);
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

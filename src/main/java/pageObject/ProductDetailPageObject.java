package pageObject;

import commons.PageGeneratorManager;
import org.openqa.selenium.WebDriver;
import pageUIs.ProductDetailPageUI;

public class ProductDetailPageObject extends BaseAction {
    WebDriver driver;

    public ProductDetailPageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public ProductReviewPageObject clickToAddYourReviewLink() {
        waitForElementClickable(driver, ProductDetailPageUI.ADD_YOUR_REVIEW_LINK);
        clickToElement(driver, ProductDetailPageUI.ADD_YOUR_REVIEW_LINK);
        return PageGeneratorManager.getProductReviewPage(driver);
    }

    public void clickToAddButton(String valueButton) {
        waitForElementClickable(driver, ProductDetailPageUI.DYNAMIC_ADD_BUTTON_BY_TEXT, valueButton);
        clickToElement(driver, ProductDetailPageUI.DYNAMIC_ADD_BUTTON_BY_TEXT, valueButton);
    }

    public void scrollToButton(String valueButton) {
        waitForElementVisible(driver, ProductDetailPageUI.DYNAMIC_ADD_BUTTON_BY_TEXT, valueButton);
        scrollToElement(driver, ProductDetailPageUI.DYNAMIC_ADD_BUTTON_BY_TEXT, valueButton);
    }

    public String getProductNameText() {
        waitForElementVisible(driver, ProductDetailPageUI.PRODUCT_NAME);
        return getElementText(driver, ProductDetailPageUI.PRODUCT_NAME);
    }

    public String getProductInformation() {
        waitForElementVisible(driver, ProductDetailPageUI.PRODUCT_INFORMATION_IS_SELECTED);
        return getElementText(driver, ProductDetailPageUI.PRODUCT_INFORMATION_IS_SELECTED);
    }

    public void selectDropdownByLabelName(String labelName, String dropdownValue) {
        waitForElementClickable(driver, ProductDetailPageUI.DYNAMIC_PRODUCT_DROPDOWN, labelName);
        selectItemInDefaultDropdown(driver, ProductDetailPageUI.DYNAMIC_PRODUCT_DROPDOWN, dropdownValue, labelName);
    }

    public void checkToCheckboxAndRadioButtonByLabelName(String labelName, String checkboxAndRadioValue) {
        waitForElementClickable(driver, ProductDetailPageUI.DYNAMIC_PRODUCT_CHECKBOX_RADIO_BUTTON, labelName, checkboxAndRadioValue);
        checkToDefaultCheckboxOrRadio(driver, ProductDetailPageUI.DYNAMIC_PRODUCT_CHECKBOX_RADIO_BUTTON, labelName, checkboxAndRadioValue);
    }

    public String getProductPrice() {
        waitForElementVisible(driver, ProductDetailPageUI.PRODUCT_PRICE);
        return getElementText(driver, ProductDetailPageUI.PRODUCT_PRICE);
    }

    public String getMessageDisplay() {
        waitForElementVisible(driver, ProductDetailPageUI.PRODUCT_ITEM_IN_YOUR_CART_MESSAGE);
        return getElementText(driver, ProductDetailPageUI.PRODUCT_ITEM_IN_YOUR_CART_MESSAGE);
    }
}

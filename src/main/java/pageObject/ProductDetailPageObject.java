package pageObject;

import commons.GlobalConstants;
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

    public boolean isProductInformationDisplayed(String className, String infomationValue) {
        waitForElementVisible(driver, ProductDetailPageUI.MINI_SHOPPING_CART_DYNAMIC_PRODUCT_INFORMATION_BY_CLASS_AND_INFORMATION_VALUE, className, infomationValue);
        return isElementDisplayed(driver, ProductDetailPageUI.MINI_SHOPPING_CART_DYNAMIC_PRODUCT_INFORMATION_BY_CLASS_AND_INFORMATION_VALUE, className, infomationValue);
    }

    public void selectDropdownByLabelName(String labelName, String dropdownValue) {
        waitForElementClickable(driver, ProductDetailPageUI.DYNAMIC_PRODUCT_DROPDOWN, labelName);
        selectItemInDefaultDropdown(driver, ProductDetailPageUI.DYNAMIC_PRODUCT_DROPDOWN, dropdownValue, labelName);
    }

    public Float getProductPrice(Float productNumber) {
        waitForElementVisible(driver, ProductDetailPageUI.UNIT_PRODUCT_PRICE);
        String productPriceText = getElementText(driver, ProductDetailPageUI.UNIT_PRODUCT_PRICE);
        Float productPrice = Float.parseFloat(productPriceText.replace("$", "").replace(",", ""));
        productPrice = productPrice * productNumber;
        return productPrice;
    }

    public String getMessageDisplay() {
        waitForElementVisible(driver, ProductDetailPageUI.MINI_SHOPPING_CART_PRODUCT_ITEM_IN_YOUR_CART_MESSAGE);
        return getElementText(driver, ProductDetailPageUI.MINI_SHOPPING_CART_PRODUCT_ITEM_IN_YOUR_CART_MESSAGE);
    }
    
    public void inputToQuantityTextbox(String quantityValue) {
        waitForElementVisible(driver, ProductDetailPageUI.PRODUCT_QUANTITY_TEXTBOX);
        sendKeyToElement(driver, ProductDetailPageUI.PRODUCT_QUANTITY_TEXTBOX, quantityValue);
    }

    public void clickToUpdateButton() {
        waitForElementClickable(driver, ProductDetailPageUI.PRODUCT_UPDATE_BUTTON);
        clickToElement(driver, ProductDetailPageUI.PRODUCT_UPDATE_BUTTON);
    }

    public Float getProductSubTotal() {
        waitForElementVisible(driver, ProductDetailPageUI.MINI_SHOPPING_CART_PRODUCT_SUB_TOTAL);
        return Float.parseFloat(getElementText(driver, ProductDetailPageUI.MINI_SHOPPING_CART_PRODUCT_SUB_TOTAL).replace("$", "").replace(",", ""));
    }

    public String getUnitProductPrice() {
        waitForElementVisible(driver, ProductDetailPageUI.UNIT_PRODUCT_PRICE);
        return getElementText(driver, ProductDetailPageUI.UNIT_PRODUCT_PRICE);
    }

    public boolean isProductSoftwarreUndisplayed(String softwareName, String informationValue) {
        overrideImplicitTimeout(driver, GlobalConstants.LONG_TIME);
        return isElementUndisplayed(driver, ProductDetailPageUI.MINI_SHOPPING_CART_DYNAMIC_PRODUCT_INFORMATION_BY_CLASS_AND_INFORMATION_VALUE, softwareName, informationValue);
    }
}

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

    public void scrollToTopPage() {
        scrollToBottomPage(driver);
    }

    public void scrollToButton(String valueButton) {
        waitForElementVisible(driver, ProductDetailPageUI.DYNAMIC_ADD_BUTTON_BY_TEXT, valueButton);
        scrollToElement(driver, ProductDetailPageUI.DYNAMIC_ADD_BUTTON_BY_TEXT, valueButton);
    }

    public String getProductNameText() {
        waitForElementVisible(driver, ProductDetailPageUI.PRODUCT_NAME);
        return getElementText(driver, ProductDetailPageUI.PRODUCT_NAME);
    }
}

package pageObject.user;

import org.openqa.selenium.WebDriver;
import pageUIs.user.ProductReviewPageUI;

public class ProductReviewPageObject extends BaseAction {
    WebDriver driver;

    public ProductReviewPageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void inputToReviewTitleTextbox(String reviewTitle) {
        waitForElementVisible(driver, ProductReviewPageUI.REVIEW_TITLE_TEXTBOX);
        sendKeyToElement(driver, ProductReviewPageUI.REVIEW_TITLE_TEXTBOX, reviewTitle);
    }

    public void inputToReviewTextTextbox(String reviewText) {
        waitForElementVisible(driver, ProductReviewPageUI.REVIEW_TEXT_TEXTAREA);
        sendKeyToElement(driver, ProductReviewPageUI.REVIEW_TEXT_TEXTAREA, reviewText);
    }

    public void selectToRatingRadioButton() {
        waitForElementClickable(driver, ProductReviewPageUI.RATING_RADIO_BUTTON);
        clickToElement(driver, ProductReviewPageUI.RATING_RADIO_BUTTON);
    }

    public void clickToSubmitReviewButton() {
        waitForElementClickable(driver, ProductReviewPageUI.SUBMIT_REVIEW_BUTTON);
        clickToElement(driver, ProductReviewPageUI.SUBMIT_REVIEW_BUTTON);
    }

    public String getReviewTitleValue() {
        waitForElementVisible(driver, ProductReviewPageUI.REVIEW_TITLE_VALUE);
        return getElementText(driver, ProductReviewPageUI.REVIEW_TITLE_VALUE);
    }

    public String getReviewContentValue() {
        waitForElementVisible(driver, ProductReviewPageUI.REVIEW_TEXT_VALUE);
        return getElementText(driver, ProductReviewPageUI.REVIEW_TEXT_VALUE);
    }

    public String getProductRatingAttributeValue(String attributeName) {
        waitForElementVisible(driver, ProductReviewPageUI.RATING_ATTRIBUTE_VALUE);
        return getElementAttribute(driver, ProductReviewPageUI.RATING_ATTRIBUTE_VALUE, attributeName);
    }

    public String getNameValue() {
        waitForElementVisible(driver, ProductReviewPageUI.NAME_VALUE);
        return getElementText(driver, ProductReviewPageUI.NAME_VALUE);
    }

    public String getCurrentDayValue() {
        waitForElementVisible(driver, ProductReviewPageUI.DAY_VALUE);
        return getElementText(driver, ProductReviewPageUI.DAY_VALUE);
    }

    public String getProductNameReviewed() {
        waitForElementVisible(driver, ProductReviewPageUI.PRODUCT_REVIEWED);
        return getElementText(driver, ProductReviewPageUI.PRODUCT_REVIEWED);
    }
}

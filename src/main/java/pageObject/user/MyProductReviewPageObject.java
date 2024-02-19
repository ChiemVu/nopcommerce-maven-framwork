package pageObject.user;

import org.openqa.selenium.WebDriver;
import pageUIs.user.MyProductReviewPageUI;

public class MyProductReviewPageObject extends BaseAction {
    WebDriver driver;

    public MyProductReviewPageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public String getReviewTitleValue() {
        waitForElementVisible(driver, MyProductReviewPageUI.REVIEW_TITLE_VALUE);
        return getElementText(driver, MyProductReviewPageUI.REVIEW_TITLE_VALUE);
    }

    public String getProductRatingValue() {
        waitForElementVisible(driver, MyProductReviewPageUI.RATING_VALUE);
        return getElementText(driver, MyProductReviewPageUI.RATING_VALUE);
    }

    public String getNameValue() {
        waitForElementVisible(driver, MyProductReviewPageUI.NAME_VALUE);
        return getElementText(driver, MyProductReviewPageUI.NAME_VALUE);
    }

    public String getCurrentDayValue() {
        waitForElementVisible(driver, MyProductReviewPageUI.DAY_VALUE);
        return getElementText(driver, MyProductReviewPageUI.DAY_VALUE);
    }

    public String getReviewContentValue() {
        waitForElementVisible(driver, MyProductReviewPageUI.REVIEW_TEXT_VALUE);
        return getElementText(driver, MyProductReviewPageUI.REVIEW_TEXT_VALUE);
    }
}

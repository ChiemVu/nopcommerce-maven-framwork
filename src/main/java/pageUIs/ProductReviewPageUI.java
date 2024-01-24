package pageUIs;

public class ProductReviewPageUI {
    public static final String REVIEW_TITLE_TEXTBOX = "xpath=//input[@id='AddProductReview_Title']";
    public static final String REVIEW_TEXT_TEXTAREA = "xpath=//textarea[@id='AddProductReview_ReviewText']";
    public static final String RATING_RADIO_BUTTON = "xpath=//input[@id='addproductrating_4']";
    public static final String SUBMIT_REVIEW_BUTTON = "css=button.write-product-review-button";
    public static final String REVIEW_TITLE_VALUE = "xpath=//div[@class='product-review-item'][1]//div[@class='review-title']/strong";
    public static final String REVIEW_TEXT_VALUE = "xpath=//div[@class='product-review-item'][1]//div[@class='text-body']";
    public static final String RATING_ATTRIBUTE_VALUE = "xpath=//div[@class='product-review-item'][1]//div[@class='rating']/div";
    public static final String NAME_VALUE = "xpath=//div[@class='product-review-item'][1]//span[@class='user']/span";
    public static final String DAY_VALUE = "xpath=//div[@class='product-review-item'][1]//span[@class='date']/span";
    public static final String PRODUCT_REVIEWED = "xpath=//div[@class='product-review-item'][1]//a";
}

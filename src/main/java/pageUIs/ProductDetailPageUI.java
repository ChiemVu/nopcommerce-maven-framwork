package pageUIs;

public class ProductDetailPageUI {
    public static final String ADD_YOUR_REVIEW_LINK = "xpath=//a[text()='Add your review']";
    public static final String DYNAMIC_ADD_BUTTON_BY_TEXT = "xpath=//div[@class='overview-buttons']//button[text()='%s']";
    public static final String PRODUCT_NAME = "xpath=//div[@class='product-name']/h1";
    public static final String PRODUCT_PRICE = "xpath=//div[@class='product-price']/span";
    public static final String DYNAMIC_PRODUCT_DROPDOWN = "xpath=//label[contains(string(),'%s')]/parent::dt/following-sibling::dd[1]//select";
    public static final String DYNAMIC_PRODUCT_CHECKBOX_RADIO_BUTTON = "xpath=//label[contains(string(),'%s')]/parent::dt/following-sibling::dd[1]//label[text()='%s']/preceding-sibling::input";
    public static final String PRODUCT_INFORMATION_IS_SELECTED = "xpath=//div[@class='product']";
    public static final String PRODUCT_ITEM_IN_YOUR_CART_MESSAGE = "xpath=//div[@class='count']";
}

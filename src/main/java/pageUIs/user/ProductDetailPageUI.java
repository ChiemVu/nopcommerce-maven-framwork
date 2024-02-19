package pageUIs.user;

public class ProductDetailPageUI {
    public static final String ADD_YOUR_REVIEW_LINK = "xpath=//a[text()='Add your review']";
    public static final String DYNAMIC_ADD_BUTTON_BY_TEXT = "xpath=//div[@class='overview-buttons']//button[text()='%s']";
    public static final String PRODUCT_NAME = "xpath=//div[@class='product-name']/h1";
    public static final String UNIT_PRODUCT_PRICE = "xpath=//div[@class='product-price']/span";
    public static final String DYNAMIC_PRODUCT_DROPDOWN = "xpath=//label[contains(string(),'%s')]/parent::dt/following-sibling::dd[1]//select";
    public static final String MINI_SHOPPING_CART_DYNAMIC_PRODUCT_INFORMATION_BY_CLASS_AND_INFORMATION_VALUE = "xpath=//div[@class='product']/div[@class='%s'and contains(string(),'%s')]";
    public static final String MINI_SHOPPING_CART_PRODUCT_ITEM_IN_YOUR_CART_MESSAGE = "xpath=//div[@class='count']";
    public static final String PRODUCT_QUANTITY_TEXTBOX = "xpath=//input[@id='product_enteredQuantity_1']";
    public static final String PRODUCT_UPDATE_BUTTON = "xpath=//button[@id='add-to-cart-button-1']";
    public static final String MINI_SHOPPING_CART_PRODUCT_SUB_TOTAL = "xpath=//div[@class='totals']/strong";
}


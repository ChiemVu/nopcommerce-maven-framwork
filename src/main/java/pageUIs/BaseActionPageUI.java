package pageUIs;

public class BaseActionPageUI {
    public static final String ADDRESS_LINK = "xpath=//div[@class='listbox']//a[text()='Addresses']";
    public static final String CHANGE_PASSWORD_LINK = "xpath=//div[@class='listbox']//a[text()='Change password']";
    public static final String MY_PRODUCT_REVIEW_LINK = "xpath=//div[@class='listbox']//a[text()='My product reviews']";
    public static final String LOGOUT_LINK = "xpath=//a[@class='ico-logout']";
    public static final String LOGIN_LINK = "xpath=//a[@class='ico-login']";
    public static final String WISHLIST_LINK = "xpath=//a[@class='ico-wishlist']";
    public static final String SEARCH_TEXTBOX = "xpath=//input[@id='small-searchterms']";
    public static final String SEARCH_BUTTON_AT_HEADER = "css=button.search-box-button";
    public static final String SEARCH_LINK_AT_FOOTER = "xpath=//a[text()='Search']";
    public static final String NUMBER_PRODUCT = "xpath=//div[@class='item-box']";
    public static final String DYNAMIC_CHECKBOX_BY_LABEL_NAME = "xpath=//label[text()='%s']/preceding-sibling::input";
    public static final String COMPUTER_HEADER_MENU = "xpath=//div[@class='header-menu']/ul[contains(@class,'notmobile')]//a[contains(string(),'Computers')]";
    public static final String NAVIGATION_NOTEBOOKS_SUBMENU = "xpath=//div[contains(@class,'block-category-navigation')]//a[text()='Notebooks ']";
    public static final String NAVIGATION_DESKTOPS_SUBMENU = "xpath=//div[contains(@class,'block-category-navigation')]//a[text()='Desktops ']";
    public static final String RECENTLY_VIEWED_PRODUCT_FOOTER_MENU = "xpath=//div[@class='footer']//a[text()='Recently viewed products']";

    public static final String MESSAGE_DISPLAYED = "xpath=//p[@class='content']";
    public static final String CLOSE_ICON = "css=span.close";

    public static final String DYNAMIC_PRODUCT_NAME_AT_THE_NUMBER = "xpath=//div[@class='item-box'][%s]//h2[@class='product-title']";
    public static final String DYNAMIC_PRICE_AT_PRODUCT_NAME = "xpath=//a[text()='%s']/parent::h2/parent::div//div[@class='prices']";
    public static final String DYNAMIC_ADD_TO_COMPARE_LIST_AT_PRODUCT_NAME = "xpath=//a[text()='%s']/parent::h2/parent::div//button[@title='Add to compare list']";
    public static final String PRODUCT_COMPARISON_LINK = "xpath=//a[text()='product comparison']";
}

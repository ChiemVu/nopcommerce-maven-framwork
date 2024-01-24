package pageUIs;

public class BaseActionPageUI {
    public static final String ADDRESS_LINK = "xpath=//div[@class='listbox']//a[text()='Addresses']";
    public static final String CHANGE_PASSWORD_LINK = "xpath=//div[@class='listbox']//a[text()='Change password']";
    public static final String MY_PRODUCT_REVIEW_LINK = "xpath=//div[@class='listbox']//a[text()='My product reviews']";
    public static final String LOGOUT_LINK = "xpath=//a[@class='ico-logout']";
    public static final String LOGIN_LINK = "xpath=//a[@class='ico-login']";
    public static final String SEARCH_TEXTBOX = "xpath=//input[@id='small-searchterms']";
    public static final String SEARCH_BUTTON_AT_HEADER = "css=button.search-box-button";
    public static final String SEARCH_LINK_AT_FOOTER = "xpath=//a[text()='Search']";
    public static final String DYNAMIC_CHECKBOX_BY_LABEL_NAME = "xpath=//label[text()='%s']/preceding-sibling::input";
}

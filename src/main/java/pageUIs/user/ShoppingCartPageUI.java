package pageUIs.user;

public class ShoppingCartPageUI {
    public static final String DYNAMIC_TABLE_HEADER_INDEX_BY_HEADER_NAME = "xpath=//table[@class='cart']//thead//th[text()='%s']/preceding-sibling::th";
    public static final String EDIT_LINK = "xpath=//table[@class='cart']//tbody//td[%s]/div[@class='edit-item']/a";
    public static final String REMOVE_ICON = "xpath=//table[@class='cart']//tbody//td[%s]/button";
    public static final String NO_DATA_MESSAGE = "xpath=//div[@class='order-summary-content']/div";
}

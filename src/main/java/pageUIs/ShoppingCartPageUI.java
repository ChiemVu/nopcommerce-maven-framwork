package pageUIs;

public class ShoppingCartPageUI {
    public static final String TABLE_HEADER_INDEX_BY_HEADER_NAME = "xpath=//table[@class='cart']//thead//th[text()='%s']/preceding-sibling::th";
    public static final String TABLE_ROW_VALUE_BY_HEADER_INDEX = "xpath=//table[@class='cart']//tbody//td[%s]";
    public static final String EDIT_BUTTON = "xpath=//div[@class='edit-item']";
}

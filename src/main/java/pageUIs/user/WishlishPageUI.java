package pageUIs.user;

public class WishlishPageUI {
    public static final String TABLE_HEADER_INDEX_BY_HEADER_NAME = "xpath=//table[@class='cart']//thead//th[text()='%s']/preceding-sibling::th";
    public static final String TABLE_ROW_VALUE_BY_HEADER_INDEX = "xpath=//table[@class='cart']//tbody//td[%s]";
    public static final String YOUR_WISHLIST_URL_FOR_SHARING_LINK = "xpath=//a[@class='share-link']";
    public static final String EMPTY_DATA_MESSASGE = "xpath=//div[@class='no-data']";
    public static final String REMOVE_ICON_BY_ROW_NUMBER = "xpath=//table[@class='cart']//tbody/tr[last()]/td[@class='remove-from-cart']";

}

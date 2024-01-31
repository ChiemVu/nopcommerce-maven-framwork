package pageObject;

import org.openqa.selenium.WebDriver;

public class RecentlyViewProductsPageObject extends BaseAction {
    private WebDriver driver;

    public RecentlyViewProductsPageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }
}

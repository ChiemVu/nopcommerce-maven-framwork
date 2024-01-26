package pageObject;

import org.openqa.selenium.WebDriver;

public class ComputersPageObject extends BaseAction {
    WebDriver driver;

    public ComputersPageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }
}

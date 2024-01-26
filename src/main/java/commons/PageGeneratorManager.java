package commons;

import org.openqa.selenium.WebDriver;
import pageObject.*;

public class PageGeneratorManager {
    public static HomePageObject getHomePage(WebDriver driver) {
        return new HomePageObject(driver);
    }

    public static RegisterPageObject getRegisterPage(WebDriver driver) {
        return new RegisterPageObject(driver);
    }

    public static LoginPageObject getLoginPage(WebDriver driver) {
        return new LoginPageObject(driver);
    }

    public static CustomerInfoPageObject getCustomerInfoPage(WebDriver driver) {
        return new CustomerInfoPageObject(driver);
    }

    public static AddressPageObject getAddressPage(WebDriver driver) {
        return new AddressPageObject(driver);
    }

    public static AddNewAddressPageObject getAddNewAddressPage(WebDriver driver) {
        return new AddNewAddressPageObject(driver);
    }

    public static ChangePasswordPageObject getChangePasswordPage(WebDriver driver) {
        return new ChangePasswordPageObject(driver);
    }

    public static SearchPageObject getSearchPage(WebDriver driver) {
        return new SearchPageObject(driver);
    }

    public static ProductDetailPageObject getProductDetailPage(WebDriver driver) {
        return new ProductDetailPageObject(driver);
    }

    public static ProductReviewPageObject getProductReviewPage(WebDriver driver) {
        return new ProductReviewPageObject(driver);
    }

    public static MyProductReviewPageObject getMyProductReviewPage(WebDriver driver) {
        return new MyProductReviewPageObject(driver);
    }

    public static ComputersPageObject getComputersPage(WebDriver driver) {
        return new ComputersPageObject(driver);
    }

    public static NotebooksPageObject getNotebooksPage(WebDriver driver) {
        return new NotebooksPageObject(driver);
    }
}

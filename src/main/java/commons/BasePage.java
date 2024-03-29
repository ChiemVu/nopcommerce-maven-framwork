package commons;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;


public class BasePage {

    // Ko cần phải khởi tạo đối tượng mà vẫn truy cập vào hàm này được
    // Truy cập trực tiếp từ phạm vi Class
    public static BasePage getBasePage() {
        return new BasePage();
    }


    public void openPageUrl(WebDriver driver, String pageurl) {
        driver.get(pageurl);
    }

    public String getCurrentPageUrl(WebDriver driver) {
        return driver.getCurrentUrl();
    }

    private By getByLocator(String locatorType) {
        By by = null;
        if (locatorType.startsWith("id=") || locatorType.startsWith("ID=") || locatorType.startsWith("Id=")) {
            locatorType = locatorType.substring(3);
            by = By.id(locatorType);
        } else if (locatorType.startsWith("class=") || locatorType.startsWith("CLASS=")
                || locatorType.startsWith("Class=")) {
            locatorType = locatorType.substring(6);
            by = By.className(locatorType);
        } else if (locatorType.startsWith("name=") || locatorType.startsWith("NAME=")
                || locatorType.startsWith("Name=")) {
            locatorType = locatorType.substring(5);
            by = By.name(locatorType);
        } else if (locatorType.startsWith("css=") || locatorType.startsWith("CSS=") || locatorType.startsWith("Css=")) {
            by = By.cssSelector(locatorType.substring(4));
        } else if (locatorType.startsWith("xpath=") || locatorType.startsWith("XPATH=")
                || locatorType.startsWith("Xpath=") || locatorType.startsWith("Xpath=")) {
            locatorType = locatorType.substring(6);
            by = By.xpath(locatorType);
        } else {
            throw new RuntimeException("Locator Type is not supported");
        }
        return by;
    }

    public String getDynamicXpath(String locatorType, String... dynamicValues) {
        if (locatorType.startsWith("xpath=") || locatorType.startsWith("XPATH=") || locatorType.startsWith("Xpath=")
                || locatorType.startsWith("Xpath=")) {
            locatorType = String.format(locatorType, (Object[]) dynamicValues);
        }
        return locatorType;
    }

    public WebElement getWebElement(WebDriver driver, String locatorType) {
        return driver.findElement(getByLocator(locatorType));
    }

    public String getElementText(WebDriver driver, String locatorType) {
        return getWebElement(driver, locatorType).getText();
    }

    public String getElementText(WebDriver driver, String locatorType, String... dynamicValues) {
        return getWebElement(driver, getDynamicXpath(locatorType, dynamicValues)).getText();
    }


    public List<WebElement> getListWebElement(WebDriver driver, String locatorType) {
        return driver.findElements(getByLocator(locatorType));
    }

    public int getElementSize(WebDriver driver, String locatorType) {
        return getListWebElement(driver, locatorType).size();
    }

    public int getElementSize(WebDriver driver, String locator, String... dynamicValue) {
        return getListWebElement(driver, getDynamicXpath(locator, dynamicValue)).size();
    }

    public void clickToElement(WebDriver driver, String locatorType) {
        if (driver.toString().contains("internet explorer")) {
            clickToElementByJS(driver, locatorType);
            sleepInSecond(3);
        } else {
            getWebElement(driver, locatorType).click();
        }
    }

    public void clickToElement(WebDriver driver, String locator, String... dynamicValue) {
        getWebElement(driver, getDynamicXpath(locator, dynamicValue)).click();
    }

    public void clickToElementByJS(WebDriver driver, String locatorType) {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].click();", getWebElement(driver, locatorType));
    }

    public void sleepInSecond(long timeInSecond) {
        try {
            Thread.sleep(timeInSecond * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void waitForElementClickable(WebDriver driver, String locatorType) {

        WebDriverWait explicitWait = new WebDriverWait(driver, Duration.ofSeconds(GlobalConstants.LONG_TIME));
        explicitWait.until(ExpectedConditions.elementToBeClickable(getByLocator(locatorType)));
    }

    public void waitForElementClickable(WebDriver driver, String locatorType, String... dynamicValues) {

        WebDriverWait explicitWait = new WebDriverWait(driver, Duration.ofSeconds(GlobalConstants.LONG_TIME));
        explicitWait.until(
                ExpectedConditions.elementToBeClickable(getByLocator(getDynamicXpath(locatorType, dynamicValues))));
    }

    public void waitForElementVisible(WebDriver driver, String locatorType) {
        WebDriverWait explicitWait = new WebDriverWait(driver, Duration.ofSeconds(GlobalConstants.LONG_TIME));
        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(getByLocator(locatorType)));
    }

    public void waitForElementVisible(WebDriver driver, String locatorType, String... dynamicValues) {
        WebDriverWait explicitWait = new WebDriverWait(driver, Duration.ofSeconds(GlobalConstants.LONG_TIME));
        explicitWait.until(ExpectedConditions
                .visibilityOfElementLocated(getByLocator(getDynamicXpath(locatorType, dynamicValues))));
    }

    public void waitForElementUndisplayed(WebDriver driver, String locatorType, String... dynamicValues) {
        WebDriverWait explicitWait = new WebDriverWait(driver, Duration.ofSeconds(GlobalConstants.LONG_TIME));
        explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(getByLocator(getDynamicXpath(locatorType, dynamicValues))));
    }

    public boolean isElementUndisplayed(WebDriver driver, String locator) {
        overrideImplicitTimeout(driver, GlobalConstants.SHORT_TIME);
        List<WebElement> elements = getListWebElement(driver, locator);
        overrideImplicitTimeout(driver, GlobalConstants.LONG_TIME);
        if (elements.size() == 0) {
            return true;
        } else if (elements.size() > 0 && !elements.get(0).isDisplayed()) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isElementUndisplayed(WebDriver driver, String locator, String... dynamicValue) {
        overrideImplicitTimeout(driver, GlobalConstants.SHORT_TIME);
        List<WebElement> elements = getListWebElement(driver, getDynamicXpath(locator, dynamicValue));
        overrideImplicitTimeout(driver, GlobalConstants.LONG_TIME);
        if (elements.size() == 0) {
            return true;
        } else if (elements.size() > 0 && !elements.get(0).isDisplayed()) {
            return true;
        } else {
            return false;
        }
    }

    public void overrideImplicitTimeout(WebDriver driver, long timeOut) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(GlobalConstants.SHORT_TIME));
    }

    public void checkToDefaultCheckboxOrRadio(WebDriver driver, String locatorType) {
        WebElement element = getWebElement(driver, locatorType);
        if (!element.isSelected()) {
            element.click();
        }
    }

    public void checkToDefaultCheckboxOrRadio(WebDriver driver, String locatorType, String... dynamicValue) {
        WebElement element = getWebElement(driver, getDynamicXpath(locatorType, dynamicValue));
        if (!element.isSelected()) {
            element.click();
        }
    }

    public void selectItemInDefaultDropdown(WebDriver driver, String locatorType, String textItem) {
        Select select = new Select(getWebElement(driver, locatorType));
        select.selectByVisibleText(textItem);
    }

    public void selectItemInDefaultDropdown(WebDriver driver, String locatorType, String textItem, String... dynamicValue) {
        Select select = new Select(getWebElement(driver, getDynamicXpath(locatorType, dynamicValue)));
        select.selectByVisibleText(textItem);
    }

    public void sendKeyToElement(WebDriver driver, String locatorType, String textValue) {
        WebElement element = getWebElement(driver, locatorType);
        element.clear();
        element.sendKeys(textValue);
    }

    public boolean isElementDisplayed(WebDriver driver, String locatorType) {
        try {
            // tìm thấy element:
            // case 1: Displayed - trả vè true
            // case 2: undisplayed - trả về false
            return getWebElement(driver, locatorType).isDisplayed();
        } catch (NoSuchElementException e) {
            // case 3: undisplayed - trả về false
            return false;
        }
    }

    public boolean isElementDisplayed(WebDriver driver, String locator, String... dynamicValue) {
        try {
            return getWebElement(driver, getDynamicXpath(locator, dynamicValue)).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public boolean isElementSelected(WebDriver driver, String locatorType) {
        return getWebElement(driver, locatorType).isDisplayed();
    }

    public String getElementAttribute(WebDriver driver, String locatorType, String attributeName) {
        return getWebElement(driver, locatorType).getAttribute(attributeName);
    }

    public void scrollToElement(WebDriver driver, String locatorType) {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].scrollIntoView(true);", getWebElement(driver, locatorType));
    }

    public void scrollToElement(WebDriver driver, String locator, String... dynamicValue) {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].scrollIntoView(true);", getWebElement(driver, getDynamicXpath(locator, dynamicValue)));
    }

    public void uncheckToElement(WebDriver driver, String locator) {
        if (getWebElement(driver, locator).isSelected()) {
            getWebElement(driver, locator).click();
        }
    }

    public void uncheckToElement(WebDriver driver, String locator, String... dynamicValue) {
        if (getWebElement(driver, getDynamicXpath(locator, dynamicValue)).isSelected()) {
            getWebElement(driver, getDynamicXpath(locator, dynamicValue)).click();
        }
    }

    public boolean isElementSelected(WebDriver driver, String locator, String... dynamicValue) {
        return getWebElement(driver, getDynamicXpath(locator, dynamicValue)).isSelected();
    }

    public void hoverMouserToElement(WebDriver driver, String locatorType) {
        Actions action = new Actions(driver);
        action.moveToElement(getWebElement(driver, locatorType)).perform();
    }

}

package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pageUIs.NotebooksPageUI;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NotebooksPageObject extends BaseAction {
    WebDriver driver;

    public NotebooksPageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void selectItemInProductSortDropdown(String itemValueDropdown, String dropdownID) {
        waitForElementVisible(driver, NotebooksPageUI.DYNAMIC_SORT_ITEM_DROPDOWN_BY_ID, dropdownID);
        selectItemInDefaultDropdown(driver, NotebooksPageUI.DYNAMIC_SORT_ITEM_DROPDOWN_BY_ID, itemValueDropdown, dropdownID);
    }

    public boolean isProductNameSortAscending() {
        ArrayList<String> notebookNameUIsList = new ArrayList<String>();
        List<WebElement> notebookNameText = getListWebElement(driver, NotebooksPageUI.NOTEBOOK_NAME_TEXT);
        for (WebElement notebookName : notebookNameText) {
            notebookNameUIsList.add(notebookName.getText());
        }
        ArrayList<String> notebookNameUIsSortList = new ArrayList<>();
        for (String notebookName : notebookNameUIsList) {
            notebookNameUIsSortList.add(notebookName);
        }

        Collections.sort(notebookNameUIsSortList);
        return notebookNameUIsSortList.equals(notebookNameUIsList);
    }

    public boolean isProductNameSortDescending() {
        ArrayList<String> notebookNameUIsList = new ArrayList<>();
        List<WebElement> notebooksNameText = getListWebElement(driver, NotebooksPageUI.NOTEBOOK_NAME_TEXT);
        for (WebElement notebookName : notebooksNameText) {
            notebookNameUIsList.add(notebookName.getText());
        }
        ArrayList<String> notebookNameUIsSortList = new ArrayList<String>();
        for (String notebookName : notebookNameUIsList) {
            notebookNameUIsSortList.add(notebookName);
        }
        Collections.sort(notebookNameUIsSortList);
        Collections.reverse(notebookNameUIsSortList);
        return notebookNameUIsSortList.equals(notebookNameUIsList);
    }


    public boolean isProductPriceSortDescending() {
        ArrayList<Float> notebookPriceUIsList = new ArrayList<Float>();
        List<WebElement> notebookPriceText = getListWebElement(driver, NotebooksPageUI.NOTEBOOK_PRICE_TEXT);
        for (WebElement notebookPrice : notebookPriceText) {
            notebookPriceUIsList.add(Float.parseFloat(notebookPrice.getText().replace("$", "").replace(",", "")));
        }
        ArrayList<Float> notebookPriceUIsSortList = new ArrayList<Float>();
        for (Float notebookPrice : notebookPriceUIsList) {
            notebookPriceUIsSortList.add(notebookPrice);
        }
        Collections.sort(notebookPriceUIsSortList);
        Collections.reverse(notebookPriceUIsSortList);
        return notebookPriceUIsSortList.equals(notebookPriceUIsList);
    }

    public boolean isProductPriceSortAscending() {
        ArrayList<Float> notebookPriceUIsList = new ArrayList<Float>();
        List<WebElement> notebookPriceText = getListWebElement(driver, NotebooksPageUI.NOTEBOOK_PRICE_TEXT);
        System.out.println("do dai la  " + notebookPriceText.size());
        for (WebElement notebookPrice : notebookPriceText) {
            notebookPriceUIsList.add(Float.parseFloat(notebookPrice.getText().replace("$", "").replace(",", "")));
        }

        ArrayList<Float> notebookPriceUIsSortList = new ArrayList<Float>();
        for (Float notebookPrice : notebookPriceUIsList) {
            notebookPriceUIsSortList.add(notebookPrice);
        }

        Collections.sort(notebookPriceUIsSortList);
        return notebookPriceUIsSortList.equals(notebookPriceUIsList);
    }


    public boolean isNextPagingIconDisplayed() {
        waitForElementVisible(driver, NotebooksPageUI.NEXT_PAGING_ICON);
        return isElementDisplayed(driver, NotebooksPageUI.NEXT_PAGING_ICON);
    }

    public void clickToNextPagingIcon() {
        waitForElementVisible(driver, NotebooksPageUI.NEXT_PAGING_ICON);
        clickToElement(driver, NotebooksPageUI.NEXT_PAGING_ICON);
    }

    public boolean isPreviousPagingIconDisplayed() {
        waitForElementVisible(driver, NotebooksPageUI.PREVIOUS_PAGING_ICON);
        return isElementDisplayed(driver, NotebooksPageUI.PREVIOUS_PAGING_ICON);
    }

    public boolean isNextPagingIconUndisplayed() {
        return isElementUndisplayed(driver, NotebooksPageUI.NEXT_PAGING_ICON);
    }
}

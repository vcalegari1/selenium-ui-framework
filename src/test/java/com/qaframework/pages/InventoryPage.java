package com.qaframework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class InventoryPage extends BasePage {

    private final By pageTitle = By.className("title");

    public InventoryPage(WebDriver driver) {
        super(driver);
    }

    public boolean isInventoryPageDisplayed() {
        return isDisplayed(pageTitle);
    }

    public String getPageTitle() {
        return getText(pageTitle);
    }
}
package com.qaframework.tests;

import com.qaframework.base.BaseTest;
import com.qaframework.pages.InventoryPage;
import com.qaframework.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test
    public void validLoginRedirectsToInventoryPage() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");

        InventoryPage inventoryPage = new InventoryPage(driver);
        Assert.assertTrue(inventoryPage.isInventoryPageDisplayed(), "Inventory page was not displayed after login");
        Assert.assertEquals(inventoryPage.getPageTitle(), "Products");
    }

    @Test
    public void invalidLoginShowsErrorMessage() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "wrong_password");

        Assert.assertTrue(loginPage.isErrorDisplayed(), "Error message was not displayed for invalid login");
    }
}
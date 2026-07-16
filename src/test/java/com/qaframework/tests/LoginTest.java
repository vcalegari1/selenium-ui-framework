package com.qaframework.tests;

import com.qaframework.base.BaseTest;
import com.qaframework.pages.InventoryPage;
import com.qaframework.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

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

    @Test
    public void lockedOutUserSeesCorrectError() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("locked_out_user", "secret_sauce");

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(loginPage.isErrorDisplayed(), "Error message was not displayed for locked out user");
        softAssert.assertTrue(loginPage.getErrorMessage().contains("locked out"), "Error message did not mention account being locked out");
        softAssert.assertAll();
    }
}
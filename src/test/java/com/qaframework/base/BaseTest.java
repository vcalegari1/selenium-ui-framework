package com.qaframework.base;

import com.qaframework.utils.ConfigReader;
import com.qaframework.utils.DriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    protected WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = DriverManager.getDriver();
        driver.get(ConfigReader.get("base.url"));
    }

    @AfterMethod
    public void tearDown() {
        DriverManager.quitDriver();
    }
}
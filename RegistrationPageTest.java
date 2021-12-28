package com.nopCommercedemostore.test;

import com.nopCommercedemostore.base.BasePage;

import com.nopCommercedemostore.pages.RegistrationPage;
import com.nopCommercedemostore.utilities.Constants;
import com.nopCommercedemostore.utilities.ExcelUtil;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import org.testng.annotations.Test;

import java.util.Properties;

public class RegistrationPageTest {

    BasePage basePage; //I can create class level reference
    Properties prop;
    WebDriver driver;
    RegistrationPage registrationPage;

    @BeforeTest
    public void openBrowser() {

        basePage = new BasePage();
        prop = basePage.initialiseProperties();
        String browser = prop.getProperty("browser");
        driver = basePage.initialiseDriver(browser);
        driver.get(prop.getProperty("url"));
        registrationPage = new RegistrationPage(driver);

    }

    @Test(priority = 1)
    public void verifyRegistrationPageTitle() {
        String title = registrationPage.getRegistrationPageTitle();
        System.out.println("Registration Page title is: " + title);
        Assert.assertEquals(title, Constants.REGISTER_PAGE_TITLE);
    }

    @Test(priority = 2)
    public void RegistrationPageTest() throws InterruptedException {
        Thread.sleep(3000);

        registrationPage.registerUser(prop.getProperty("FN"), prop.getProperty("LN"), prop.getProperty("Day"), prop.getProperty("Month"), prop.getProperty("Year"), prop.getProperty("email"),
                prop.getProperty("CompanyName"), prop.getProperty("Password"), prop.getProperty("CP"));

    }

    @AfterTest
    public void tearDown() {
        driver.quit();

    }
}




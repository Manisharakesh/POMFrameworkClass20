package com.nopCommercedemostore.pages;

import com.nopCommercedemostore.utilities.Constants;
import com.nopCommercedemostore.utilities.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegistrationPage {

    WebDriver driver;
    Utils utils;
    // Create your page object/object repository in the form of By locators.

    By Register = By.cssSelector("a[class='ico-register']");
    By Gender = By.xpath("//label[@for='gender']");
    By Female = By.xpath("//input[@id='gender-female']");
    By FirstName = By.xpath("//input[@id='FirstName']");
    By LastName = By.xpath("//input[@id='LastName']");
    By day = By.xpath("//select[@name='DateOfBirthDay']");
    By month = By.xpath("//select[@name='DateOfBirthMonth']");
    By year = By.xpath("//select[@name='DateOfBirthYear']");
    By emailId = By.id("Email");
    By companyName = By.id("Company");
    //By Newsletter = By.id("NewsLetter");
    By password = By.xpath("//input[@id='Password']");
    By confirmpassword = By.xpath("//input[@id='ConfirmPassword']");
    By RegisterButton = By.xpath("//button[@id='register-button']");
    By shoppingCart = By.xpath("//span[@class='cart-label']");
    By Books = By.xpath("/html/body/div[6]/div[2]/ul[1]/li[5]/a");
    By Fahrenheit = By.xpath("//button[@id='add-to-cart-button-37']");
    By AddCart = By.xpath("/html/body/div[6]/div[3]/div/div[3]/div/div[2]/div[2]/div[2]/div/div/div[1]/div/div[2]/div[3]/div[2]/button[1]");


    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
        utils = new Utils(driver);
    }

    public String getRegistrationPageTitle() {
        return utils.waitForTitlePresent(Constants.REGISTER_PAGE_TITLE, 10);
    }

    public void registerUser(String FN, String LN, String Day, String Month, String Year, String email,
                             String CompanyName, String Password, String CP) throws InterruptedException {

        utils.doClick(Register);
        Thread.sleep(3000);
        utils.doClick(Gender);
        utils.doClick(Female);
        utils.doSendKeys(FirstName, FN);
        utils.doSendKeys(LastName, LN);
        Thread.sleep(3000);
        utils.selectValueFromDropDown(day, Day);
        utils.selectValueFromDropDown(month, Month);
        utils.selectValueFromDropDown(year, Year);
        Thread.sleep(3000);
        utils.doSendKeys(emailId, email);
        utils.doSendKeys(companyName, CompanyName);
        // utils.doClick(Newsletter);
        Thread.sleep(3000);
        utils.doSendKeys(password, Password);
        utils.doSendKeys(confirmpassword, CP);
        Thread.sleep(3000);
        utils.doClick(RegisterButton);
        utils.doClick(shoppingCart);
        utils.doClick(Books);
        utils.doClick(Fahrenheit);
        utils.doClick(AddCart);
        utils.doClick(shoppingCart);

        System.out.println("credentials are... " + FirstName + LastName + day + month + year +
                emailId + password + confirmpassword);


    }
}



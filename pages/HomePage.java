package com.nopCommercedemostore.pages;

import com.nopCommercedemostore.base.BasePage;
import com.nopCommercedemostore.utilities.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {

    WebDriver driver;
    Utils utils;
   By myAccount = By.className("ico-account");
    By logOut = By.className("ico-logout");

    public HomePage(WebDriver driver){
        this.driver=driver;
        utils = new Utils(driver);
    }
    public String getHomePageTitle(){

        return driver.getTitle();
    }

    public boolean isLogOutLinkPresent(){
        return utils.isElementDisplayed(logOut);
        //return driver.findElement(logOut).isDisplayed();
    }

    public String getLogOutText(){

        return utils.doGetText(logOut);

        //return driver.findElement(logOut).getText();
    }

    public boolean isMyAccountPresent(){

        return driver.findElement(myAccount).isDisplayed();
    }

    public String getMyAccountText(){

        return driver.findElement(myAccount).getText();
    }



}



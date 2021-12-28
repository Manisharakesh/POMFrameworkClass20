package com.nopCommercedemostore.base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class BasePage {

    WebDriver driver;
    Properties prop;
    FileInputStream file;

    /**
     * This method is used to initialise the driver on the basis of browername.
     *
     * @param browserName
     * @return driver
     */
    public WebDriver initialiseDriver(String browserName) {
        if (browserName.equals("chrome")) {
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\mrkun\\POMFramework2\\src\\test\\resources\\BrowserDriver\\chromedriver.exe");//Set the path
             // WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver(); //initialised the driver with browser
        } else if (browserName.equals("edge")) {
            System.setProperty("webdriver.edge.driver", "C:\\Users\\mrkun\\POMFramework2\\src\\test\\resources\\BrowserDriver\\msedgedriver.exe");
            driver = new EdgeDriver();
        } else if (browserName.equals("firefox")) {
            System.setProperty("webdriver.gecko.driver", "C:\\Users\\mrkun\\POMFramework2\\src\\test\\resources\\BrowserDriver\\geckodriver.exe");
            driver = new FirefoxDriver();
        } else {
            System.out.println(browserName + "Browser is invalid, please enter correct browser name");
        }

        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();

        return driver;
    }

    /**
     * This method is used to read properties from config.properties file.
     *
     * @return prop
     */
    public Properties initialiseProperties() {
        prop = new Properties();

        try { //Location of file
            file = new FileInputStream( "C:\\Users\\mrkun\\POMFramework2\\src\\test\\resources\\" +
                    "TestData\\config.properties" );

            prop.load(file); //Loading the file
        } catch (FileNotFoundException e) {
            System.out.println("Config file is not found, please check...");
        } catch (IOException e) {
            System.out.println("Properties could not be loaded...");
            e.printStackTrace();
        }

        return prop;

    }
}




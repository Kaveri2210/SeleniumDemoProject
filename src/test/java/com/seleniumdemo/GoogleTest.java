package com.seleniumdemo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.*;
import io.github.bonigarcia.wdm.WebDriverManager;

public class GoogleTest {

    WebDriver driver;

    @Parameters("browser")  // <-- Receive browser parameter from TestNG
    @BeforeClass
    public void setup(@Optional("chrome") String browser) {
        switch(browser.toLowerCase()) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
           // case "edge":
           //     WebDriverManager.edgedriver().setup();
           //     driver = new EdgeDriver();
            //    break;
            default:
                System.out.println("Browser not supported, launching Chrome by default.");
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
        }
    }

    @Test
    public void openGoogle() {
        driver.get("https://www.google.com");
        System.out.println("Browser: " + driver.getClass().getSimpleName() + " | Title: " + driver.getTitle());
    }

    @AfterClass
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }
}

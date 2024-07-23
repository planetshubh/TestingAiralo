package com.airalo.tests;

import com.airalo.pages.HomePage;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class UITest extends BaseTest {

//    @BeforeMethod
//    public static void setup() {
//        WebDriverManager.chromedriver().setup();
//        WebDriver driver = new ChromeDriver();
//        WebDriverRunner.setWebDriver(driver);
//        WebDriverRunner.getWebDriver().manage().window().maximize();
//        Selenide.open("https://www.airalo.com");
//    }

    @Test
    public void testAiraloPurchase() {
        new HomePage()
                .openHome()
                .closePopup()
                .searchForJapan()
                .selectFirstPackage()
                .verifyPackageDetails();
    }

    @AfterMethod
    public void teardown() {
        WebDriverRunner.getWebDriver().quit();
    }
}

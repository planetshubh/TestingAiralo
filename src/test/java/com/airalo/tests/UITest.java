package com.airalo.tests;

import com.airalo.pages.HomePage;
import com.codeborne.selenide.WebDriverRunner;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;


public class UITest extends BaseTest {


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

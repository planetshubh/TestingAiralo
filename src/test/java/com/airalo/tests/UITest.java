package com.airalo.tests;

import com.airalo.pages.HomePage;
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
}

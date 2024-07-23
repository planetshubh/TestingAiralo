package com.airalo.pages;

import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class JapanPage {

    private static final SelenideElement firstPackageBuyNowButton = $(Selectors.byXpath("(//div[@class='sim-item-bottom-button d-flex'])[1]"));

    public PackagePage selectFirstPackage() {
        $(firstPackageBuyNowButton).click();
        return new PackagePage();
    }

}

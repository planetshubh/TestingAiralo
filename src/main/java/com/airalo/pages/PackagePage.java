package com.airalo.pages;

import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Condition.text;

public class PackagePage {

    private static final SelenideElement packageTitle = $(Selectors.byCssSelector(".sim-detail-operator"));
    private static final SelenideElement packageCoverage = $(Selectors.byXpath("//div[@class='c--sim_item-row sim-item-row light']//p[@data-testid='COVERAGE-value']"));
    private static final SelenideElement packageData = $(Selectors.byXpath("//ul[@class='sim-detail-info-list']//p[@data-testid='DATA-value']"));
    private static final SelenideElement packageValidity = $(Selectors.byXpath("//ul[@class='sim-detail-info-list']//p[@data-testid='VALIDITY-value']"));
    private static final SelenideElement packagePrice = $(Selectors.byXpath("//ul[@class='sim-detail-info-list']//p[@data-testid = 'PRICE-value']"));

    public void verifyPackageDetails() {
        packageTitle.shouldHave(text("Moshi Moshi"));
        packageCoverage.shouldHave(text("Japan"));
        packageData.shouldHave(text("1 GB"));
        packageValidity.shouldHave(text("7 days"));
        packagePrice.shouldHave(text("$4.50 USD"));
    }
}

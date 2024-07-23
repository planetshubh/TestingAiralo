package com.airalo.pages;

import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class HomePage {

    private static final SelenideElement searchField = $(Selectors.byXpath("//input[@data-testid='search-input']"));
    private static final SelenideElement popUpCLoseBtn = $(Selectors.byCssSelector("span[data-testid = 'close-button']"));
    private static final SelenideElement japanInDropdown = $(Selectors.byCssSelector("span[data-testid='Japan-name']"));

    public HomePage openHome() {
        Selenide.open("https://www.airalo.com");
        return this;
    }

    public HomePage closePopup() {
        popUpCLoseBtn.click();
        return this;
    }

    public JapanPage searchForJapan() {
        searchField.setValue("Japan");
        japanInDropdown.click();
        return new JapanPage();
    }

}

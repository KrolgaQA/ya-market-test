package ru.aplana.auto.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class YandexMainPage extends BasePage {

    @FindBy(xpath = "//a[contains(@data-id, 'market') and contains(text(), 'Маркет')]")
    WebElement selectMarketMenu;

    public void selectYandexMarketFromMainMenu() {
        selectMarketMenu.click();
    }

}

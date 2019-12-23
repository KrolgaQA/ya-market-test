package ru.aplana.auto.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MarketChooseCategoryPage extends BasePage {
    @FindBy(xpath = "//span[contains(@class, 'n-w-tab__control-caption') and contains(text(), 'Электроника')]")
    WebElement selectCategoryElBtn;

    @FindBy(xpath = "/html/body/div[5]/div[3]/div/div/div[2]/div[1]/span")
    WebElement acceptRegionBtn;

    public void acceptRegion() {
        acceptRegionBtn.click();
    }

    public void selectElectronicCategory() {
        selectCategoryElBtn.click();
    }

}

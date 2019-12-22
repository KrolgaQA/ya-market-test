package ru.aplana.auto.pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MarketChooseCategoryPage {
    @FindBy(xpath = "//span[contains(@class, 'n-w-tab__control-caption') and contains(text(), 'Электроника')]")
    WebElement selectCategoryElBtn;

    public void selectCategory() {
        selectCategoryElBtn.click();
    }

}

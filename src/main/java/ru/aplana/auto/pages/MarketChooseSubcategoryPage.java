package ru.aplana.auto.pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MarketChooseSubcategoryPage {
    @FindBy(xpath = "//a[contains(@class, '_2qvOOvezty _2x2zBaVN-3 _9qbcyI_fyS') and contains(text(), 'Телевизоры')]")
    WebElement selectSubcategoryBtn;

    public void selectSubcategory() {
        selectSubcategoryBtn.click();
    }

}

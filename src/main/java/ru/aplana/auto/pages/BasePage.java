package ru.aplana.auto.pages;

import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import ru.aplana.auto.configuration.WebDriverConfiguration;


public class BasePage {

    WebDriver driver;

    public BasePage() {
        this.driver = WebDriverConfiguration.getDriver();
        PageFactory.initElements(driver, this);
    }

    //Заполнение полей
    public void fillField(WebElement element, String value) {
        element.clear();
        element.sendKeys(value);
    }

    public void fillCheckBox(WebElement element, Keys key) {
        element.sendKeys(key);
    }



    public void checkPageTitle(String pageTitle) {
        Assert.assertEquals(driver.getTitle(), pageTitle);
    }


}

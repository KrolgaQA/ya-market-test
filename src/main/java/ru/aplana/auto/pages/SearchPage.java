package ru.aplana.auto.pages;


import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SearchPage extends BasePage {

    @FindBy(name = "Цена от")
    WebElement priceStart;

    @FindBy(xpath = "//input[contains(@type, 'checkbox') and contains(@name, 'Производитель Samsung')]")
    WebElement samsungProducer;

    @FindBy(xpath = "//input[contains(@type, 'checkbox') and contains(@name, 'Производитель LG')]")
    WebElement lgProducer;

    @FindBy(xpath = "//*[starts-with(@id, 'product')]")
    List<WebElement> searchResults;

    @FindBy(id = "header-search")
    WebElement searchItem;

    @FindBy(className = "search2__button")
    WebElement searchButton;

    public WebElement getPriceStart() {
        return priceStart;
    }

    public WebElement getSamsungProducer() {
        return samsungProducer;
    }

    public WebElement getLgProducer() {
        return lgProducer;
    }

    public List<WebElement> getSearchResults() {
        return searchResults;
    }

    public WebElement getSearchItem() {
        return searchItem;
    }

    public WebElement getSearchButton() {
        return searchButton;
    }


    public void checkCountOfResultElements(int expectedCount) {
        int actualCount = searchResults.size();
        Assert.assertEquals(expectedCount, actualCount);
    }

    public String getFirstElementTitle() {
        return searchResults.get(0)
                .findElement(By.xpath("//div[4]/div[1]/h3/a")).getAttribute("title");
    }
}

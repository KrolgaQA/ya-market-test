package ru.aplana.auto.steps;

import org.junit.Assert;
import org.openqa.selenium.Keys;
import ru.aplana.auto.pages.MarketChooseCategoryPage;
import ru.aplana.auto.pages.MarketChooseSubcategoryPage;
import ru.aplana.auto.pages.SearchPage;
import ru.aplana.auto.pages.YandexMainPage;
import ru.aplana.auto.util.ProducerType;
import ru.yandex.qatools.allure.annotations.Step;

public class ScenarioSteps {
    YandexMainPage yandexMainPage = new YandexMainPage();
    MarketChooseCategoryPage marketChooseCategoryPage = new MarketChooseCategoryPage();
    MarketChooseSubcategoryPage marketChooseSubcategoryPage = new MarketChooseSubcategoryPage();
    SearchPage searchPage = new SearchPage();
    String itemTitle;

    @Step("Переход на страницу Яндекс Маркета")
    public void getMarketPage() {
        yandexMainPage.selectMainMenu();
    }

    @Step("Выбор категории Электроника")
    public void getCategory() {
        marketChooseCategoryPage.selectCategory();
    }

    @Step("Выбор подкатегории Телевизоры")
    public void getSubcategory() {
        marketChooseSubcategoryPage.selectSubcategory();
    }


    @Step("Заполнение поля фильтра Цена от значением [0]")
    public void fillPriceStart(String price) {
        searchPage.fillField(searchPage.getPriceStart(), price);
    }

    @Step("Заполняем чекбокс фильтра Производитель [0]")
    public void fillChekbox(ProducerType type) {
        switch (type) {
            case Samsung:
                searchPage.fillCheckBox(searchPage.getSamsungProducer(), Keys.SPACE);
                break;
            case LG:
                searchPage.fillCheckBox(searchPage.getLgProducer(), Keys.SPACE);
                break;
            default:
                throw new AssertionError("Unknown producer");
        }
    }

    @Step("Проверяем количество выведенных результатов")
    public void checkResultsCount(int expectedCount){
        searchPage.checkCountOfResultElements(expectedCount);
    }

    @Step("Запоминаем название первого элемента списка по фильтру")
    public void saveProductTitle(){
        itemTitle = searchPage.getFirstElementTitle();
    }

    @Step("Заполняем поле поиска наименованием")
    public void fillSearchWithSavedTitle(){
        searchPage.fillField(searchPage.getSearchItem(), itemTitle);
    }

    @Step("Кликаем на кнопку поиска")
    public void clickSearchBtn(){
        searchPage.getSearchButton().click();
    }

    @Step("Проверяем, что наименования совпадают")
    public void checkTitlesEquals(){
        Assert.assertEquals(itemTitle, searchPage.getFirstElementTitle());
    }

}

package ru.aplana.auto.steps;

import org.junit.Assert;
import org.openqa.selenium.Keys;
import ru.aplana.auto.pages.SearchPage;
import ru.aplana.auto.util.ProducerType;
import ru.yandex.qatools.allure.annotations.Step;

public class SearchSteps {

    SearchPage searchPage = new SearchPage();
    String itemTitle;

    @Step("Заполнение поля фильтра \"Цена от\" значением: [0]")
    public void fillPriceStart(String price) {
        searchPage.fillField(searchPage.getPriceStart(), price);
    }

    @Step("Заполняем чекбокс фильтра \"Производитель\" [0]")
    public void fillProducerFilter(ProducerType type) {
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

    @Step("Проверяем, что количество выведенных результатов равно [0]")
    public void checkResultsCount(int expectedCount){
        searchPage.checkCountOfResultElements(expectedCount);
    }

    @Step("Сохраняем наименование первого товара из результатов фильтрации")
    public void saveProductTitle(){
        itemTitle = searchPage.getFirstElementTitle();
    }

    @Step("Заполняем поле поиска сохраненным наименованием")
    public void fillSearchWithSavedTitle(){
        searchPage.fillField(searchPage.getSearchItem(), itemTitle);
    }

    @Step("Кликаем на кнопку \"Найти\"")
    public void clickSearchBtn(){
        searchPage.getSearchButton().click();
    }

    @Step("Проверяем, что наименования товаров совпадают")
    public void checkTitlesEquals(){
        Assert.assertEquals(itemTitle, searchPage.getFirstElementTitle());
    }
}

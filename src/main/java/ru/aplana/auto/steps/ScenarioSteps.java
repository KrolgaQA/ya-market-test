package ru.aplana.auto.steps;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import ru.aplana.auto.util.ProducerType;

public class ScenarioSteps {
    YandexMainSteps yandexMainSteps = new YandexMainSteps();
    MarketChooseCategorySteps categorySteps = new MarketChooseCategorySteps();
    MarketChooseSubcategorySteps subcategorySteps = new MarketChooseSubcategorySteps();
    SearchSteps searchSteps = new SearchSteps();

    @When("^Переходим на страницу \"Яндекс Маркет\"$")
    public void goToMarketPage() {
        yandexMainSteps.selectMarket();
    }

    @When("^Подтверждаем регион$")
    public void accept() {
        categorySteps.acceptRegion();
    }

    @When("^Выбираем категорию \"Электроника\"$")
    public void getElectronicCategory() {
        categorySteps.selectElectronic();
    }

    @When("^Выбираем подкатегорию \"Телевизоры\"$")
    public void getTVSubcategory() {
        subcategorySteps.selectTV();
    }

    @When("^Заполняем поле фильтра Цена значением \"(.+)\"$")
    public void fillPriceStart(String price) {
        searchSteps.fillPriceStart(price);
    }

    @When("^Заполняем чекбокс фильтра Производитель: \"(.+)\"$")
    public void fillProducerCheckbox(ProducerType type) {
        searchSteps.fillProducerFilter(type);
    }

    @Then("^Проверяем, что количество выведенных результатов равно: \"(.+)\"$")
    public void checkResults(int expectedCount){
        searchSteps.checkResultsCount(expectedCount);
    }

    @Then("^Запоминаем название первого товара из списка результатов по фильтру$")
    public void saveTitle(){
        searchSteps.saveProductTitle();
    }

    @When("^Заполняем поле поиска наименованием сохраненного товара$")
    public void searchSavedTitle(){
        searchSteps.fillSearchWithSavedTitle();
    }

    @When("^Кликаем на кнопку поиска$")
    public void clickSearchBtn(){
        searchSteps.clickSearchBtn();
    }

    @Then("^Проверяем, что наименования товаров совпадают$")
    public void checkTitlesEquals(){
        searchSteps.checkTitlesEquals();
    }

}

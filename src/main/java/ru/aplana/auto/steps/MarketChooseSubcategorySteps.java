package ru.aplana.auto.steps;

import ru.aplana.auto.pages.MarketChooseSubcategoryPage;
import ru.yandex.qatools.allure.annotations.Step;

public class MarketChooseSubcategorySteps {

    @Step("Выбор подкатегории Телевизоры")
    public void selectTV(){
        new MarketChooseSubcategoryPage().selectTVSubcategory();
    }
}

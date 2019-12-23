package ru.aplana.auto.steps;

import ru.aplana.auto.pages.MarketChooseCategoryPage;
import ru.yandex.qatools.allure.annotations.Step;

public class MarketChooseCategorySteps {

    @Step("Подтверждаем регион")
    public void acceptRegion() {
        new MarketChooseCategoryPage().acceptRegion();
    }

    @Step("Выбираем категорию Электроника")
    public void selectElectronic() {
        new MarketChooseCategoryPage().selectElectronicCategory();
    }
}

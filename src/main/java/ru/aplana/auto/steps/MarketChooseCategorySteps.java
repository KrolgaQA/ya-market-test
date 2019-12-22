package ru.aplana.auto.steps;

import ru.aplana.auto.pages.MarketChooseCategoryPage;
import ru.yandex.qatools.allure.annotations.Step;

public class MarketChooseCategorySteps {
    @Step("Выбираем категорию Электроника")
    public void selectCategory() {
        new MarketChooseCategoryPage().selectCategory();
    }
}

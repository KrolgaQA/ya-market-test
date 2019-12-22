package ru.aplana.auto.steps;

import ru.aplana.auto.pages.YandexMainPage;
import ru.yandex.qatools.allure.annotations.Step;

public class YandexMainSteps {
    @Step("Переход в Яндекс Маркет")
    public void selectMainMenu(){
        new YandexMainPage().selectMainMenu();
    }
}

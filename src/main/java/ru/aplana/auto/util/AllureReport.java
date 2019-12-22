package ru.aplana.auto.util;

import gherkin.formatter.model.Result;
import ru.aplana.auto.configuration.WebDriverConfiguration;
import ru.yandex.qatools.allure.Allure;
import ru.yandex.qatools.allure.cucumberjvm.AllureReporter;
import ru.yandex.qatools.allure.events.MakeAttachmentEvent;


public class AllureReport extends AllureReporter {
    @Override
    public void result(Result result) {
        if ("failed".equals(result.getStatus())) takeScreenshot(result);
        super.result(result);

    }

    private void takeScreenshot(Result result) {
        if (WebDriverConfiguration.getDriver() != null) {
            Allure.LIFECYCLE.fire(
                    new MakeAttachmentEvent(
                            WebDriverConfiguration.takeScreenshot(), "Скриншот в момент ошибки", "image/png"));
        }
    }
}

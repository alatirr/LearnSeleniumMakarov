package ru.autotests.util;

import org.junit.runner.notification.Failure;
import ru.yandex.qatools.allure.junit.AllureRunListener;
import ru.autotests.scenario.ScenarioHooks;

/**
 * Created by Владимир on 17.11.2018.
 */
public class AllureListener extends AllureRunListener {

    @Override
    public void testFailure(Failure failure){
        ScenarioHooks.takeScreenshot();
        super.testFailure(failure);
    }
}

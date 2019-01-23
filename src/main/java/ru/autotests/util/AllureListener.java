package ru.autotests.util;

import org.junit.runner.notification.Failure;
import ru.yandex.qatools.allure.junit.AllureRunListener;
import ru.autotests.steps.BaseSteps;

/**
 * Created by Владимир on 17.11.2018.
 */
public class AllureListener extends AllureRunListener {

    @Override
    public void testFailure(Failure failure){
        BaseSteps.takeScreenshot();
        super.testFailure(failure);
    }
}

package ru.autotests.steps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import ru.autotests.pages.BasePage;
import ru.yandex.qatools.allure.annotations.Step;

public class BaseStepsMethods extends BaseSteps {

    public BaseStepsMethods() throws Exception {
        setup();
        PageFactory.initElements(BaseSteps.getDriver(), this);
    }

    //field - название поля для отчета, value - значение,
    @Step("поле {0} заполняется значением {1}")
    public void fillField(String field, String value, WebElement element){
        new BasePage().fillField(element, value);
    }

    @Step("поле дата {0} заполняется значением {1}")
    public void fillFieldDate(String field, String value, WebElement dateWebElement, WebDriver driver){
        new BasePage().fillFieldDate(dateWebElement, value, driver);
    }

    @Step("Клик по кнопке {0}")
    public void clickButton(String field, WebElement element){
        new BasePage().clickWebElement(element);
    }

    @Step("Клик по ссылке {0}")
    public void clickLink(String field, WebElement element){
        new BasePage().clickWebElement(element);
    }

    @Step("Проверка заполнения поля {0} значением {1}")
    public void checkFillField(String field, String value, WebElement element){
        new BasePage().checkFillField(value, element);
    }

    @Step("Проверка отмеченности чекбокса {0} ")
    public void checkSelectedElement(String field, boolean value, WebElement element){
        new BasePage().checkSelectedElement(value, element);
    }

    @Step("Проверка существования элемента {0}")
    public void checkEnabledElement(String field, boolean value, WebElement element){
        new BasePage().checkEnabledElement(value, element);
    }

    @Step("Проверка отображения элемента {0}")
    public void checkDisplayedElement(String field, boolean value, WebElement element){
        new BasePage().checkDisplayedElement(value, element);
    }

    @Step("Переключаемся на вкладку {0}")
    public void swichTab(int numberTab){
        new BasePage().swichTab(numberTab, driver);
    }


//
//    @Step("в поле {0} присутствует сообщение об ошибке {1}")
//    public void checkErrorMessageField(String field, String value){
//        new SendAppPage().checkFieldErrorMessage(field, value);
//    }
//
//    @Step("заголовок страницы - Отправить заявку равен {0}")
//    public void checkPageTitle(String expectedTitle){
//        String actualTitle = new SendAppPage().title.getText();
//        assertTrue(String.format("Заголовок равен [%s]. Ожидалось - [%s]",
//                actualTitle, expectedTitle), actualTitle.contains(expectedTitle));
//    }
//
//    @Step("заполняются поля")
//    public void fillFields(HashMap<String, String> fields){
//        fields.forEach((k, v)-> fillField(k,v));
//    }
//
//    @Step("поля заполнены верно")
//    public void checkFillFields(HashMap<String, String> fields){
//        fields.forEach((k, v)-> checkFillField(k,v));
//    }
}

package ru.autotests.pages;

import ru.autotests.steps.BaseSteps;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class BasePage {

    public WebDriver driver;

    public BasePage() {
        PageFactory.initElements(BaseSteps.getDriver(), this);
    }

    public BasePage(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void fillField(WebElement element, String value) {
        element.clear();
        element.sendKeys(value);
    }

    //метод для вввода данных в поле формата Date.
    // В связи с тем, что элемент не активен, имитируем, наведение мыши на элемент а затем делаем клик
    public WebElement fillFieldDate(WebElement dateWebElement, String value, WebDriver driver) {
        Actions actions = new Actions(driver);
        actions.moveToElement(dateWebElement);
        actions.click();
        actions.sendKeys(value);
        actions.build().perform();
        return dateWebElement;
    }

    //Проверка наличия элемента
    protected boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public void clickWebElement(WebElement element) {
        element.click();
    }

    //Проверка сравнивает значение текста у поля ввода со строковой перменной
    public void checkFillField(String value, WebElement element) {
        String sss = element.getAttribute("value");
        assertEquals(value, sss);
    }

    //Провека отметки элемента
    public void checkSelectedElement(boolean value, WebElement element) {
        assertEquals(value, element.isSelected());
    }

    //Проверка доступности элемента
    public void checkEnabledElement(boolean value, WebElement element) {
        assertEquals(value, element.isEnabled());
    }

    //Проверка отображения элемента
    public void checkDisplayedElement(boolean value, WebElement element) {
        assertEquals(value, element.isDisplayed());
    }

    //Указываем селениуму, на какую вкладку переключиться
    public void swichTab(int numberTab, WebDriver driver) {
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(numberTab));
    }

}

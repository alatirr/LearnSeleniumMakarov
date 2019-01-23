package ru.autotests.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.autotests.steps.BaseSteps;

public class SberbankPersonPage extends BasePage {
    //Кнопка страхование
    @FindBy(xpath = "//SPAN[@class='lg-menu__text'][text()='Страхование']")
    public WebElement insurance;
    //Кнопка путешествия и покупки
    @FindBy(xpath = "(//A[@href='/ru/person/bank_inshure/insuranceprogram/travel_and_shopping'][text()='Путешествия и покупки'][text()='Путешествия и покупки'])[1]")
    public WebElement travelAndShopping;
    //Кнопка страхование путешественников
    @FindBy(xpath = "(//H3[text()='Страхование путешественников'])[1]")
    public WebElement insuranceTraveler;
    //Кнопка оформить онлайн
    @FindBy(xpath = "//A[text()='Оформить онлайн']")
    public WebElement makeOnline;

    public SberbankPersonPage(){
        PageFactory.initElements( BaseSteps.getDriver(),this);
    }

    public SberbankPersonPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void clickWebElement(WebElement element) {
        element.click();
    }
}

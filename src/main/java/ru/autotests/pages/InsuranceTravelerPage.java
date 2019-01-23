package ru.autotests.pages;

import ru.autotests.steps.BaseSteps;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
//Страница страхования и путешествия
public class InsuranceTravelerPage extends BasePage {

    //Кнопка минимальная ставка
    @FindBy(xpath = "(//DIV[@ng-click='setProdProg(prodProg)'])[1]")
    public WebElement minimun;

    //Оформить кнопка
    @FindBy(xpath = "//SPAN[@ng-click='save()'][text()='Оформить']")
    public WebElement toIssue;
    //Поле Фамилия застрахованного
    @FindBy(name = "insured0_surname")
    public WebElement insuredSurname;
    //Поле Имя застрахованного
    @FindBy(name = "insured0_name")
    public WebElement insuredName;
    //Поле дата рождения застрахованного
    @FindBy(name = "insured0_birthDate")
    public WebElement  insuredBirthDate;
    //Поле Фамилия страхователя
    @FindBy(name = "surname")
    public WebElement surname;
    //Поле Имя страхователя
    @FindBy(name = "name")
    public WebElement name;
    //Поле Отчество страхователя
    @FindBy(name = "middlename")
    public WebElement middlename;
    //Радиобаттон пол
    @FindBy(xpath = "(//INPUT[@ng-model='formdata.insurer.GENDER'])[1]")
    public WebElement gender;
    //Поле дата рождения страхователя
    @FindBy(name = "birthDate")
    public WebElement birthDate;
    //поле серия паспорта
    @FindBy(xpath = "//INPUT[@ng-model='formdata.insurer.documentList[0].DOCSERIES']")
    public WebElement docSeries;
    //поле номер паспорта
    @FindBy(xpath = "//INPUT[@ng-model='formdata.insurer.documentList[0].DOCNUMBER']")
    public WebElement docNumber;
    //поле дата выдачи паспорта
    @FindBy(name = "issueDate")
    public WebElement issueDate;
    //поле кем выдан паспорт
    @FindBy(name = "issuePlace")
    public WebElement issuePlace;
    //кнопка продолжить
    @FindBy(xpath = "//SPAN[@ng-click='save()'][text()='Продолжить']")
    public WebElement keepOne;
    //Текст Заполнены не все обязательные поля
    @FindBy(xpath = "//DIV[@ng-show='tryNext && myForm.$invalid'][text()='Заполнены не все обязательные поля']")
    public WebElement checkAllField;

    public InsuranceTravelerPage (){
        PageFactory.initElements(BaseSteps.getDriver(),this);
    }

    public InsuranceTravelerPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }
}

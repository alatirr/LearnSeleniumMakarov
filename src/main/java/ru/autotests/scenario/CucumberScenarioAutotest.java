package ru.autotests.scenario;


import cucumber.api.java.ru.Когда;
import cucumber.api.java.ru.Тогда;
import org.openqa.selenium.WebElement;
import ru.autotests.pages.InsuranceTravelerPage;
import ru.autotests.pages.SberbankPersonPage;
import ru.autotests.steps.BaseStepsMethods;

import java.util.ArrayList;
import java.util.Map;

public class CucumberScenarioAutotest  {
    BaseStepsMethods bSM = new BaseStepsMethods();
    InsuranceTravelerPage insTravelPg = new InsuranceTravelerPage();
    SberbankPersonPage sbPersPg = new SberbankPersonPage();
    ArrayList< WebElement> alWebElement;

    public CucumberScenarioAutotest() throws Exception {
    }

        @Когда("Инициализирована страница")
        public void инициализированаСтраница() throws Exception {
            // Write code here that turns the phrase above into concrete actions
            alWebElement = new ArrayList<WebElement>();
            alWebElement.add(insTravelPg.insuredSurname);
            alWebElement.add(insTravelPg.insuredName);
            alWebElement.add(insTravelPg.insuredBirthDate);
            alWebElement.add(insTravelPg.surname);
            alWebElement.add(insTravelPg.name);
            alWebElement.add(insTravelPg.middlename);
            alWebElement.add(insTravelPg.birthDate);
            alWebElement.add(insTravelPg.docSeries);
            alWebElement.add(insTravelPg.docNumber);
            alWebElement.add(insTravelPg.issueDate);
            alWebElement.add(insTravelPg.issuePlace);
        }

        @Когда("^Выбран пункт меню страхование \"(.+)\"$")
        public void выбранПунктМенюСтрахование (String isurance) {
            bSM.clickLink(isurance, sbPersPg.insurance);
        }

        @Когда("^Выбран пункт меню путешествия и покупки \"(.+)\"$")
        public void выбранПунктМенюПутешествияИПокупки (String travShop) {
            bSM.clickLink(travShop, sbPersPg.travelAndShopping);
        }

        @Когда("^Выбран пункт меню страхование путешественников \"(.+)\"$")
        public void выбранПунктМенюСтрахованиеПутешественников (String insuranceTraveler ) {
            bSM.clickLink(insuranceTraveler, sbPersPg.insuranceTraveler);
        }

        @Когда("^Пункт меню страхование путешественников \"(.+)\" доступен$")
        public void пунктМенюСтрахованиеПутешественниковДоступен (String insuranceTraveler) {
           bSM.checkDisplayedElement(insuranceTraveler, true, sbPersPg.insuranceTraveler);
        }

        @Когда("^Выполнено нажатие на кнопку оформить онлайн \"(.+)\"$")
        public void выполненоНажатиеНаКнопкуОформитьОнлайн (String makeOnline) {
           bSM.clickButton(makeOnline, sbPersPg.makeOnline);
        }

        @Когда("^Выполнено переключение на открывшуюся вкладку (\\d+)$")
        public void выполненоПереключениеНаОткрывшуюсяВкладку (Integer int1) {
           bSM.swichTab(int1);
        }

        @Когда("^Выбран пункт меню минимальная \"(.+)\"$")
        public void выбранПунктМенюМинимальная (String minimun) {
          bSM.clickLink(minimun, insTravelPg.minimun);
        }

        @Когда("^Выполнено нажатие на кнопку оформить \"(.+)\"$")
        public void выполеноНажатиеНаКнопкуОформить (String toIssue) {
           bSM.clickButton(toIssue, insTravelPg.toIssue);
        }

        @Когда("^Заполняются поля:$")
        public void заполняютсяПоля(Map<String, String> arg) {
            bSM.fillFields(arg, alWebElement);
        }

        @Когда("^Выбран пункт меню пол \"(.+)\"$")
        public void выбранПунктМенюПол(String gender){
            bSM.clickLink(gender, insTravelPg.gender);
        }

        @Тогда("^Значения полей равны:$")
        public void значенияПолейРавны(Map<String, String> arg){
            bSM.checkFillFields(arg, alWebElement);
        }

        @Тогда("^Значение поля равно:$")
        public void значениеПоляРавно(Map<String, String> arg){
            bSM.checkSelectedElement(arg, insTravelPg.gender);

        }

        @Когда("^Выполнено нажатие на кнопку продолжить \"(.+)\"$")
        public void выполненоНажатиеНаКнопкуПродолжить (String keepOne) {
            bSM.clickButton(keepOne, insTravelPg.keepOne);
        }

        @Когда("^Отображается уведомление \"(.+)\"$")
        public void отображаетсяУведомлениеЗаполненыНеВсеОбязательныеПоля (String checkAllField) {
            bSM.checkEnabledElement(checkAllField, true, insTravelPg.checkAllField);
        }

}

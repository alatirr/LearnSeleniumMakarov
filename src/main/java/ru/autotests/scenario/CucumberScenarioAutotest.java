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
    BaseStepsMethods bSM;
    InsuranceTravelerPage insTravelPg;
    SberbankPersonPage sbPersPg;
    ArrayList< WebElement> alWebElement;

        @Когда("Инициализирована страница")
        public void инициализированаСтраница() throws Exception {
            // Write code here that turns the phrase above into concrete actions
            bSM = new BaseStepsMethods();
            insTravelPg = new InsuranceTravelerPage();
            sbPersPg = new SberbankPersonPage();
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


        @Когда("Выбран пункт меню Страхование")
        public void выбранПунктМенюСтрахование () {
            bSM.clickLink("Страхование", sbPersPg.insurance);
        }

        @Когда("Выбран пункт меню Путешествия и покупки")
        public void выбранПунктМенюПутешествияИПокупки () {
            bSM.clickLink("Путешествия и покупки", sbPersPg.travelAndShopping);
        }

        @Когда("Выбран пункт меню Страхование путешественников")
        public void выбранПунктМенюСтрахованиеПутешественников () {
            bSM.clickLink("Страхование путешественников", sbPersPg.insuranceTraveler);
        }

        @Когда("Пункт меню Страхование путешественников доступен")
        public void пунктМенюСтрахованиеПутешественниковДоступен () {
           bSM.checkDisplayedElement("Страхование путешественников", true, sbPersPg.insuranceTraveler);
        }

        @Когда("Выполнено нажатие на кнопку Оформить онлайн")
        public void выполненоНажатиеНаКнопкуОформитьОнлайн () {
           bSM.clickButton("Оформить онлайн", sbPersPg.makeOnline);
        }

        @Когда("Выполнено переключение на открывшуюся вкладку")
        public void выполненоПереключениеНаОткрывшуюсяВкладку () {
           bSM.swichTab(1);
        }

        @Когда("Выбран пункт меню Минимальная")
        public void выбранПунктМенюМинимальная () {
          bSM.clickLink("Минимальная", insTravelPg.minimun);
        }

        @Когда("Выполено нажатие на кнопку Оформить")
        public void выполеноНажатиеНаКнопкуОформить () {
           bSM.clickButton("Оформить", insTravelPg.toIssue);
        }

        @Когда("Заполняются поля:")
        public void заполняютсяПоля(Map<String, String> arg) {
            int i = 0;
            for(Map.Entry<String, String> entry : arg.entrySet()){
                bSM.fillField(entry.getKey(),entry.getValue(), alWebElement.get(i));
                i++;
            }

        }

        @Когда("Выбран пункт меню Пол")
        public void выбранПунктМенюПол(){
            bSM.clickLink("Пол", insTravelPg.gender);
        }

        @Тогда("Значения полей равны:")
        public void значенияПолейРавны (Map<String, String> arg){
            int i = 0;
            for(Map.Entry<String, String> entry : arg.entrySet()){
                bSM.checkFillField(entry.getKey(),entry.getValue(), alWebElement.get(i));
                i++;
            }
        }

        @Тогда("Значение поля равно:")
        public void значениеПоляРавно(Map<String, String> arg){
            for(Map.Entry<String, String> entry : arg.entrySet()){
                bSM.checkSelectedElement(entry.getKey(), true, insTravelPg.gender);
            }
        }

        @Когда("Выполнено нажатие на кнопку Продолжить")
        public void выполненоНажатиеНаКнопкуПродолжить () {
            bSM.clickButton("Продолжить", insTravelPg.keepOne);
        }

        @Когда("Отображается уведомление Заполнены не все обязательные поля")
        public void отображаетсяУведомлениеЗаполненыНеВсеОбязательныеПоля () {
            bSM.checkEnabledElement("Заполнены не все обязательные поля", true, insTravelPg.checkAllField);
        }
        //Тогда используем композицию
        @Когда("Хуки нельзя наследовать")
        public void хукиНельзяНаследовать() {
            try {
               bSM.tearDown();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
}

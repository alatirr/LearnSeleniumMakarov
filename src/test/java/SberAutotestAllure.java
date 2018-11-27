import org.junit.Test;
import pages.InsuranceTravelerPage;
import pages.SberbankPersonPage;
import ru.yandex.qatools.allure.annotations.Title;
import steps.BaseStepsMethods;

public class SberAutotestAllure extends BaseTest{

    BaseStepsMethods bSM = new BaseStepsMethods();
    InsuranceTravelerPage insTravelPg = new InsuranceTravelerPage(driver);
    SberbankPersonPage sbPersPg = new SberbankPersonPage(driver);

    @Title("Оформление страховки на сайте сбербанка")
    @Test
    public void Test(){
        bSM.clickLink("Страхование", sbPersPg.insurance);
        bSM.clickLink("Путешествия и покупки", sbPersPg.travelAndShopping);
        bSM.clickLink("Страхование путешественников", sbPersPg.insuranceTraveler);
        //assertEquals(true, sberbankPersonPage.insuranceTraveler.isDisplayed());
        bSM.clickButton("Оформить онлайн",sbPersPg.makeOnline);
        bSM.swichTab(1, driver);
        bSM.clickLink("Минимальная", insTravelPg.minimun);
        bSM.clickButton("Оформить", insTravelPg.toIssue);
        //Данные застрахованного
        bSM.fillField("Фамилия застрахованного", "IVANOV", insTravelPg.insuredSurname);
        bSM.fillField("Имя застрахованного ","IVAN",insTravelPg.insuredName);
        bSM.fillField("Дата рождения застрахованного", "12121995", insTravelPg.insuredBirthDate);
        //Данные страхователя
        bSM.fillField("Фамлия страхователя", "Петров", insTravelPg.surname);
        bSM.fillField("Имя страхователя", "Петр", insTravelPg.name);
        bSM.fillField("Отчество страхователя", "Петрович", insTravelPg.middlename);
        bSM.clickLink("Пол", insTravelPg.gender);
        bSM.fillField("Дата рождения страхователя", "11111999", insTravelPg.birthDate);
        bSM.fillField("Серия паспорта страхователя", "2222", insTravelPg.docSeries);
        bSM.fillField("Номер паспорта страхователя", "666666", insTravelPg.docNumber);
        bSM.fillField("Дата выдачи паспорта страхователя", "09092009", insTravelPg.issueDate);
        bSM.fillField("Кем выдан паспорт страхователю", "Московским ОВД", insTravelPg.issuePlace);
        //Проверка полей
        bSM.checkFillField("Фамилия застрахованного", "IVANOV", insTravelPg.insuredSurname);
        bSM.checkFillField("Имя застрахованного ","IVAN",insTravelPg.insuredName);
        bSM.checkFillField("Дата рождения застрахованного", "12.12.1995", insTravelPg.insuredBirthDate);
        bSM.checkFillField("Фамлия страхователя", "Петров", insTravelPg.surname);
        bSM.checkFillField("Имя страхователя", "Петр", insTravelPg.name);
        bSM.checkFillField("Отчество страхователя", "Петрович", insTravelPg.middlename);
        bSM.checkSelectedElement("Пол", true ,insTravelPg.gender);
        bSM.checkFillField("Дата рождения страхователя", "11.11.1999", insTravelPg.birthDate);
        bSM.checkFillField("Серия паспорта страхователя", "2222", insTravelPg.docSeries);
        bSM.checkFillField("Номер паспорта страхователя", "666666", insTravelPg.docNumber);
        bSM.checkFillField("Дата выдачи паспорта страхователя", "09.09.2009", insTravelPg.issueDate);
        bSM.checkFillField("Кем выдан паспорт страхователю", "Московским ОВД", insTravelPg.issuePlace);
        bSM.clickButton("Продолжить", insTravelPg.keepOne);
        bSM.checkEnabledElement("Заполнены не все обязательные поля", true, insTravelPg.checkAllField);
    }
}

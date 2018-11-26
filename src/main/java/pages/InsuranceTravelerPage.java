package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class InsuranceTravelerPage extends BasePage {
    @FindBy(xpath = "(//DIV[@ng-click='setProdProg(prodProg)'])[1]")
    WebElement minimun;

    @FindBy(xpath = "//SPAN[@ng-click='save()'][text()='Оформить']")
    WebElement toIssue;

    @FindBy(name = "insured0_surname")
    WebElement insuredSurname;

    @FindBy(name = "insured0_name")
    WebElement insuredName;

    @FindBy(name = "middlename")
    WebElement middlename;

    @FindBy(xpath = "(//INPUT[@ng-model='formdata.insurer.GENDER'])[1]")
    WebElement gender;

    @FindBy(name = "birthDate")
    WebElement birthDate;

    @FindBy(xpath = "//INPUT[@ng-model='formdata.insurer.documentList[0].DOCSERIES']")
    WebElement docSeries;

    @FindBy(xpath = "//INPUT[@ng-model='formdata.insurer.documentList[0].DOCNUMBER']")
    WebElement docNumber;

    @FindBy(name = "issueDate")
    WebElement issueDate;

    @FindBy(name = "issuePlace")
    WebElement issuePlace;

    @FindBy(xpath = "//SPAN[@ng-click='save()'][text()='Продолжить']")
    WebElement keepOne;

    @FindBy(xpath = "//DIV[@ng-show='tryNext && myForm.$invalid'][text()='Заполнены не все обязательные поля']")
    WebElement checkAllField;

}

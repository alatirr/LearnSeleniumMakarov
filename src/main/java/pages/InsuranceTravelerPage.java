package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import steps.BaseSteps;

public class InsuranceTravelerPage extends BasePage {
    @FindBy(xpath = "(//DIV[@ng-click='setProdProg(prodProg)'])[1]")
    public WebElement minimun;

    @FindBy(xpath = "//SPAN[@ng-click='save()'][text()='Оформить']")
    public WebElement toIssue;

    @FindBy(name = "insured0_surname")
    public WebElement insuredSurname;

    @FindBy(name = "insured0_name")
    public WebElement insuredName;

    @FindBy(name = "insured0_birthDate")
    public WebElement  insuredBirthDate;

    @FindBy(name = "surname")
    public WebElement surname;

    @FindBy(name = "name")
    public WebElement name;

    @FindBy(name = "middlename")
    public WebElement middlename;

    @FindBy(xpath = "(//INPUT[@ng-model='formdata.insurer.GENDER'])[1]")
    public WebElement gender;

    @FindBy(name = "birthDate")
    public WebElement birthDate;

    @FindBy(xpath = "//INPUT[@ng-model='formdata.insurer.documentList[0].DOCSERIES']")
    public WebElement docSeries;

    @FindBy(xpath = "//INPUT[@ng-model='formdata.insurer.documentList[0].DOCNUMBER']")
    public WebElement docNumber;

    @FindBy(name = "issueDate")
    public WebElement issueDate;

    @FindBy(name = "issuePlace")
    public WebElement issuePlace;

    @FindBy(xpath = "//SPAN[@ng-click='save()'][text()='Продолжить']")
    public WebElement keepOne;

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

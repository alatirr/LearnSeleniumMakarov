package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SberbankPersonPage extends BasePage {
    @FindBy(xpath = "//SPAN[@class='lg-menu__text'][text()='Страхование']")
    public WebElement insurance;

    @FindBy(xpath = "(//A[@href='/ru/person/bank_inshure/insuranceprogram/travel_and_shopping'][text()='Путешествия и покупки'][text()='Путешествия и покупки'])[1]")
    public WebElement travelAndShopping;

    @FindBy(xpath = "(//H3[text()='Страхование путешественников'])[1]")
    public WebElement insuranceTraveler;

    @FindBy(xpath = "(//P[@class='kit-button kit-button_color_green kit-button_size_m'])[1]")
    public WebElement makeOnline;

//    public SberbankPersonPage(){
//        PageFactory.initElements(BaseSteps.getDriver(),this);
//    }

    public SberbankPersonPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void clickWebElement(WebElement element) {
        element.click();
    }
}

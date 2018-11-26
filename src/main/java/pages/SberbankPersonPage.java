package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SberbankPersonPage extends BasePage {
    @FindBy(xpath = "//SPAN[@class='lg-menu__text'][text()='Страхование']")
    public WebElement insurance;

    @FindBy(xpath = "(//A[@href='/ru/person/bank_inshure/insuranceprogram/travel_and_shopping'][text()='Путешествия и покупки'][text()='Путешествия и покупки'])[1]")
    public WebElement travelAndShopping;

    @FindBy(xpath = "(//H3[text()='Страхование путешественников'])[1]")
    public WebElement insuranceTraveler;

    @FindBy(xpath = "(//H3[text()='Страхование путешественников'])[1]")
    public WebElement makeOnline;


}

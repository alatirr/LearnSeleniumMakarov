import org.junit.After;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.ArrayList;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

public class SberAutotest {
    public static Properties properties = AppProperties.getInstance().getProperties();
    private static WebDriver driver;
    private static String baseUrl;

    @BeforeClass
    public static void setup() throws Exception{
        System.setProperty("webdriver.chrome.driver", properties.getProperty("webdriver.chrome.driver"));
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        baseUrl = properties.getProperty("app.url");
        driver.get(baseUrl);
    }

    @Test
    public void testRun() throws Exception{
        driver.findElement(By.xpath("//SPAN[@class='lg-menu__text'][text()='Страхование']")).click();
        driver.findElement(By.xpath("(//A[@href='/ru/person/bank_inshure/insuranceprogram/travel_and_shopping'][text()='Путешествия и покупки'][text()='Путешествия и покупки'])[1]")).click();
        assertEquals(true, driver.findElement(By.xpath("(//H3[text()='Страхование путешественников'])[1]")).isDisplayed());
        driver.findElement(By.xpath("(//P[@class='kit-button kit-button_color_green kit-button_size_m'])[1]")).click();
        //Указываем селениуму, что мы переключились на вторую вкладку
        ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        driver.findElement(By.xpath("(//DIV[@ng-click='setProdProg(prodProg)'])[1]")).click();
        driver.findElement(By.xpath("//SPAN[@ng-click='save()'][text()='Оформить']")).click();
        //Данные застрахованного
        fillField(By.name("insured0_surname"), "IVANOV");
        fillField(By.name("insured0_name"), "IVAN");
        fillFieldDate(By.name("insured0_birthDate"), "12121995");
        //Данные страхователя
        fillField(By.name("surname"), "Петров");
        fillField(By.name("name"), "Петя");
        fillField(By.name("middlename"), "Петрович");
        driver.findElement(By.xpath("(//INPUT[@ng-model='formdata.insurer.GENDER'])[1]")).click();
        fillFieldDate(By.name("birthDate"), "11111999");
        fillField(By.xpath("//INPUT[@ng-model='formdata.insurer.documentList[0].DOCSERIES']"), "2222");
        fillField(By.xpath("//INPUT[@ng-model='formdata.insurer.documentList[0].DOCNUMBER']"), "333333");
        fillFieldDate(By.name("issueDate"), "09092009");
        fillField(By.name("issuePlace"), "Московским ОВД");
        //Проверка полей
        assertEquals("IVANOV", driver.findElement(By.name("insured0_surname")).getAttribute("value"));
        assertEquals("IVAN", driver.findElement(By.name("insured0_name")).getAttribute("value"));
        assertEquals("12.12.1995", driver.findElement(By.name("insured0_birthDate")).getAttribute("value"));
        assertEquals("Петров", driver.findElement(By.name("surname")).getAttribute("value"));
        assertEquals("Петя", driver.findElement(By.name("name")).getAttribute("value"));
        assertEquals("Петрович", driver.findElement(By.name("middlename")).getAttribute("value"));
        assertEquals("11.11.1999", driver.findElement(By.name("birthDate")).getAttribute("value"));
        assertEquals(true, driver.findElement(By.xpath("(//INPUT[@ng-model='formdata.insurer.GENDER'])[1]")).isSelected());
        assertEquals("2222", driver.findElement(By.xpath("//INPUT[@ng-model='formdata.insurer.documentList[0].DOCSERIES']")).getAttribute("value"));
        assertEquals("333333", driver.findElement(By.xpath("//INPUT[@ng-model='formdata.insurer.documentList[0].DOCNUMBER']")).getAttribute("value"));
        assertEquals("09.09.2009", driver.findElement(By.name("issueDate")).getAttribute("value"));
        assertEquals("Московским ОВД", driver.findElement(By.name("issuePlace")).getAttribute("value"));

        driver.findElement(By.xpath("//SPAN[@ng-click='save()'][text()='Продолжить']")).click();

        assertEquals(true, driver.findElement(By.xpath("//DIV[@ng-show='tryNext && myForm.$invalid'][text()='Заполнены не все обязательные поля']")).isEnabled());


    }
    @After
    public void tearDown() throws Exception {
        driver.quit();
    }
    //Ввод значения в текстовое поле
    private void fillField(By locator, String value){
        driver.findElement(locator).clear();
        driver.findElement(locator).sendKeys(value);
    }

    //метод для вввода данных в поле формата Date.
    // В связи с тем, что элемент не активен, имитируем, наведение мыши на элемент а затем делаем клик
    private void fillFieldDate(By locator, String value){
        WebElement dateWebElement =  driver.findElement(locator);
        Actions actions = new Actions(driver);
        actions.moveToElement(dateWebElement);
        actions.click();
        actions.sendKeys(value);
        actions.build().perform();
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
    //Проверка сравнивает значение текста у поля ввода со строковой перменной
    protected void checkFillField(String value, By locator) {
        assertEquals(value, driver.findElement(locator).getAttribute("value"));
    }

}



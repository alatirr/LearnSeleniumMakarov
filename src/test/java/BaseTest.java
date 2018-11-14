import org.junit.After;
import org.junit.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

public class BaseTest {
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

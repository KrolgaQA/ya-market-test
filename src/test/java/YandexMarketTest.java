import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class YandexMarketTest {

        WebDriver chromeDriver;
        String baseURL;
        Wait<WebDriver> chromeWait;

        @Before
        public void beforeTest() {
            //Устанавливаем стартовую страницу, драйвер, открываем браузер, переходим в полный экран, переходим на стартовую страницу
            baseURL = "https://yandex.ru/";
            System.setProperty("webdriver.chrome.driver", "drv/chromedriver.exe");
            chromeDriver = new ChromeDriver();
            chromeDriver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
            chromeDriver.manage().window().maximize();
            chromeDriver.get(baseURL);
            //Создаем ожидание
            chromeWait = new WebDriverWait(chromeDriver, 50, 50000);
        }

        @Test
        @Ignore
        public void testFirstScript() throws InterruptedException {
            //Переходим на страницу "Маркет"
            chromeDriver.findElement(By.xpath("//a[contains(@data-id, 'market') and contains(text(), 'Маркет')]")).click();
            chromeDriver.findElement(By.xpath("/html/body/div[5]/div[3]/div/div/div[2]/div[1]/span")).click();
            //Переходим на страницу "Электроника"
            chromeDriver.findElement(By.xpath("//span[contains(@class, 'n-w-tab__control-caption') and contains(text(), 'Электроника')]")).click();
            //Переходим в категорию "Телевизоры"
            chromeDriver.findElement(By.xpath("//a[contains(@class, '_2qvOOvezty _2x2zBaVN-3 _9qbcyI_fyS') and contains(text(), 'Телевизоры')]")).click();
            //Выбираем цену от 20000 р
            fillField(By.name("Цена от"), "20000");
            //Выбираем производителей Samsung, LG
            chromeDriver.findElement(By.xpath("//input[contains(@type, 'checkbox') and contains(@name, 'Производитель Samsung')]")).sendKeys(Keys.SPACE);
            chromeDriver.findElement(By.xpath("//input[contains(@type, 'checkbox') and contains(@name, 'Производитель LG')]")).sendKeys(Keys.SPACE);
            //Проверяем что количество элементов равно 12
            checkCountOfResultElements(12);
            //Находим и запоминаем наименование первого элемента по фильтру
            String itemName = getFirstElementTitle();
            //Заполняем поле поиска наименованием первого элемента из предыдущего шага
            fillField(By.id("header-search"), itemName);
            //Кликаем на поиск
            chromeDriver.findElement(By.className("search2__button")).click();
            //Проверяем, что наименования совпадают
            Assert.assertEquals(itemName, getFirstElementTitle());
        }

    private String getFirstElementTitle() {
        return chromeDriver
                .findElements(By.xpath("//*[starts-with(@id, 'product')]"))
                .get(0)
                .findElement(By.xpath("//div[4]/div[1]/h3/a")).getAttribute("title");
    }

    private void checkCountOfResultElements(int expectedCount) {
        int actualCount = chromeDriver
                .findElements(By.xpath("//*[starts-with(@id, 'product')]")).size();
        Assert.assertEquals(expectedCount, actualCount);
    }

    //Заполнение полей
    public void fillField(By locator, String value) {
        chromeDriver.findElement(locator).clear();
        chromeDriver.findElement(locator).sendKeys(value);
    }


    @After
    public void afterTest() {

        chromeDriver.quit();
    }
}

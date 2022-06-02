import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Website {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver\\chromedriver.exe");

        ChromeOptions options = new ChromeOptions();
        options.addArguments("disable-infobars");
        options.addArguments("start-maximized");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


        //Шаг 1     Открыть ресурс по адресу https://www.avito.ru/

        driver.get("https://www.avito.ru/cheboksary/transport?cd=1");

        //Шаг 2     Выбрать в выпадающем списке “категория”  значение оргтехника и расходники

        WebElement params = driver.findElement(By.xpath("//*[@id=\"category\"]"));
        params.click();
        Select paramsSelect = new Select(driver.findElement(By.xpath("//*[@id=\"category\"]")));
        paramsSelect.selectByVisibleText("Оргтехника и расходники");

        //Шаг 3     В поле поиск по объявлению ввести значение “Принтер”

        driver.findElement(By.xpath("//input[@type='text' and @data-marker='search-form/suggest']"))
                .sendKeys("принтер");

        //Шаг 4     Нажать на поле город

        driver.findElement(By.xpath("//div[@class='main-text-_Thor']")).click();

        //Шаг 5     Заполнить значением “Владивосток” поле город  в открывшемся окне и кликнуть
        // по первому предложенному варианту. Нажать на кнопку “Показать объявления”

        driver.findElement(By.xpath("//input[@data-marker=\"popup-location/region/input\"]")).sendKeys("Владивосток");
        driver.findElement(By.xpath("//strong")).click();
        driver.findElement(By.xpath("//button[@data-marker = \"popup-location/save-button\"] ")).click();

        //Шаг 6     Проверить, активирован ли чекбокс, и если не активирован – активировать и нажать кнопку “Показать объявления”
        driver.manage().timeouts().implicitlyWait(9, TimeUnit.SECONDS);

        WebElement checkbox = driver.findElement(By.cssSelector("[data-marker=\"delivery-filter/text\"]"));
        if (!checkbox.isSelected()) {
            checkbox.click();
            driver.findElement(By.xpath("//button[@data-marker=\"search-filters/submit-button\"]")).click();
        }

        //Шаг 7     В выпадающем списке фильтрации выбрать фильтрацию по убыванию цены.

        Select sortBy = new Select(driver.findElement(By.xpath("(//select[@class = \"select-select-IdfiC\" ]) [last()] ")));
        sortBy.selectByVisibleText("Дороже");

        //Шаг 8     Вывести в консоль название и стоимость 3х самых дорогих принтеров
        List<WebElement> webElementList = driver.findElements(By.xpath("//div[@class=\"iva-item-content-rejJg\"] "));
        for (int i = 0; i < 3; i++) {
            System.out.println("Модель- " +
                    webElementList.get(i).findElement(By.xpath(".//h3[@itemprop =\"name\"]")).getText() +
                    " цена- " +
                    webElementList.get(i).findElement(By.xpath(".//span[@data-marker= \"item-price\"]")).getText()
            );
        }
        driver.quit();

    }
}

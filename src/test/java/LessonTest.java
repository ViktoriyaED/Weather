import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LessonTest {


    //    TC_1_1  - Тест кейс:
    //    1. Открыть страницу https://openweathermap.org/
    //    2. Набрать в строке поиска город Paris
    //    3. Нажать пункт меню Search
    //    4. Из выпадающего списка выбрать Paris, FR
    //    5. Подтвердить, что заголовок изменился на "Paris, FR"

    @Test
    public void testH2TagText_WhenSearchingCityCountry() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Viktoriya\\Desktop\\JAVA\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        String url = "https://openweathermap.org/";
        String cityName = "Paris";
        String expectedResult = "Paris, FR";

        driver.get(url);
        Thread.sleep(5000);

        WebElement searchCityField = driver.findElement(
                By.xpath("//div[@id = 'weather-widget']//input[@placeholder = 'Search city']")
        );
        searchCityField.click();
        searchCityField.sendKeys(cityName);

        WebElement searchButton = driver.findElement(
                By.xpath("//div[@id='weather-widget']//button[@type='submit']\n")
        );
        searchButton.click();

        Thread.sleep(2000);

        WebElement parisFrChoiceInDropDownMenu = driver.findElement(
                By.xpath("//ul[@class=\"search-dropdown-menu\"]//li//span[text() = 'Paris, FR ']")
        );
        parisFrChoiceInDropDownMenu.click();

        WebElement h2CityNameHeader = driver.findElement(By.xpath("//div[@id = 'weather-widget']//h2"));

        Thread.sleep(1000);

        String actualResult = h2CityNameHeader.getText();

        Assert.assertEquals(actualResult, expectedResult);

        driver.quit();
    }

}

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static java.util.concurrent.TimeUnit.SECONDS;

public class ViktoriyaEDTest {

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

//    @Test
//    public void test_name() {
//        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Viktoriya\\Desktop\\JAVA\\chromedriver_win32\\chromedriver.exe");
//        WebDriver driver = new ChromeDriver();
//
//
//        driver.quit();
//    }


//    TC_11_01
//1.  Открыть базовую ссылку
//2.  Нажать на пункт меню Guide
//3.  Подтвердить, что вы перешли на страницу со ссылкой https://openweathermap.org/guide и
// что title этой страницы OpenWeatherMap API guide - OpenWeatherMap

    @Test
    public void testTitleText_WhenChooseMenuGuide() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Viktoriya\\Desktop\\JAVA\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        String url = "https://openweathermap.org/";

        String expectedResult = "OpenWeatherMap API guide - OpenWeatherMap";

        driver.get(url);

        Thread.sleep(5000);

        WebElement clickMenuButton = driver.findElement(By.xpath("//li[@id = 'hamburger']"));

        clickMenuButton.click();

        WebElement pickGuideMenu = driver.findElement(By.xpath("//ul[@id='mobile-menu']//a[@href = '/guide']"));

        pickGuideMenu.click();

//        WebElement titleMenuGuide = driver.findElement(By.xpath("//title"));

//        String actualResult = titleMenuGuide.getText();

        String actualResult = driver.getTitle();

        Assert.assertEquals(actualResult, expectedResult);

        driver.quit();
    }

    // TC_11_01
//1.  Открыть базовую ссылку
//2.  Нажать на пункт меню Guide
//3.  Подтвердить, что вы перешли на страницу со ссылкой https://openweathermap.org/guide и
// что title этой страницы OpenWeatherMap API guide - OpenWeatherMap

    @Test
    public void testTitleText_WhenChooseMenuGuideMazimize() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Viktoriya\\Desktop\\JAVA\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        String url = "https://openweathermap.org/";
        String buttonGuide = "Guide";
        String expectedResult = "https://openweathermap.org/guide";
        String expectedResult1 = "OpenWeatherMap API guide - OpenWeatherMap";

        driver.get(url);

        driver.manage().window().maximize();

        Thread.sleep(5000);

        WebElement GuideMenu = driver.findElement(By.xpath("//a[@href = '/guide']"));

        GuideMenu.click();
//        Assert.assertEquals(GuideMenu, "Guide");

        String actualResult = driver.getCurrentUrl();
        String actualResult1 = driver.getTitle();

        Assert.assertEquals(actualResult, expectedResult);
        Assert.assertEquals(actualResult1, expectedResult1);

        driver.quit();
    }


    // TC_11_02
    //1.  Открыть базовую ссылку
    //2.  Нажать на единицы измерения Imperial: °F, mph
    //3.  Подтвердить, что температура для города показана в Фарингейтах

    @Test
    public void testCheckWeather_WhenChooseFaringate() throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Viktoriya\\Desktop\\JAVA\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        String url = "https://openweathermap.org/";
        Boolean expectedResult = true;

        driver.get(url);

        Thread.sleep(5000);


        WebElement clickWeatherF = driver.findElement(By.xpath("//div[@class='switch-container']/div[3]"));       // correct xPath

        clickWeatherF.click();

        WebElement weatherInF = driver.findElement(By.xpath("//span[@class='heading']"));

        Thread.sleep(2000);

        Boolean actualResult = weatherInF.getText().contains("F");

        Assert.assertEquals(actualResult, expectedResult);

        driver.quit();


    }


    //    TC_11_03
    //   1.  Открыть базовую ссылку
    //   2. Подтвердить, что внизу страницы есть панель с текстом “We use cookies which are essential for the site to work.
    //   We also use non-essential cookies to help us improve our services. Any data collected is anonymised.
    //   You can allow all cookies or manage them individually.”
    //   3. Подтвердить, что на панели внизу страницы есть 2 кнопки “Allow all” и “Manage cookies”

    @Test
    public void testCheckCookiesText() throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Viktoriya\\Desktop\\JAVA\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        String url = "https://openweathermap.org/";

        String expectedResult = "We use cookies which are essential for the site to work. We also use non-essential " +
                "cookies to help us improve our services. Any data collected is anonymised. You can allow all cookies " +
                "or manage them individually.";
        String expectedResult1 = "Allow all";
        String expectedResult3 = "Manage cookies";

        driver.get(url);
        Thread.sleep(5000);
//        Assert.assertEquals(driver.findElement(By.className("stick-footer-panel__container")).isDisplayed());


        WebElement cookiesText = driver.findElement(By.xpath("//div[@id='stick-footer-panel']//p"));

        WebElement allowAllButton = driver.findElement(By.xpath("//div[@id='stick-footer-panel']//button"));

        WebElement manageCookiesButton = driver.findElement(
                By.xpath("//div[@id='stick-footer-panel']//a[@href='/cookies-settings']")
        );
// проверить наличие 2х кнопок

        String actualResult = cookiesText.getText();
        String actualResult1 = allowAllButton.getText();
        String actualResult3 = manageCookiesButton.getText();

        Assert.assertEquals(actualResult, expectedResult);
        Assert.assertEquals(actualResult1, expectedResult1);
        Assert.assertEquals(actualResult3, expectedResult3);

        driver.quit();
    }


//    TC_11_04
//1.  Открыть базовую ссылку
//2.  Подтвердить, что в меню Support есть 3 подменю с названиями “FAQ”, “How to start” и “Ask a question”

    @Test
    public void testSupportDropDownMenu() throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Viktoriya\\Desktop\\JAVA\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        String url = "https://openweathermap.org/";

        String expectedResult = "FAQ";
        String expectedResult1 = "How to start";
        String expectedResult2 = "Ask a question";

        driver.get(url);

        driver.manage().window().maximize();

        Thread.sleep(5000);

        WebElement menuSupportDropDownMenu = driver.findElement(By.xpath("//div[@id='support-dropdown']"));

        menuSupportDropDownMenu.click();

        WebElement dropDownMenuFAQ = driver.findElement(By.xpath("//ul[@id='support-dropdown-menu']//a[@href='/faq']"));
        WebElement dropDownMenuHowToStart = driver.findElement(By.xpath("//ul[@id='support-dropdown-menu']//a[@href='/appid']"));
        WebElement dropDownMenuAskAQuestion = driver.findElement(By.xpath("//ul[@id='support-dropdown-menu']//a[@target='_blank']"));

        String actualResult = dropDownMenuFAQ.getText();
        String actualResult1 = dropDownMenuHowToStart.getText();
        String actualResult2 = dropDownMenuAskAQuestion.getText();

        Assert.assertEquals(actualResult, expectedResult);
        Assert.assertEquals(actualResult1, expectedResult1);
        Assert.assertEquals(actualResult2, expectedResult2);

        driver.quit();
    }


//    TC_11_05
//1. Открыть базовую ссылку
//2. Нажать пункт меню Support → Ask a question
//3. Заполнить поля Email, Subject, Message
//4. Не подтвердив CAPTCHA, нажать кнопку Submit
//5. Подтвердить, что пользователю будет показана ошибка “reCAPTCHA verification failed, please try again.”

    @Test
    public void testClickSubmitWithoutCaptcha() throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Viktoriya\\Desktop\\JAVA\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        String url = "https://openweathermap.org/";

        String emailTest = "tester@test.com";
        String message = "This is test";
        String expectedResult = "reCAPTCHA verification failed, please try again.";

        driver.get(url);

        driver.manage().window().maximize();

        Thread.sleep(5000);

        WebElement menuSupportDropDownMenu = driver.findElement(By.xpath("//div[@id='support-dropdown']"));

        menuSupportDropDownMenu.click();

        WebElement askAQuestionMenu = driver.findElement(By.linkText("Ask a question"));

        askAQuestionMenu.click();

        Thread.sleep(2000);

//        driver.get("https://home.openweathermap.org/questions");

        // Store the current window handle
        String winHandleBefore = driver.getWindowHandle();

        // Switch to new window opened
        for (String winHandle : driver.getWindowHandles()) {
            driver.switchTo().window(winHandle);
        }

        WebElement emailField = driver.findElement(By.id("question_form_email"));

        emailField.click();

        emailField.sendKeys(emailTest);

        Thread.sleep(1000);

        WebElement subjectField = driver.findElement(By.xpath("//select[@id='question_form_subject']"));

        subjectField.click();

        WebElement subjectDropDownChoice = driver.findElement(By.xpath("//select[@id='question_form_subject']//option[text()='Other']"));

        subjectDropDownChoice.click();

        Thread.sleep(1000);

        WebElement messageField = driver.findElement(By.xpath("//textarea[@id='question_form_message']"));

        messageField.sendKeys(message);

        Thread.sleep(1000);

        WebElement submitButton = driver.findElement(By.xpath("//input[@class = 'btn btn-default']"));

        submitButton.click();

        WebElement errorMessage = driver.findElement(By.xpath("//div[@class='help-block']"));

        String actualResult = errorMessage.getText();

        Assert.assertEquals(actualResult, expectedResult);

        driver.quit();
    }


    // TC_11_06
    //1.  Открыть базовую ссылку
    //2.  Нажать пункт меню Support → Ask a question
    //3.  Оставить значение по умолчанию в checkbox Are you an OpenWeather user?
    //4. Оставить пустым поле Email
    //5. Заполнить поля  Subject, Message
    //6. Подтвердить CAPTCHA
    //7. Нажать кнопку Submit
    //8. Подтвердить, что в поле Email пользователю будет показана ошибка “can't be blank”

    @Test
    public void test() throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Viktoriya\\Desktop\\JAVA\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        String url = "https://openweathermap.org/";

        String message = "This is test";
        String expectedResult = "can't be blank";

        driver.get(url);

        driver.manage().window().maximize();

        Thread.sleep(4000);

        WebElement menuSupportDropDownMenu = driver.findElement(By.xpath("//div[@id='support-dropdown']"));

        menuSupportDropDownMenu.click();

        WebElement dropDownMenuAskAQuestion = driver.findElement(By.xpath("//ul[@id='support-dropdown-menu']/li/a[@href='https://home.openweathermap.org/questions']"));

        dropDownMenuAskAQuestion.click();

        Thread.sleep(2000);


        // Store the current window handle
        String winHandleBefore = driver.getWindowHandle();

        // Switch to new window opened
        for (String winHandle : driver.getWindowHandles()) {
            driver.switchTo().window(winHandle);
        }


        //Store the ID of the original window
//        String originalWindow = driver.getWindowHandle();

        //Check we don't have other windows open already
//        assert driver.getWindowHandles().size() == 1;

        //Click the link which opens in a new window
//        driver.findElement(By.linkText("new window")).click();

        //Wait for the new window or tab
//        wait.until(numberOfWindowsToBe(2));

        //Loop through until we find a new window handle
//        for (String windowHandle : driver.getWindowHandles()) {
//            if(!originalWindow.contentEquals(windowHandle)) {
//                driver.switchTo().window(windowHandle);
//                break;
//            }
//        }

        WebElement isUserCheckbox = driver.findElement(By.id("question_form_is_user_true"));
        isUserCheckbox.click();

        WebElement subjectField = driver.findElement(By.xpath("//select[@id='question_form_subject']"));
        subjectField.click();

        WebElement subjectDropDownChoice = driver.findElement(By.xpath("//select[@id='question_form_subject']//option[text()='Other']"));
        subjectDropDownChoice.click();

        WebElement messageField = driver.findElement(By.xpath("//textarea[@id='question_form_message']"));
        messageField.click();
        messageField.sendKeys(message);

        Thread.sleep(1000);

        String window2 = driver.getWindowHandle();
        driver.switchTo().frame(driver.findElement(By.cssSelector("iframe[@title='reCAPTCHA']")));

        WebElement enterCaptcha = driver.findElement(By.xpath("span[@class='recaptcha-checkbox goog-inline-block recaptcha-checkbox-unchecked "
        + "rc-anchor-checkbox']"));
        enterCaptcha.click();

        Thread.sleep(10000);

        driver.switchTo().window(window2);



//
//
//        WebDriverWait wait = new WebDriverWait(driver, 5);
//        WebElement iframeSwitch = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//iframe[@title='reCAPTCHA']")));
//        Thread.sleep(3000);
//        driver.switchTo().frame(iframeSwitch);
//        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='recaptcha-checkbox-border']")));
//        element.click();

//        Thread.sleep(1000);
//        driver.manage().timeouts().pageLoadTimeout(2000, SECONDS);
//        WebElement iframeSwitch = driver.findElement(By.xpath("//iframe[@title='reCAPTCHA']"));
//        Thread.sleep(3000);
//        driver.switchTo().frame(iframeSwitch);
//        WebElement element = driver.findElement(By.id("recaptcha-anchor"));
//        element.click();


//        WebDriverWait wait = new WebDriverWait(driver, 25);
//        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(
//                By.xpath("//iframe[starts-with(@name, 'a-') and starts-with(@src, 'https://www.google.com/recaptcha')]")));
//
//        wait.until(ExpectedConditions.elementToBeClickable(
//                By.xpath("//div[@class='recaptcha-checkbox-border']"))).click();
//        Thread.sleep(5000);




//        Thread.sleep(1000);

        WebElement submitButton = driver.findElement(By.xpath("//input[@class = 'btn btn-default']"));

        submitButton.click();

        WebElement errorMessage = driver.findElement(By.xpath("//div[@class='help-block']"));

        String actualResult = errorMessage.getText();

        Assert.assertEquals(actualResult, expectedResult);

        driver.quit();
    }


// TC_11_07
//1.  Открыть базовую ссылку
//2.  Нажать на единицы измерения Imperial: °F, mph
//
//3.  Нажать на единицы измерения Metric: °C, m/s
//4.  Подтвердить, что в результате этих действий, единицы измерения температуры изменились с F на С

    @Test
    public void testSwitchFahrenheitToCelsius() throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Viktoriya\\Desktop\\JAVA\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        String url = "https://openweathermap.org/";
        boolean expectedResult = true;

        driver.get(url);

        Thread.sleep(5000);

        WebElement weatherFahrenheit = driver.findElement(By.xpath("//div[text()='Imperial: °F, mph']"));
        weatherFahrenheit.click();

        WebElement displayCurrentWeather = driver.findElement(By.xpath("//div[@class='current-temp']/span"));

        boolean actualResult = displayCurrentWeather.getText().contains("°F");
        boolean actualResult1 = displayCurrentWeather.getText().contains("°C");

        Thread.sleep(1000);

        WebElement weatherCelsius = driver.findElement(By.xpath("//div[text()='Metric: °C, m/s']"));
        weatherCelsius.click();

        Thread.sleep(1000);

        Assert.assertEquals(actualResult, expectedResult);
        Assert.assertEquals(actualResult1, expectedResult);

//        Assert.assertTrue(actualResult);
//        Assert.assertTrue(actualResult1);

        driver.quit();
    }

    // TC_11_08
    //1.  Открыть базовую ссылку
    //2.  Нажать на лого компании
    // 3.  Дождаться, когда произойдет перезагрузка сайта, и подтвердить, что текущая ссылка не изменилась

    @Test
    public void testClickOnLogo_URLTheSame() throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Viktoriya\\Desktop\\JAVA\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        String url = "https://openweathermap.org/";
        String expectedResult = "https://openweathermap.org/";

        driver.get(url);

        Thread.sleep(4000);

        WebElement websiteLogo = driver.findElement(By.xpath("//ul[@id='first-level-nav']//a/img"));
        websiteLogo.click();

        String actualResult = driver.getCurrentUrl();
        Assert.assertEquals(actualResult, expectedResult);

        driver.quit();
    }


    // TC_11_09
    //1.  Открыть базовую ссылку
    //2.  В строке поиска в навигационной панели набрать “Rome”
    //
    //3.  Нажать клавишу Enter
    //4.  Подтвердить, что вы перешли на страницу в ссылке которой содержатся слова “find” и “Rome”
    //5. Подтвердить, что в строке поиска на новой странице вписано слово “Rome”

    @Test
    public void testFindRome() throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Viktoriya\\Desktop\\JAVA\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        String url = "https://openweathermap.org/";
        String city = "Rome";
        boolean expectedResult = true;

        driver.get(url);
        driver.manage().window().maximize();

        Thread.sleep(5000);

        WebElement searchFieldByCity = driver.findElement(
                By.xpath("//div[@id='desktop-menu']//input[@placeholder='Weather in your city']")
        );

        searchFieldByCity.click();
        searchFieldByCity.sendKeys(city);
        Thread.sleep(700);
        searchFieldByCity.sendKeys(Keys.ENTER);

        boolean actualResult = driver.getCurrentUrl().contains("find") && driver.getCurrentUrl().contains(city);

        Assert.assertEquals(actualResult, expectedResult);
        driver.quit();
    }


    // TC_11_10
    //1.  Открыть базовую ссылку
    //2.  Нажать на пункт меню API
    //3.  Подтвердить, что на открывшейся странице пользователь видит 30 оранжевых кнопок

    @Test
    public void testAPICheck30Buttons() throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Viktoriya\\Desktop\\JAVA\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        String url = "https://openweathermap.org/";
        int expectedResult = 30;

        driver.get(url);
        driver.manage().window().maximize();
        Thread.sleep(4000);

        WebElement aPIButton = driver.findElement(By.xpath("//div[@id='desktop-menu']//a[@href='/api']"));
        aPIButton.click();

        List<WebElement> orangeButtons29 = driver.findElements(By.xpath("//a[@class='btn_block orange round']"));
        List<WebElement> orangeButtons1 = driver.findElements(By.xpath("//a[@class='ow-btn round btn-orange']"));

        int actualResult = orangeButtons29.size() + orangeButtons1.size();

        Thread.sleep(3000);

        Assert.assertEquals(actualResult, expectedResult);

        driver.quit();
    }
}


//        driver.findElement(By.xpath("//div[@id='support-dropdown']")).click();
//        driver.findElement(By.xpath("//ul[@class='dropdown-menu dropdown-visible']")).isDisplayed();
//        driver.findElement(By.xpath("//div//ul[@id='support-dropdown-menu']//li//a[contains(text(), 'Ask a question')]")).click();
//        List<String> tabs = new ArrayList<>(driver.getWindowHandles());
//        Assert.assertEquals(tabs.size(), 2);
//        driver.switchTo().window(tabs.get(1));
//        WebDriverWait wait = new WebDriverWait(driver, 5);
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("question_form_email")));
//        String currentUrl = driver.getCurrentUrl();
//        Assert.assertEquals(currentUrl, "https://home.openweathermap.org/questions");
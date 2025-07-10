import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class lesson10_Test {
    private final String mainPage = "https://www.facebook.com/";
    private static final Map<String, WebDriver> browsers = new HashMap<>();
    private static final Map<String, String> testData = new HashMap<>();

    @BeforeAll
    static void createHashBrowsers() {
        WebDriverManager.chromedriver().setup();
        WebDriverManager.edgedriver().setup();
        WebDriverManager.firefoxdriver().setup();

        browsers.put("chrome", new ChromeDriver());
        browsers.put("edge", new EdgeDriver());
        browsers.put("firefox", new FirefoxDriver());

        createHashTestData();
    }

    static void createHashTestData() {
        testData.put("emptyString", "");
        testData.put("regularString", "Ferruccio");
        testData.put("longString", "Это очень длинная строка, состоящая из 257 символов. Она может использоваться для тестирования полей ввода, проверки лимитов базы данных или просто как заполнитель. Важно убедиться, что количество символов точно соответствует заданному значению, чтобы тест был корректным и надёжным. Это строка, которая содержит много символов, предназначенных для демонстрации длины. Она может быть полезной в различных сценариях разработки и тестирования, когда требуется строка фиксированной длины для валидации или других целей.");
        testData.put("specialCharactersString", "!@#$%^&*()_+-=");
        testData.put("numbersString", "9876543210");
        testData.put("correctEmail", "correctEmail@correctEmail.com");
        testData.put("incorrectEmail", "correctEmail@correctEmail@gmail.com");
        testData.put("1", "1");
        testData.put("32", "32");
        testData.put("-2", "-2");
        testData.put("1.8", "1.8");
        testData.put("2525", "2525");
        testData.put("13", "13");
        testData.put("0", "0");
        testData.put("1959", "1959");
    }

    public WebDriver getWebDriver(String nameOfBrowser) {
        return browsers.get(nameOfBrowser);
    }

    private WebElement openRegistrationPageAndGetField(WebDriver driver, WebDriverWait wait, String fieldName) {
        driver.get(mainPage);
        WebElement createAccountButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(@data-testid, 'open-registration-form-button')]")));
        createAccountButton.click();
        return driver.findElement(By.name(fieldName));
    }

    @AfterAll
    public static void closeAllDrivers() {
        System.out.println("Closing all drivers...");
        for (WebDriver driver : browsers.values()) {
            if (driver != null) {
                driver.quit();
            }
        }
        browsers.clear();
        testData.clear();
    }

    @ParameterizedTest
    @CsvSource({"chrome", "edge", "firefox"})
    public void openingMainPage(String nameOfBrowser) {
        WebDriver dr = getWebDriver(nameOfBrowser);
        dr.get(mainPage);
        Assertions.assertEquals(dr.getCurrentUrl(), mainPage);
    }

    @ParameterizedTest
    @CsvSource({"chrome", "edge", "firefox"})
    public void openingRegistrationPage(String nameOfBrowser) {
        WebDriver dr = getWebDriver(nameOfBrowser);
        dr.get(mainPage);
        WebDriverWait wait = new WebDriverWait(dr, Duration.ofSeconds(15));

        WebElement createAccountButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(@data-testid, 'open-registration-form-button')]")));
        createAccountButton.click();

        boolean contains = dr.getCurrentUrl().contains(mainPage + "r.php?entry_point=login");
        assertTrue(Boolean.parseBoolean(String.valueOf(contains)));
    }

    @ParameterizedTest
    @CsvSource({"chrome, emptyString", "edge, emptyString", "firefox, emptyString",

            "chrome,regularString", "edge,regularString", "firefox,regularString",

            "chrome,longString", "edge,longString", "firefox,longString",

            "chrome,specialCharactersString", "edge,specialCharactersString", "firefox,specialCharactersString",

            "chrome,numbersString", "edge,numbersString", "firefox,numbersString",})
    public void firstNameTests(String nameOfBrowser, String nameParameter) {
        WebDriver dr = getWebDriver(nameOfBrowser);
        WebDriverWait wait = new WebDriverWait(dr, Duration.ofSeconds(15));

        WebElement inputField = openRegistrationPageAndGetField(dr, wait, "firstname");

        String value = testData.get(nameParameter);
        inputField.sendKeys(value);

        String enteredValue = inputField.getAttribute("value");
        assertEquals(value, enteredValue);
    }

    @ParameterizedTest
    @CsvSource({"chrome, emptyString", "edge, emptyString", "firefox, emptyString",

            "chrome,regularString", "edge,regularString", "firefox,regularString",

            "chrome,longString", "edge,longString", "firefox,longString",

            "chrome,specialCharactersString", "edge,specialCharactersString", "firefox,specialCharactersString",

            "chrome,numbersString", "edge,numbersString", "firefox,numbersString",})
    public void lastNameTests(String nameOfBrowser, String nameParameter) {
        WebDriver dr = getWebDriver(nameOfBrowser);
        WebDriverWait wait = new WebDriverWait(dr, Duration.ofSeconds(15));

        WebElement inputField = openRegistrationPageAndGetField(dr, wait, "lastname");

        String value = testData.get(nameParameter);
        inputField.sendKeys(value);

        String enteredValue = inputField.getAttribute("value");
        assertEquals(value, enteredValue);
    }

    @ParameterizedTest
    @CsvSource({"chrome, emptyString", "edge, emptyString", "firefox, emptyString",

            "chrome,regularString", "edge,regularString", "firefox,regularString",

            "chrome,longString", "edge,longString", "firefox,longString",

            "chrome,specialCharactersString", "edge,specialCharactersString", "firefox,specialCharactersString",

            "chrome,numbersString", "edge,numbersString", "firefox,numbersString",})
    public void passwordTests(String nameOfBrowser, String nameParameter) {

        WebDriver dr = getWebDriver(nameOfBrowser);
        WebDriverWait wait = new WebDriverWait(dr, Duration.ofSeconds(15));

        WebElement inputField = openRegistrationPageAndGetField(dr, wait, "reg_passwd__");

        String value = testData.get(nameParameter);
        inputField.sendKeys(value);

        String enteredValue = inputField.getAttribute("value");
        assertEquals(value, enteredValue);
    }

    @ParameterizedTest
    @CsvSource({"chrome, emptyString", "edge, emptyString", "firefox, emptyString",

            "chrome,regularString", "edge,regularString", "firefox,regularString",

            "chrome,longString", "edge,longString", "firefox,longString",

            "chrome,specialCharactersString", "edge,specialCharactersString", "firefox,specialCharactersString",

            "chrome,numbersString", "edge,numbersString", "firefox,numbersString",

            "chrome,incorrectEmail", "edge,incorrectEmail", "firefox,incorrectEmail",

            "chrome,correctEmail", "edge,correctEmail", "firefox,correctEmail",})
    public void emailTests(String nameOfBrowser, String nameParameter) {
        WebDriver dr = getWebDriver(nameOfBrowser);
        WebDriverWait wait = new WebDriverWait(dr, Duration.ofSeconds(15));

        WebElement inputField = openRegistrationPageAndGetField(dr, wait, "reg_email__");

        String value = testData.get(nameParameter);
        inputField.sendKeys(value);

        String enteredValue = inputField.getAttribute("value");
        assertEquals(value, enteredValue);
    }

    @ParameterizedTest
    @CsvSource({"chrome, 1", "edge, 1", "firefox, 1",

            "chrome,32", "edge,32", "firefox,32",

            "chrome,-2", "edge,-2", "firefox,-2",

            "chrome,1.8", "edge,1.8", "firefox,1.8",

            "chrome,2525", "edge,2525", "firefox,2525",

            "chrome,13", "edge,13", "firefox,13",

            "chrome,0", "edge,0", "firefox,0",

            "chrome,specialCharactersString", "edge,specialCharactersString", "firefox,specialCharactersString",

            "chrome,numbersString", "edge,numbersString", "firefox,numbersString",

            "chrome, emptyString", "edge, emptyString", "firefox, emptyString",})
    public void birthday_dayTests(String nameOfBrowser, String nameParameter) {
        WebDriver dr = getWebDriver(nameOfBrowser);
        WebDriverWait wait = new WebDriverWait(dr, Duration.ofSeconds(15));

        WebElement inputField = openRegistrationPageAndGetField(dr, wait, "birthday_day");
        Select selectField = new Select(inputField);

        String valueToSelect = testData.get(nameParameter);
        try {
            selectField.selectByValue(valueToSelect);
            String selectedValue = selectField.getFirstSelectedOption().getAttribute("value");
            assertEquals(valueToSelect, selectedValue);
        } catch (org.openqa.selenium.NoSuchElementException e) {
            System.out.println("Can not find '" + valueToSelect + "' in  " + nameOfBrowser);
        }
    }

    @ParameterizedTest
    @CsvSource({"chrome, 1", "edge, 1", "firefox, 1",

            "chrome,-2", "edge,-2", "firefox,-2",

            "chrome,1.8", "edge,1.8", "firefox,1.8",

            "chrome,2525", "edge,2525", "firefox,2525",

            "chrome,13", "edge,13", "firefox,13",

            "chrome,0", "edge,0", "firefox,0",

            "chrome,specialCharactersString", "edge,specialCharactersString", "firefox,specialCharactersString",

            "chrome,numbersString", "edge,numbersString", "firefox,numbersString",

            "chrome, emptyString", "edge, emptyString", "firefox, emptyString",})
    public void birthday_monthTests(String nameOfBrowser, String nameParameter) {
        WebDriver dr = getWebDriver(nameOfBrowser);
        WebDriverWait wait = new WebDriverWait(dr, Duration.ofSeconds(15));

        WebElement inputField = openRegistrationPageAndGetField(dr, wait, "birthday_month");
        Select selectField = new Select(inputField);

        String valueToSelect = testData.get(nameParameter);
        try {
            selectField.selectByValue(valueToSelect);
            String selectedValue = selectField.getFirstSelectedOption().getAttribute("value");
            assertEquals(valueToSelect, selectedValue);
        } catch (org.openqa.selenium.NoSuchElementException e) {
            System.out.println("Can not find '" + valueToSelect + "' in  " + nameOfBrowser);
        }
    }

    @ParameterizedTest
    @CsvSource({"chrome, 1", "edge, 1", "firefox, 1",

            "chrome,-2", "edge,-2", "firefox,-2",

            "chrome,1.8", "edge,1.8", "firefox,1.8",

            "chrome,2525", "edge,2525", "firefox,2525",

            "chrome,0", "edge,0", "firefox,0",

            "chrome,specialCharactersString", "edge,specialCharactersString", "firefox,specialCharactersString",

            "chrome,numbersString", "edge,numbersString", "firefox,numbersString",

            "chrome, emptyString", "edge, emptyString", "firefox, emptyString",

            "chrome, 1959", "edge, 1959", "firefox, 1959",})
    public void birthday_yearTests(String nameOfBrowser, String nameParameter) {
        WebDriver dr = getWebDriver(nameOfBrowser);
        WebDriverWait wait = new WebDriverWait(dr, Duration.ofSeconds(15));

        WebElement inputField = openRegistrationPageAndGetField(dr, wait, "birthday_year");
        Select selectField = new Select(inputField);

        String valueToSelect = testData.get(nameParameter);
        try {
            selectField.selectByValue(valueToSelect);
            String selectedValue = selectField.getFirstSelectedOption().getAttribute("value");
            assertEquals(valueToSelect, selectedValue);
        } catch (org.openqa.selenium.NoSuchElementException e) {
            System.out.println("Can not find '" + valueToSelect + "' in  " + nameOfBrowser);
        }
    }

    @ParameterizedTest
    @CsvSource({"chrome, 1", "edge, 1", "firefox, 1",

            "chrome,-2", "edge,-2", "firefox,-2",

            "chrome,1.8", "edge,1.8", "firefox,1.8",

            "chrome,13", "edge,13", "firefox,13",

            "chrome,0", "edge,0", "firefox,0",

            "chrome,specialCharactersString", "edge,specialCharactersString", "firefox,specialCharactersString",

            "chrome,numbersString", "edge,numbersString", "firefox,numbersString",

            "chrome, emptyString", "edge, emptyString", "firefox, emptyString",})
    public void sexTests(String nameOfBrowser, String nameParameter) {
        WebDriver dr = getWebDriver(nameOfBrowser);
        WebDriverWait wait = new WebDriverWait(dr, Duration.ofSeconds(15));

        openRegistrationPageAndGetField(dr, wait, "firstname");

        String valueToSelect = testData.get(nameParameter);

        try {
            WebElement sexRadioButton = dr.findElement(By.xpath("//input[@name='sex' and @value='" + valueToSelect + "']"));
            sexRadioButton.click();

            assertEquals(valueToSelect, sexRadioButton.getAttribute("value"));

        } catch (org.openqa.selenium.NoSuchElementException e) {
            System.out.println("Can not find '" + valueToSelect + "' in  " + nameOfBrowser);
        }
    }
}
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;


public class lesson11_1_Test {
    public final String mainPage = "https://www.facebook.com/";
    private static WebDriver chromeDriver;
    private WebDriverWait wait;

    @BeforeEach
    public void setupDriver() {
        WebDriverManager.chromedriver().setup();
        chromeDriver = new ChromeDriver();

        wait = new WebDriverWait(chromeDriver, Duration.ofSeconds(2));
        chromeDriver.manage().window().maximize();
        chromeDriver.get(mainPage);
    }

    @AfterEach
    public void closeDriver() {
        if (chromeDriver != null) {
            chromeDriver.quit();
        }
    }

    public void openMainPage() {
        chromeDriver.get(mainPage);
    }

    public void openRegistrationPage() {
        openMainPage();

        WebElement createAccountButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(@data-testid, 'open-registration-form-button')]")));
        createAccountButton.click();

        WebElement registerButton = wait.until(ExpectedConditions.elementToBeClickable(chromeDriver.findElement(By.name("websubmit"))));
        registerButton.click();

    }

    @Test
    public void emptyFirstNameTest() {
        openRegistrationPage();
        WebElement nameOfField = chromeDriver.findElement(By.xpath("//*[@name='firstname']"));
        nameOfField.click();

        WebElement messageFieldContainer = chromeDriver.findElement(By.xpath("//*[@data-ownerid='" + nameOfField.getAttribute("id") + "']"));
        WebElement nameOfErrorContainer = messageFieldContainer.findElement(By.xpath(".//div[contains(@class, '_5633 _5634')]"));
        String errorMessageText = nameOfErrorContainer.getText();

        assertNotNull(errorMessageText);
        System.out.println(errorMessageText);
    }

    @Test
    public void emptyLastNameTest() {
        openRegistrationPage();
        WebElement nameOfField = chromeDriver.findElement(By.xpath("//*[@name='lastname']"));
        nameOfField.click();

        WebElement messageFieldContainer = chromeDriver.findElement(By.xpath("//*[@data-ownerid='" + nameOfField.getAttribute("id") + "']"));
        WebElement nameOfErrorContainer = messageFieldContainer.findElement(By.xpath(".//div[contains(@class, '_5633 _5634')]"));
        String errorMessageText = nameOfErrorContainer.getText();

        assertNotNull(errorMessageText);
        System.out.println(errorMessageText);
    }

    @Test
    public void emptyEmailTest() {
        openRegistrationPage();
        WebElement nameOfField = chromeDriver.findElement(By.xpath("//*[@name='reg_email__']"));
        nameOfField.click();

        WebElement messageFieldContainer = chromeDriver.findElement(By.xpath("//*[@data-ownerid='" + nameOfField.getAttribute("id") + "']"));
        WebElement nameOfErrorContainer = messageFieldContainer.findElement(By.xpath(".//div[contains(@class, '_5633 _5634')]"));
        String errorMessageText = nameOfErrorContainer.getText();

        assertNotNull(errorMessageText);
        System.out.println(errorMessageText);
    }

    @Test
    public void emptyPasswordTest() {
        openRegistrationPage();
        WebElement nameOfField = chromeDriver.findElement(By.xpath("//*[@name='reg_passwd__']"));
        nameOfField.click();

        WebElement messageFieldContainer = chromeDriver.findElement(By.xpath("//*[@data-ownerid='" + nameOfField.getAttribute("id") + "']"));
        WebElement nameOfErrorContainer = messageFieldContainer.findElement(By.xpath(".//div[contains(@class, '_5633 _5634')]"));
        String errorMessageText = nameOfErrorContainer.getText();

        assertNotNull(errorMessageText);
        System.out.println(errorMessageText);
    }

    @Test
    public void termsPageTest() {
        openMainPage();
        WebElement termsLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(@href, '/policies?ref=pf')]")));
        termsLink.click();

        String pageUrl = chromeDriver.getCurrentUrl();
        assertTrue(pageUrl.contains("facebook.com/policies_center"));

        System.out.println(pageUrl);
    }

    @Test
    public void privacyPolicyTest() {
        openMainPage();
        WebElement termsLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(@href, '/privacy/policy')]")));
        termsLink.click();

        String pageUrl = chromeDriver.getCurrentUrl();
        assertTrue(pageUrl.contains("facebook.com/privacy/policy"));

        System.out.println(pageUrl);
    }

    @Test
    public void monthsTests() {
        openRegistrationPage();
        WebElement nameOfField = chromeDriver.findElement(By.xpath("//*[@name='birthday_month']"));
        Select selectField = new Select(nameOfField);

        for (int i = 1; i <= 12; i++) {
            String valueToSelect = toString(i);
            try {
                selectField.selectByValue(valueToSelect);
                String selectedValue = selectField.getFirstSelectedOption().getAttribute("value");
                assertEquals(valueToSelect, selectedValue);
                System.out.println(selectedValue);
            } catch (org.openqa.selenium.NoSuchElementException e) {
                System.out.println("Birthday months test. Can`t` find '" + i);
            }
        }
    }

    private String toString(int i) {
        return Integer.toString(i);
    }

    @ParameterizedTest
    @CsvSource({"1905", "1950", "2020"})
    public void yearsTests(String year) {
        openRegistrationPage();
        WebElement nameOfField = chromeDriver.findElement(By.xpath("//*[@name='birthday_year']"));
        Select selectField = new Select(nameOfField);

        try {
            selectField.selectByValue(year);
            String selectedValue = selectField.getFirstSelectedOption().getAttribute("value");
            assertEquals(year, selectedValue);
            System.out.println(selectedValue);
        } catch (org.openqa.selenium.NoSuchElementException e) {
            System.out.println("Birthday year test. Can`t` find '" + year);
        }
    }

    @ParameterizedTest
    @CsvSource({"1", "2","-1"})
    public void sexTests(String valueToSelect) {
        openRegistrationPage();

        try {
            WebElement sexRadioButton = chromeDriver.findElement(By.xpath("//input[@name='sex' and @value='" + valueToSelect + "']"));
            sexRadioButton.click();

            assertEquals(valueToSelect, sexRadioButton.getAttribute("value"));

        } catch (org.openqa.selenium.NoSuchElementException e) {
            System.out.println("SexTests. Can not find '" + valueToSelect);
        }
    }
}



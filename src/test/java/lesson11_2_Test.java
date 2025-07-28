import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

public class lesson11_2_Test {
    public final String mainPage = "https://daviktapes.com/";
    private static WebDriver chromeDriver;
    private WebDriverWait wait;

    @BeforeEach
    public void setupDriver() {
        WebDriverManager.chromedriver().setup();
        chromeDriver = new ChromeDriver();

        wait = new WebDriverWait(chromeDriver, Duration.ofSeconds(5));
        wait.until((ExpectedCondition<Boolean>) wd -> ((JavascriptExecutor) wd).executeScript("return document.readyState").equals("complete"));

        chromeDriver.manage().window().maximize();
        chromeDriver.get(mainPage);
    }

    @AfterEach
    public void closeDriver() {
        if (chromeDriver != null) {
            chromeDriver.quit();
        }
    }

    @Test
    public void openingMainPage() {
        String pageUrl = chromeDriver.getCurrentUrl();
        assertTrue(pageUrl.contains("https://daviktapes.com"));
    }

    //id="menu-item-128" - Home
    //id="menu-item-2997" - Company
    //id="menu-item-134" - Products
    //id="menu-item-132" - Industries
    //id="menu-item-2552" - Knowledge Center
    //id="menu-item-4167" - CONTACT

    @ParameterizedTest
    @CsvSource({"menu-item-128,Home", "menu-item-2997,Company", "menu-item-134,Products", "menu-item-132,Industries", "menu-item-2552,Knowledge Center", "menu-item-4167,Contact"})
    public void navigateToPages(String i, String name) {
        WebElement subMenuElement = null;
        By link = By.id(i);
        WebElement elementToFocus = wait.until(visibilityOfElementLocated(link));
        Actions actions = new Actions(chromeDriver);
        actions.moveToElement(elementToFocus).perform();

        try {
            subMenuElement = wait.until(visibilityOfElementLocated(By.cssSelector("#" + i + " > ul.sub-menu")));
        } catch (org.openqa.selenium.TimeoutException e) {
        }

        String currentName = elementToFocus.findElement(By.xpath("./a")).getText().trim();
        assertNotNull(subMenuElement, "Page: " + currentName + " hasn't a submenu!");
        assertEquals(currentName, name,"Page: "+ currentName + ". There are different names!");
    }
}


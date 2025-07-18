import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

public class lesson11_2_Test {
    public final String mainPage = "https://daviktapes.com/";
    private static WebDriver chromeDriver;
    private WebDriverWait wait;
    private final static List<String> pagesList = new ArrayList<>();

    //id="menu-item-128" - Home
    //id="menu-item-2997" - Company
    //id="menu-item-134" - Products
    //id="menu-item-132" - Industries
    //id="menu-item-2552" - Knowledge Center
    //id="menu-item-4167" - CONTACT

    @BeforeAll
    public static void createPagesList() {
        pagesList.add("menu-item-128");
        pagesList.add("menu-item-2997");
        pagesList.add("menu-item-134");
        pagesList.add("menu-item-132");
        pagesList.add("menu-item-2552");
        pagesList.add("menu-item-4167");
    }

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

    @Test
    public void navigateToPages() {
        for (Object i : pagesList) {
            WebElement subMenuElement = null;
            By link = By.id(i.toString());
            WebElement elementToFocus = wait.until(visibilityOfElementLocated(link));
            Actions actions = new Actions(chromeDriver);
            actions.moveToElement(elementToFocus).perform();

            System.out.println("Page: " + elementToFocus.findElement(By.xpath("./a")).getText());

            try {
                subMenuElement = wait.until(visibilityOfElementLocated(By.cssSelector("#" + i + " > ul.sub-menu")));
            } catch (org.openqa.selenium.TimeoutException e) {
                System.out.println("No submenu!");
            }

            if (subMenuElement != null) {
                List<WebElement> allOptions = subMenuElement.findElements(By.tagName("li"));

                for (WebElement option : allOptions) {
                    WebElement nameOfOption = option.findElement(By.tagName("a"));
                    System.out.println("    " + nameOfOption.getText());
                }
            }
        }
    }
}


import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.*;
import io.qameta.allure.junit4.DisplayName;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import java.util.concurrent.TimeUnit;





public class OtusSearchingTest {



    private WebDriver driver;
    private Steps steps;



    @Test
    @DisplayName("Google search")
    @Description("try to search Otus in Google")
    @Severity(SeverityLevel.CRITICAL)
    @Issue("Issue-666")
    public void googleSearch(){
        steps
                .open("https://www.google.com/")
                .search(By.name("q"), "otus")
                .check(By.cssSelector("div.ellip"), "OTUS - Онлайн-образование");
    }


    @Test
    @DisplayName("Yandex search")
    @Description("try to search Otus in Yandex")
    @Severity(SeverityLevel.NORMAL)
    public void yandexSearch(){
        steps
                .open("https://ya.ru/")
                .search(By.id("text"), "otus")
                .check(By.cssSelector("div.organic__url-text"), "OTUS - Онлайн-образование – Профессиональные курсы");
    }


    @Test
    @DisplayName("Bing search")
    @Description("try to search Otus in Bing")
    @Severity(SeverityLevel.MINOR)
    public void bingSearch(){
        steps
                .open("https://www.bing.com/")
                .search(By.name("q"), "otus")
                .check(By.cssSelector("li.b_algo h2"), "OTUS - Онлайн-образование");
    }


    @Test
    @DisplayName("Rambler search")
    @Description("try to search Otus in Rambler")
    @Severity(SeverityLevel.TRIVIAL)
    public void ramblerSearch(){
        steps
                .open("https://www.rambler.ru/")
                .search(By.name("query"), "otus")
                .switchTab()
                .check(By.cssSelector("div.b-serp-item h2"), "OTUS - Онлайн-образование");
    }




    @BeforeClass
    public static void beforeClass(){
        WebDriverManager.chromedriver().setup();
    }

    @Before
    public void before(){
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(4L, TimeUnit.SECONDS);
        steps = new Steps(driver);
    }

    @After
    public void after(){
        Helper.saveScreenshot(driver);
        if (driver != null) {
            driver.quit();
        }
    }
}

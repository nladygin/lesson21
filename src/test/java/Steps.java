import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertEquals;

public class Steps {

    private WebDriver driver;

    public Steps(WebDriver driver){
        this.driver = driver;
    }

    @Step("Open url \"{url}\"")
    public Steps open(String url){
        driver.get(url);
        return this;
    }

    @Step("Search \"{query}\"")
    public Steps search(By locator, String query){
        driver.findElement(locator).sendKeys(query + Keys.ENTER);
        return this;
    }

    @Step("Check the first result is \"{expected}\"")
    public void check(By locator, String expected){
        assertEquals(expected, driver.findElements(locator).get(0).getText());
    }

}

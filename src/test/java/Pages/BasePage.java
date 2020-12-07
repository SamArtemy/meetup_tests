package Pages;

import com.codeborne.selenide.SelenideWait;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class BasePage {

    private SelenideWait wait;
    public final String HOST = "localhost:3000";

    public void waitTillUrlContain(String urlFragment, int timeout) {
        wait = new SelenideWait(WebDriverRunner.getWebDriver(), timeout, 500);
        wait.until(ExpectedConditions.urlContains(urlFragment));
    }
}

package BaseTest;


import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.selenide.AllureSelenide;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URI;
import java.util.Set;

import static com.codeborne.selenide.Selenide.close;
import static com.codeborne.selenide.Selenide.open;

public class BaseTest {

    private String os = System.getProperty("os");
    public Logger logger = LoggerFactory.getLogger(BaseTest.class);

    @BeforeClass
    public void setUp() {
        createWebDriver();
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide().screenshots(true).savePageSource(false));
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        SelenideLogger.removeListener("AllureSelenide");
        close();
    }

    @BeforeMethod
    public void logTestStart(Method m) {
        logger.info("Start test " + m.getName());
    }

    @AfterMethod(alwaysRun = true)
    public void logTestStop(Method m) {
        logger.info("Stop test " + m.getName());
    }

    public void createWebDriver() {
        logger.debug("Start create webdriver");
        logger.debug("System env SELENIUM_URL is " + System.getenv("SELENIUM_URL"));
        logger.debug("System property OS is " + os);
        String remoteUrl = System.getenv("SELENIUM_URL");
        if (remoteUrl != null) {
            DesiredCapabilities browser = new DesiredCapabilities();
            browser.setBrowserName("chrome");
            browser.setVersion("73.0");
            browser.setCapability("enableVNC", true);

            try {
                RemoteWebDriver driver = new RemoteWebDriver(
                        URI.create(remoteUrl).toURL(), browser
                );
                driver.manage().window().setSize(new Dimension(1440, 900));
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        }
        Configuration.browser = "chrome";
        Configuration.screenshots = false;
        Configuration.timeout = 8000;
        Configuration.startMaximized = true;
        WebDriverManager.chromedriver().version("79.0.3945.36").setup();
        open();
    }

    public void switchToNewTab() {
        Set<String> allWindows = WebDriverRunner.getWebDriver().getWindowHandles();
        for (String curWindow : allWindows) {
            WebDriverRunner.getWebDriver().switchTo().window(curWindow);
        }
    }
}
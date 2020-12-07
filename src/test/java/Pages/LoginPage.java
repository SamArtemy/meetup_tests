package Pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class LoginPage extends BasePage {

    private SelenideElement elementH2 =
            $(By.xpath("//h2"));

    private SelenideElement inputLogin =
            $(By.id("user_email"));

    private SelenideElement inputPassword =
            $(By.name("user[password]"));

    private SelenideElement buttonLogin =
            $(By.name("commit"));

    private SelenideElement alert =
            $(By.xpath("//div[contains(@class, 'alert')]"));



    public void assertisVisibleAlert(){
        alert.shouldHave(Condition.visible);
        alert.waitUntil(Condition.visible, 5000);
    }

    public void assertIsTextAlert(String expectedText){
        alert.shouldHave(Condition.text(expectedText));
    }

    public void clickButtonLogin(){
        buttonLogin.click();
    }

    @Step("Открыть страницу")
    public void openBlogLogin(String url) {
        open(HOST + url);
    }
    public void waitTillUrlContain(String urlFragment) {
        waitTillUrlContain(urlFragment, 3000);
    }

    public void assertIsVisibleH2() {
        elementH2.shouldHave(Condition.visible);
    }

    public void assertIsTextH2(String expectedText) {
        elementH2.shouldHave(Condition.text(expectedText));
    }

    public void assertIsVisibleInputLogin() {
        inputLogin.shouldHave(Condition.visible);
    }

    public void assertIsEmptyInputLogin() {
        inputLogin.shouldHave(Condition.empty);
    }

    public void assertIsVisibleInputPassword() {
        inputPassword.shouldHave(Condition.visible);
    }

    public void assertIsEmptyInputPassword() {
        inputPassword.shouldHave(Condition.empty);
    }

    public void assertIsVisibleButtonLogin() {
        buttonLogin.shouldHave(Condition.visible);
        buttonLogin.val();
    }

    public void setInputLogin(String expectedText){
        inputLogin.sendKeys(expectedText);
    }

    public void setInputPassword(String expectedText){
        inputPassword.sendKeys(expectedText);
    }


}

package Pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationPage extends BasePage {

    private SelenideElement elementH2 =
            $(By.xpath("//h2"));

    private SelenideElement inputLogin =
            $(By.id("user_email"));

    private SelenideElement inputPassword =
            $(By.name("user[password]"));

    private SelenideElement buttonRegistration =
            $(By.name("commit"));

    private SelenideElement alert =
            $(By.xpath("//div[contains(@class, 'alert')]"));

    private SelenideElement inputConfirmationPassword =
            $(By.id("user_password_confirmation"));

    private SelenideElement confirmAccount=
            $(By.xpath("//a[contains(text(), 'Confirm my account')]"));

    public void clickConfirmAccount(){
        confirmAccount.waitUntil(Condition.visible, 5000);
        confirmAccount.hover();
        confirmAccount.click();
    }

    public void assertisVisibleAlert(){
        alert.shouldHave(Condition.visible);
    }

    public void assertIsTextAlert(String expectedText){
        alert.shouldHave(Condition.text(expectedText));
    }

    public void clickButtonRegistration(){
        buttonRegistration.click();
    }

    @Step("Открыть страницу")
    public void openBlogRegistration(String url) {
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
    public void assertIsVisibleInputConPassword() {
        inputConfirmationPassword.shouldHave(Condition.visible);
    }

    public void assertIsEmptyInputConPassword() {
        inputConfirmationPassword.shouldHave(Condition.empty);
    }

    public void assertIsVisibleButtonRegistration() {
        buttonRegistration.shouldHave(Condition.visible);
    }

    public void setInputLogin(String expectedText){
        inputLogin.sendKeys(expectedText);
    }

    public void setInputPassword(String expectedText){
        inputPassword.sendKeys(expectedText);
    }

    public void setInputConfirmationPasswordPassword(String expectedText){
        inputConfirmationPassword.sendKeys(expectedText);
    }


}

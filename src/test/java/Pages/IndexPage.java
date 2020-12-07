package Pages;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.*;

public class IndexPage extends BasePage {

    private SelenideElement navbar =
            $(By.xpath("//ul[contains(@class, 'navbar-nav')]"));

    private SelenideElement navBarRight =
            $(By.xpath("//ul[contains(@class, 'navbar-nav pull-right')]"));

    private SelenideElement linkPosts =
            navbar.$(By.xpath("//a[contains(@class, 'nav-link')]"));

    private SelenideElement linkLogin =
            navBarRight.find(By.xpath("(//a[contains(@class, 'nav-link')])[3]"));

    private SelenideElement linkRegistration =
            navBarRight.find(By.xpath("(//a[contains(@class, 'nav-link')])[4]"));

    private ElementsCollection blockPost =
            $$(By.xpath("//article[contains(@class, 'post')]"));

    private SelenideElement buttonNewPost =
            $(By.xpath("//a[contains(@class, 'btn btn-outline-primary pull-right')]"));

    private SelenideElement linkDeletePost =
            $(By.xpath("(//a[contains(@data-method, 'delete')])[1]"));

    private SelenideElement linkUpdatePost =
            $(By.xpath("(//a[contains(text(), 'Изменить')])[1]"));

    @Step("Клик на кнопку Вход")
    public void clickButtonLogin(){
        linkLogin.click();
    }

    @Step("Клик на кнопку Вход")
    public void clickButtonRegistration(){
        linkRegistration.click();
    }

    @Step("Клик на кнопку Новая статья")
    public void clickButtonCreatePost(){
        buttonNewPost.click();
    }

    @Step("Проверка ленты постов")
    public void assertIsBlockPostsSize(int size){
        blockPost.shouldHave(CollectionCondition.sizeGreaterThanOrEqual(size));
    }

    @Step("Открыть первую страницу")
    public void openBlog() {
        open(HOST);
    }

    @Step("Проверка, что кнопка создать пост видна")
    public void assertVisibleButtonCreatePost() {
        buttonNewPost.shouldHave(Condition.visible);
    }

    @Step("Значение из кнопки создать вакансию")
    public void assertIsTextButtonNewPost(String expectedText) {
        buttonNewPost.shouldHave(Condition.text(expectedText));
    }

    @Step("Проверка, что линк статьи виден")
    public void assertVisibleLinkPosts() {
        linkPosts.shouldHave(Condition.visible);
    }

    @Step("Значение из линка статьи")
    public void assertIsTextLinkPosts(String expectedText) {
        linkPosts.shouldHave(Condition.text(expectedText));
    }

    @Step("Проверка, что линк login виден")
    public void assertVisibleLinkLogin() {
        linkLogin.shouldHave(Condition.visible);
    }

    @Step("Значение из линка login")
    public void assertIsTextLinkLogin(String expectedText) {
        linkLogin.shouldHave(Condition.text(expectedText));
    }

    @Step("Проверка, что линк registration виден")
    public void assertVisibleLinkRegistration() {
        linkRegistration.shouldHave(Condition.visible);
    }

    @Step("Значение из линка registration")
    public void assertIsTextLinkRegistration(String expectedText) {
        linkRegistration.shouldHave(Condition.text(expectedText));
    }
}

package BlogTests;

import BaseTest.BaseTest;
import Pages.IndexPage;
import Pages.LoginPage;
import org.testng.annotations.Test;

public class IndexTests extends BaseTest {

    @Test(description = "Проверка всех элементов на странице")
    public void visibleElementsIndexPage(){
        IndexPage indexPage = new IndexPage();

        indexPage.openBlog();


        indexPage.assertVisibleLinkPosts();
        indexPage.assertIsTextLinkPosts("Статьи");
        indexPage.assertVisibleButtonCreatePost();
        indexPage.assertIsTextButtonNewPost("Новая статья");
        indexPage.assertVisibleLinkLogin();
        indexPage.assertIsTextLinkLogin("Вход");
        indexPage.assertVisibleLinkRegistration();
        indexPage.assertIsTextLinkRegistration("Регистрация");
        indexPage.assertIsBlockPostsSize(10);
    }

    @Test(description = "Клик на кнопку Вход")
    public void clickButtonLogin(){
        IndexPage indexPage = new IndexPage();
        LoginPage loginPage = new LoginPage();

        indexPage.openBlog();
        indexPage.clickButtonLogin();

        loginPage.waitTillUrlContain("users/sign_in");
        loginPage.assertIsVisibleH2();
        loginPage.assertIsTextH2("Вход");









    }


}

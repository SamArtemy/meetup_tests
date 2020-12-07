package BlogTests;


import BaseTest.BaseTest;
import Pages.IndexPage;
import Pages.LoginPage;
import org.kohsuke.rngom.parse.host.Base;
import org.testng.annotations.Test;

public class PostTests extends BaseTest {

    @Test(description = "Проверка страницы new_post")
    public void visibleElementsNewPostPage(){
        LoginPage loginPage  = new LoginPage();
        IndexPage indexPage = new IndexPage();

        loginPage.openBlogLogin("/users/sign_in");
        indexPage.clickButtonCreatePost();
        loginPage.setInputLogin("user01@gmail.com");
        loginPage.setInputPassword("123456");
        loginPage.clickButtonLogin();








    }


}
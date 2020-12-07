package BlogTests;


import BaseTest.BaseTest;
import Pages.IndexPage;
import Pages.LoginPage;
import com.codeborne.selenide.Selenide;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest {

    @AfterMethod
    private void clearCookies() {
        Selenide.close();
    }

    @Test(description = "Проверка элементов на странице Log in")
    public void pageLoginVisibleElements(){
        IndexPage indexPage = new IndexPage();
        LoginPage loginPage = new LoginPage();

        indexPage.openBlog();
        indexPage.clickButtonCreatePost();
        indexPage.clickButtonLogin();
        loginPage.waitTillUrlContain("users/sign_in");
        loginPage.assertIsVisibleH2();
        loginPage.assertIsTextH2("Log in");
        loginPage.assertIsVisibleInputLogin();
        loginPage.assertIsEmptyInputLogin();
        loginPage.assertIsVisibleInputPassword();
        loginPage.assertIsEmptyInputPassword();
        loginPage.assertIsVisibleButtonLogin();
    }

    @Test(description =  "авторизация c невалидными данными")
    public void authNoVavidateUser(){
        LoginPage loginPage = new LoginPage();

        loginPage.openBlogLogin("/users/sign_in");
        loginPage.setInputLogin("user01@gmail.com");
        loginPage.setInputPassword("123457");
        loginPage.clickButtonLogin();

        loginPage.assertisVisibleAlert();
        loginPage.assertIsTextAlert("Неверный Email или пароль.");
    }

    @Test(description =  "авторизация c валидными данными")
    public void authVavidateUser(){
        LoginPage loginPage = new LoginPage();

        loginPage.openBlogLogin("/users/sign_in");
        loginPage.setInputLogin("user01@gmail.com");
        loginPage.setInputPassword("123456");
        loginPage.clickButtonLogin();


        loginPage.assertisVisibleAlert();
        loginPage.assertIsTextAlert("Вход в систему выполнен.");
    }



}

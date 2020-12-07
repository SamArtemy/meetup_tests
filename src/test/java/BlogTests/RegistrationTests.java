package BlogTests;

import BaseTest.BaseTest;
import Pages.IndexPage;
import Pages.RegistrationPage;
import com.codeborne.selenide.Selenide;
import org.testng.annotations.Test;

import java.nio.file.Path;
import java.nio.file.Paths;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.url;

public class RegistrationTests  extends BaseTest {

    @Test(description = "Проверка элементов на странице Log in")
    public void pageLoginVisibleElements(){
        IndexPage indexPage = new IndexPage();
        RegistrationPage registrationPage = new RegistrationPage();

        indexPage.openBlog();
        indexPage.clickButtonRegistration();
        registrationPage.waitTillUrlContain("users/sign_up");
        registrationPage.assertIsVisibleH2();
        registrationPage.assertIsTextH2("Регистрация");
        registrationPage.assertIsVisibleInputLogin();
        registrationPage.assertIsEmptyInputLogin();
        registrationPage.assertIsVisibleInputPassword();
        registrationPage.assertIsEmptyInputPassword();
        registrationPage.assertIsVisibleInputConPassword();
        registrationPage.assertIsEmptyInputConPassword();
        registrationPage.assertIsVisibleButtonRegistration();

    }

    @Test(description = "Регистрация с валидными данными")
    public void registrationUser(){

        RegistrationPage registrationPage = new RegistrationPage();

        registrationPage.openBlogRegistration("/users/sign_up");
        registrationPage.setInputLogin("user50@mail.ru");
        registrationPage.setInputPassword("123456");
        registrationPage.setInputConfirmationPasswordPassword("123456");
        registrationPage.clickButtonRegistration();

        registrationPage.assertisVisibleAlert();
        registrationPage.assertIsTextAlert("В течение нескольких минут вы получите письмо" +
                " с инструкциями по подтверждению вашей учётной записи");



    }


}

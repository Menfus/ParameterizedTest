package guru_qa;

import Components.LoginPage;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.openqa.selenium.support.pagefactory.Annotations;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.*;


public class ValueSourceTest {

    @BeforeEach
    void setUp(){
        open("https://www.kinopoisk.ru/");
    }


    @ValueSource(strings = {
            "Главная", "Билеты в кино"
    })
    @ParameterizedTest(name = "При нажатии кнопки c значением {0}, присутствует и функционирует -Button- Войти")
    @Tag("WEB")
    void checkResultsClickSideBarShouldButtonLogin(String buttonLogin) {
        $$("ul li a").filter(visible).findBy(text(buttonLogin)).click();
        $(".styles_loginButton__LWZQp").shouldHave(text("Войти")).click();
    }
}
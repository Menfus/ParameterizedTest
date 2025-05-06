package guru.qa;

import Components.AirBnbPage;
import com.codeborne.selenide.Configuration;
import guru.qa.data.Language;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byTagAndText;
import static com.codeborne.selenide.Selenide.*;


public class EnumSourceTest {
    AirBnbPage airBnbPage = new AirBnbPage();
    @BeforeAll
    static void paramBrowser() {
        Configuration.browserSize = "1920x1080";
        Configuration.timeout = 60000;
    }


    @EnumSource(Language.class) //Проведи тест для каждого объекта в энаме
    @ParameterizedTest(name = "Проверка функциональности смены языка в Web форме")
    @Tag("WEB")
    void SiteShouldDisplayCorrectText(Language language) {
        open("https://www.airbnb.ru//");
        //executeJavaScript("$(by(.c1qme1pd atm_9s_1txwivl atm_ar_1bp4okc atm_h_1h6ojuz fajtpdg atm_2d_9rdmi7 atm_ks_15vqwwr dir dir-ltr').remove()");

        airBnbPage.clickButtonGlobal();
        $(byTagAndText("div", language.name())).click();
        $("h2").shouldHave(text(language.description));


    }
}
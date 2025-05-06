package guru.qa;

import Components.AirBnbPage;
import com.codeborne.selenide.Configuration;
import guru.qa.data.Language;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.by;
import static com.codeborne.selenide.Selectors.byTagAndText;
import static com.codeborne.selenide.Selenide.*;


public class MethodSourceTest {
    AirBnbPage airBnbPage = new AirBnbPage();

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.holdBrowserOpen = true;
        Configuration.timeout = 60000;
    }


    static Stream<Arguments> airBnbSiteShouldDisplayCorrectButtons() {
        return Stream.of(
                Arguments.of(
                        Language.Dansk,
                        List.of("Hvor som helst", "Alle uge")
                ),


                Arguments.of(
                        Language.Català,
                        List.of("Allotjaments", "Experiències")

        )
        );
    }

    @MethodSource
    @ParameterizedTest
    void airBnbSiteShouldDisplayCorrectButtons(Language language, List<String> expectedButtons) {
        open("https://www.airbnb.ru//");
        airBnbPage.clickButtonGlobal();
        $("data-testid, QA_EXPLORE_HEADER").shouldHave(text(expectedButtons.toString()));
    }
}




package Components;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.by;
import static com.codeborne.selenide.Selenide.*;

public class AirBnbPage {
    private  SelenideElement buttonGlobalization = $(by("aria-label", "Выбрать язык и валюту"));

    public AirBnbPage clickButtonGlobal () {
        buttonGlobalization.click();
        return this;
    }
}

package Components;
import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.*;


public class LoginPage {
    private SelenideElement loginInput = $("#userName"),
    passwordInput =  $("#password"),
    buttonLogin = $("#login");




public LoginPage setLogin (String value) {
    loginInput.setValue(value);
    return this;
}

public LoginPage setPassword (String value) {
    passwordInput.setValue(value);
    return this;
    }

public LoginPage clickButtonLogin () {
    buttonLogin.click();
    return this;
}
}


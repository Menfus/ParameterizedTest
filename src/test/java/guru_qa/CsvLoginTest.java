package guru_qa;
import Components.LoginPage;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;



import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.*;


@DisplayName("Web - Тест на экран авторизации")
public class CsvLoginTest {
    LoginPage loginPage = new LoginPage();



    //Faker faker = new Faker(); String password = faker.internet().password(8, 16);

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        baseUrl = "https://demoqa.com/login/";
    }

    @BeforeEach
    void setUp(){
        open(baseUrl);
                }



    @CsvSource(value = {
            "MenfuSSS369, 89091015433, false",
            "Menfus, G7@rT3x!qL9$wZ8m. , true",
    })

    @ParameterizedTest(name = "При условии False мы проверяем валидацию Авторизации")
    @Tag("Web")
    @DisplayName("Start")
    void testLogin(String username, String password, boolean shouldLogin) {

        //Заполняем форму Авторизации
      loginPage.setLogin(username)
              .setPassword(password)
              .clickButtonLogin();

        // Проверяем результат
        if (shouldLogin) {
            // Ожидаем, что пользователь успешно вошел
            $("#userName-value").shouldHave(text("Menfus"));
        } else {
            // Ожидаем, что отображается ошибка
            $("#name").shouldHave(text("Invalid username or password!"));
        }
    }
}




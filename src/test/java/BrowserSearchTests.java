import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class BrowserSearchTests {

    @Test
    void googleSearchTest() {
        // Открыть google
        open("https://google.com");

        // Ввести Selenide в поиск
        $(byName("q")).setValue("Selenide").pressEnter();

        // Проверить, что Selenide появился в результатах поиска
        $("html").shouldHave(text("selenide.org"));
    }

    @Test
    void yandexSearchTest() {
        open("https://yandex.ru");

        $(".input__control").setValue("Selenide").pressEnter();

        $("html").shouldHave(text("Selenide"));
    }
}

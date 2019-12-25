package cucumberStep;

import com.codeborne.selenide.Configuration;
import io.cucumber.java.ru.Дано;
import io.cucumber.java.ru.Затем;
import io.cucumber.java.ru.Когда;
import org.openqa.selenium.By;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThanOrEqual;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class GoogleSearchStepDefinitions {
    private String keyword;


    @Дано("отрыть гугл google.com")
    public void отрытьГуглGoogleCom() {
        Configuration.reportsFolder = "target/surefire-reports";
        open("https://google.com/ncr");

    }

    @Когда("введи слово {string} в поле")
    public void введиСловоВПоле(String keyword) {
        this.keyword = keyword;
        $(By.name("q")).val(keyword).pressEnter();
    }

    @Затем("должно быть совпадение {int} изображения")
    public void должноБытьСовпадениеИзображения(int resultsCount) {
        $$("#res .g").shouldHave(sizeGreaterThanOrEqual(resultsCount));
    }

    @Затем("первый содержит слово {string}")
    public void первыйСодержитСлово(String expectedText) {
        $("#res .g").shouldHave(text(expectedText));
    }
}

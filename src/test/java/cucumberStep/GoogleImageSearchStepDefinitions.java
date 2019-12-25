package cucumberStep;

import io.cucumber.java.ru.Затем;
import io.cucumber.java.ru.И;
import io.cucumber.java.ru.Когда;
import org.openqa.selenium.By;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThanOrEqual;
import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class GoogleImageSearchStepDefinitions {
    String keyword;


    @Когда("кликаю по ссылке картинки")
    public void кликаюПоСсылкеКартинки() {
        $(byText("Images")).click();
    }

    @И("введи слово {string}")
    public void введиСлово(String keyword) {
        this.keyword = keyword;
        $(By.name("q")).val(keyword).pressEnter();
    }

    @Затем("покажи {int} изображений")
    public void покажиИзображений(int resultsCount) {
        $$(".rg_di.rg_el").shouldHave(sizeGreaterThanOrEqual(resultsCount));
        $(".rg_di.rg_el").find("img.rg_i").shouldHave(attribute("alt", "Image result for " + keyword));
    }
}

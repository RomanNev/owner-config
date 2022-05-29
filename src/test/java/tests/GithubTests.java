package tests;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class GithubTests extends TestBase {

    @Test
    @Tag("web")
    void shouldFindInGithub() {
        //открыть страницу Selenide в Github
        open("https://github.com/selenide/selenide");
        // Перейдите в раздел Wiki проекта
        $("#wiki-tab").click();
        // в списке страниц (Pages) есть страница
        $("#wiki-pages-filter").setValue("SoftAssertions").pressEnter();
        $$("[data-filterable-for=wiki-pages-filter]").findBy(text("SoftAssertions")).click();
        // внутри есть пример кода для JUnit5
        $(".markdown-body > h4:nth-child(18)").shouldHave(text("Using JUnit5 extend test class:"));

    }
}

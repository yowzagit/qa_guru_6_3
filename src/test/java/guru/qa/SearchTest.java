package test;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selenide.*;

public class SearchTest {

    /**
     * @BeforAll
     * @BeforeEach
     * @Test
     * @AfterEach
     * @BeforeEach
     * @Test
     * @AfterEach
     * @AfterAll
     */

    static Logger logger = LoggerFactory.getLogger(SearchTest.class);

    @BeforeAll
    static void setUpConfig() {
        logger.info("@BeforeAll");
        Configuration.browser = "chrome";
        Configuration.startMaximized = true;
    }

    @BeforeEach
    void openGooglePage() {
        logger.info("@BeforeEach");
        open("https://www.google.com");
    }

    @AfterEach
    void closeBrowser() {
        logger.info("@AfterEach");
        closeWebDriver();
    }

    @Test
    void wikipediaSearchTest() {
        $(byName("q")).setValue("Wikipedia").pressEnter();
        $("#search").shouldHave(text("Wikipedia.org"));
    }

    @Test
    void selenideSearchTest() {
        $(byName("q")).setValue("Selenide").pressEnter();
        $("#search").shouldHave(text("selenide.org"));
    }

    @Test
    void allureSearchTest() {
        $(byName("q")).setValue("Allure testops").pressEnter();
        $("#search").shouldHave(text("qameta.io"));
    }

}
package heroku.tests;

import core.BaseTests;
import io.qameta.allure.*;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.fail;

@DisplayName("Manual tests suit")
public class ManualTests extends BaseTests {

    @Test()
    @Link("https://example.org")
    @Link(name = "allure", type = "mylink")
    @Issue("https://www.google.com/")
    @TmsLink("https://www.youtube.com/")
    @DisplayName("Manual test")
    @Description("DescriptionDescriptionDescriptionDescriptionDescriptionDescriptionDescriptionDescription")
    @Owner("Serega")
    @Severity(value = SeverityLevel.BLOCKER)
    public void manualTest() {
        step("Opening page");
        step("Entering text");
        step("Clicking search button");
    }

    @Disabled("reason: task №1613")
    @Test
    @DisplayName("Disabled test")
    public void disabledTest() {}

    @Test
    public void failedTest() {
        fail();
    }

    @Epic("WEB")
    @Feature("Contact page")
    @Test
    public void test3() {}

    @Epic("WEB")
    @Feature("Main page")
    @Story("Login")
    @Test
    public void test4() {}

    @Epic("WEB")
    @Feature("Main page")
    @Story("Search")
    @Test
    public void test5() {}

    @Epic("MOBILE")
    @Feature("Landing")
    @Story("App promoting")
    @Test
    public void test1() {}

    @Epic("MOBILE")
    @Feature("Landing")
    @Story("Promo text")
    @Test
    public void test2() {}
}

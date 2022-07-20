package heroku.tests;

import core.BaseTests;
import io.qameta.allure.*;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Manual tests suit")
public class ManualTests extends BaseTests {

    @Test()
    @Link("https://example.org")
    @Link(name = "allure", type = "mylink")
    @Issue("https://www.google.com/")
    @TmsLink("https://www.google.com/")
    @DisplayName("First manual test")
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
    public void disabledTest() {
        step("Opening page");
        step("Entering text");
        step("Clicking search button");
    }

    @Epic("Epic")
    @Test
    public void epicTest1() {}

    @Epic("Epic")
    @Test
    public void epicTest2() {}

    @Feature("Feature")
    @Test
    public void featureTest1() {}

    @Feature("Feature")
    @Test
    public void featureTest2() {}

    @Story("Story")
    @Test
    public void storyTest1() {}

    @Story("Story")
    @Test
    public void storyTest2() {}
}

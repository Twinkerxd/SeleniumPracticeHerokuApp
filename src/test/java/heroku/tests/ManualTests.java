package heroku.tests;

import core.BaseTests;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class ManualTests extends BaseTests {
    @Disabled("Название теста")
    @Test
    public void newTest() {
        // do something
        stepMethod();
    }

    @Step
    public void stepMethod() {
        System.out.println("Cześć");
    }
}

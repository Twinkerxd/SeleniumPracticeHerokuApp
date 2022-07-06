package core;

import org.openqa.selenium.WebDriver;

public class BaseSeleniumPage extends BaseSeleniumTests {
    protected static WebDriver driver;

    public static void setDriver(WebDriver webDriver) {
        driver = webDriver;
    }
}

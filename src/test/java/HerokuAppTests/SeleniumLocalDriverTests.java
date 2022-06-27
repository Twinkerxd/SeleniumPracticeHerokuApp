package HerokuAppTests;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumLocalDriverTests {

    @Test
    public void openPage() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "E:\\Soft\\chromedriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/");
        Thread.sleep(2000);
        driver.quit();
    }
}

package pages;

import core.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;

public class MultipleWindowsPage extends BasePage {
    @FindBy(xpath = "//a[@href='/windows/new']") private WebElement clickHereButton;
    @FindBy(xpath = "//h3") private WebElement header;

    public MultipleWindowsPage() {
        PageFactory.initElements(driver, this);
    }

    @Step("Clicking clickhere button")
    public MultipleWindowsPage clickClickHereButton() {
        clickHereButton.click();
        return this;
    }

    public ArrayList<String> getAllTabs() {
        return new ArrayList<>(driver.getWindowHandles());
    }

    @Step("Getting header text")
    public String getHeader() {
        return header.getText();
    }

    @Step("Closing tab")
    public MultipleWindowsPage closeTab() {
        driver.close();
        return this;
    }
}
